package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import net.codinux.csv.use
import net.codinux.csv.writer.CsvWriter
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.model.*
import net.codinux.i18n.unit.UnitDisplayNamesResolver
import net.codinux.i18n.parser.CldrJsonParser
import net.codinux.i18n.unit.UnitDisplayNameKey
import net.codinux.i18n.unit.UnitDisplayNamesResolver.Companion.CubicKey
import net.codinux.i18n.unit.UnitDisplayNamesResolver.Companion.PerKey
import net.codinux.i18n.unit.UnitDisplayNamesResolver.Companion.SquareKey
import net.codinux.i18n.unit.UnitDisplayNamesResolver.Companion.TimesKey

class AvailableUnitDisplayNamesClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    private data class UniqueValuesForLocale(
        val long: UniqueValues?,
        val short: UniqueValues?,
        val narrow: UniqueValues?
    ) {
        constructor(displayNames: UnitsDisplayNamesForLocale)
                : this(UniqueValues(displayNames.long), UniqueValues(displayNames.short), UniqueValues(displayNames.narrow))
    }

    private data class UniqueValues(
        val units: List<UnitDisplayName>?,

        val prefixPatterns: List<UnitPattern>?,
        val powerPatterns: List<UnitPattern>?,
        val compoundPatterns: List<CompoundUnitPattern>?
    ) {
        constructor(displayNames: UnitsLocaleDisplayNames)
                : this(displayNames.units, displayNames.prefixPatterns, displayNames.powerPatterns, displayNames.compoundPatterns)
    }


    private val csvWriter = CsvWriter.builder(UnitDisplayNamesResolver.CsvFormatsSeparator)


    fun generate() {
        val locales = cldrJsonParser.getLocalesWithLocalizedUnits().map { LanguageTag.ofAvailable(it) }

        val allByLocale = locales.associateWith { cldrJsonParser.parseUnitNamesForLocale(it) }

        val metadata = cldrJsonParser.parseUnitsMetadata()
        // TODO: also parse unitConstants (some contain conversion factors e.g. from feet to meter)?
        generateUnitTypesEnum(metadata)

        generateUnitPrefixesEnum(metadata)

        generateAvailableUnitDisplayNameKeysEnum(allByLocale)


        // don't add display names redundantly, if they have the same values as in parent locale, don't add them to file but look them up in parent locale
        val uniqueDisplayNamesByLocale = removeRedundantValuesFromSubLocales(allByLocale)

        val unitPatternsProperties = uniqueDisplayNamesByLocale.flatMap { (locale, displayNames) ->
            listOf(generateUnitDisplayNamesProperty(locale, displayNames),
                generatePrefixDisplayNamesProperty(locale, displayNames))
        }

        // method to find all display names of a LanguageTag
        val getDisplayNamesForLocale = FunSpec.builder("getDisplayNamesForLocale")
            .addParameter("language", String::class)
            .returns(Pair::class.parameterizedBy(String::class, String::class))
            .apply {
                beginControlFlow("return when(language) {")
                allByLocale.forEach { (languageTag, _) ->
                    val baseName = languageTag.tag.replace('-', '_') + "_"
                    addStatement("%S -> %T(%N ?: \"\", %N ?: \"\")", languageTag.tag, Pair::class, baseName + "Units", baseName + "Prefixes")
                }
                addStatement("else -> %T(%S, %S)", Pair::class, "", "")
                endControlFlow()
            }.build()


        util.writeClass("AvailableUnitDisplayNames", unitPatternsProperties, subPackage = "unit", companionObjectMethods = listOf(getDisplayNamesForLocale))
    }


    private fun generateUnitDisplayNamesProperty(locale: LanguageTag, displayNames: UniqueValuesForLocale): PropertySpec {
        val csv = generateUnitDisplayNamesCsv(displayNames)
        val isNull = csv.isBlank()

        return PropertySpec.builder(locale.tag.replace('-', '_') + "_Units", String::class.asTypeName().copy(nullable = isNull))
            .addModifiers(KModifier.PRIVATE)
            .apply {
                if (isNull) {
                    initializer("null")
                } else {
                    delegate(CodeBlock.builder()
                        .beginControlFlow("lazy")
                        .addStatement("\"\"\"%L\"\"\".trimIndent()", csv)
                        .endControlFlow()
                        .build())
                }
            }
            .build()
    }


    private fun generateUnitDisplayNamesCsv(displayNames: UniqueValuesForLocale): String {
        val csv = StringBuilder()
        csvWriter.writer(csv).use { csvWriter ->
            val longByName = displayNames.long?.units.orEmpty().associateBy { it.unit }
            val shortByName = displayNames.short?.units.orEmpty().associateBy { it.unit }
            val narrowByName = displayNames.narrow?.units.orEmpty().associateBy { it.unit }
            val allNames = longByName.keys + shortByName.keys + narrowByName.keys

            allNames.forEach { name ->
                csvWriter.writeRow(name,
                    value(narrowByName[name]?.displayName), value(narrowByName[name]?.perUnitPattern), value(narrowByName[name]?.unitPatternCountOne), value(narrowByName[name]?.unitPatternCountOther),
                    shortByName[name]?.displayName, shortByName[name]?.perUnitPattern, value(shortByName[name]?.unitPatternCountOne), value(shortByName[name]?.unitPatternCountOther),
                    longByName[name]?.displayName, longByName[name]?.perUnitPattern, value(longByName[name]?.unitPatternCountOne), value(longByName[name]?.unitPatternCountOther)
                )
            }
        }

        return csv.toString()
    }

    // make narrow values like '{0}"' or '" ර' serializable
    private fun value(value: String?) =
//        value?.replace("\"", "\\\"")
        // i got no nerves anymore, it seems to be impossible to tell Kotlin Poet 'don't touch % and "', it screws up
        // either of both, so i decided to replace " incorrectly with two '
        value?.replace("\"", "\'\'")
//        value?.replace("\"", "${'"'}")

    private fun generatePrefixDisplayNamesProperty(locale: LanguageTag, displayNames: UniqueValuesForLocale): PropertySpec {
        val csv = generatePrefixesDisplayNamesCsv(displayNames)
        val isNull = csv.isBlank()

        return PropertySpec.builder(locale.tag.replace('-', '_') + "_Prefixes", String::class.asTypeName().copy(nullable = isNull))
            .addModifiers(KModifier.PRIVATE)
            .apply {
                if (isNull) {
                    initializer("null")
                } else {
                    delegate(CodeBlock.builder()
                        .beginControlFlow("lazy")
                        .addStatement("\"\"\"%L\"\"\".trimIndent()", csv)
                        .endControlFlow()
                        .build())
                }
            }
            .build()
    }

    private fun generatePrefixesDisplayNamesCsv(displayNames: UniqueValuesForLocale): String {
        val csv = StringBuilder()
        csvWriter.writer(csv).use { csvWriter ->
            val squarePatterns = listOf(getPattern(displayNames.narrow?.powerPatterns, "power2"), getPattern(displayNames.short?.powerPatterns, "power2"), getPattern(displayNames.long?.powerPatterns, "power2"))
            if (squarePatterns.any { it != null }) {
                csvWriter.writeRow(SquareKey, *squarePatterns.toTypedArray())
            }
            val cubicPatterns = listOf(getPattern(displayNames.narrow?.powerPatterns, "power3"), getPattern(displayNames.short?.powerPatterns, "power3"), getPattern(displayNames.long?.powerPatterns, "power3"))
            if (cubicPatterns.any { it != null }) {
                csvWriter.writeRow(CubicKey, *cubicPatterns.toTypedArray())
            }

            val timesPatterns = listOf(getPattern(displayNames.narrow?.compoundPatterns, "times"), getPattern(displayNames.short?.compoundPatterns, "times"), getPattern(displayNames.long?.compoundPatterns, "times"))
            if (timesPatterns.any { it != null }) {
                csvWriter.writeRow(TimesKey, *timesPatterns.toTypedArray())
            }
            val perPatterns = listOf(getPattern(displayNames.narrow?.compoundPatterns, "per"), getPattern(displayNames.short?.compoundPatterns, "per"), getPattern(displayNames.long?.compoundPatterns, "per"))
            if (perPatterns.any { it != null }) {
                csvWriter.writeRow(PerKey, *perPatterns.toTypedArray())
            }

            val longByName = displayNames.long?.prefixPatterns.orEmpty().associateBy { it.unit }
            val shortByName = displayNames.short?.prefixPatterns.orEmpty().associateBy { it.unit }
            val narrowByName = displayNames.narrow?.prefixPatterns.orEmpty().associateBy { it.unit }
            val allNames = (longByName.keys + shortByName.keys + narrowByName.keys).sorted()

            allNames.forEach { name ->
                csvWriter.writeRow(name, narrowByName[name]?.unitPattern, shortByName[name]?.unitPattern, longByName[name]?.unitPattern)
            }
        }

        return csv.toString()
    }

    private fun getPattern(patterns: List<UnitPattern>?, unit: String) =
        patterns?.firstOrNull { it.unit == unit }?.unitPattern


    private fun generateUnitTypesEnum(metadata: UnitsMetadata) {
        val baseUnits = metadata.unitQuantities
        val unitTypes = baseUnits.map { it.unitType }.toSet().sorted()
        val convertUnitsByBaseUnit = metadata.convertUnits.groupBy({ it.baseUnit }, { it.name })

        val unitsByType = unitTypes.associateWith { type -> baseUnits.filter { it.unitType == type }.map { it.name }.let {
            (it + it.flatMap { convertUnitsByBaseUnit[it] ?: emptyList() }).toSet().sorted()
        } }


        val constructor = FunSpec.constructorBuilder()
            .addParameter("type", String::class, false)
            .addParameter("units", List::class.parameterizedBy(String::class), false)
            .build()

        val enumConstants = unitsByType.toSortedMap().mapNotNull { (type, unitsWithOfThisType) ->
            type to TypeSpec.anonymousClassBuilder()
                .addSuperclassConstructorParameter("%S", type)
                .addNullableSuperclassConstructorParameter(unitsWithOfThisType)
                .build()
        }


        util.writeEnumClass("UnitType", enumConstants, constructor, subPackage = "units")
    }

    private fun generateUnitPrefixesEnum(metadata: UnitsMetadata) {
        val prefixes = metadata.unitPrefixes
        val prefixesMapped = prefixes.associateBy({ it.name }, { it.symbol to (it.power2?.let { "1024p${it / 10}" } ?: it.power10!!.let { "10p$it" })})


        val constructor = FunSpec.constructorBuilder()
            .addParameter("symbol", String::class, false)
            .addParameter("conversionFactor", String::class, false)
            .build()

        val enumConstants = prefixesMapped.toSortedMap().mapNotNull { (name, symbolAndPower) ->
            name to TypeSpec.anonymousClassBuilder()
                .addSuperclassConstructorParameter("%S", symbolAndPower.first)
                .addSuperclassConstructorParameter("%S", symbolAndPower.second)
                .build()
        }


        // method to get a UnitPrefix enum value by conversionFactor
        val getUnitPrefixForConversionFactor = FunSpec.builder("forConversionFactor")
            .addParameter("conversionFactor", String::class)
            .returns(UnitPrefix::class)
            .addStatement("return %T.entries.first { it.conversionFactor == conversionFactor }", UnitPrefix::class)
            .build()


        util.writeEnumClass("UnitPrefix", enumConstants, constructor, null, listOf(getUnitPrefixForConversionFactor), subPackage = "units")
    }


    private fun generateAvailableUnitDisplayNameKeysEnum(allByLocale: Map<LanguageTag, UnitsDisplayNamesForLocale>) {
        val englishNames = allByLocale[LanguageTag.English]!!.long.units.associateBy({ it.unit }, { it.displayName })
        val all = allByLocale.values
        val allUnitNames = all.flatMap { it.long.units.map { it.unit } + it.short.units.map { it.unit } + it.narrow.units.map { it.unit } }
            .toSet().sorted()


        val constructor = FunSpec.constructorBuilder()
            .addParameter("key", String::class, false)
            .addParameter("englishName", String::class, true)
            .build()

        val enumConstants = allUnitNames.map { unitName ->
            val enumName = unitName.replace("concentr-", "concentration-")

            enumName to TypeSpec.anonymousClassBuilder()
                .addSuperclassConstructorParameter("%S", unitName)
                .addNullableSuperclassConstructorParameter(englishNames[unitName])
                .build()
        }


        // method to get a UnitDisplayNameKey enum value by key
        val getUnitDisplayNameKeyForKey = FunSpec.builder("forKey")
            .addParameter("key", String::class)
            .returns(UnitDisplayNameKey::class)
            .addStatement("return %T.entries.first { it.key == key }", UnitDisplayNameKey::class)
            .build()


        util.writeEnumClass("UnitDisplayNameKey", enumConstants, constructor, null, listOf(getUnitDisplayNameKeyForKey), subPackage = "units")
    }


    private fun removeRedundantValuesFromSubLocales(allByLocale: Map<LanguageTag, UnitsDisplayNamesForLocale>): Map<LanguageTag, UniqueValuesForLocale> {

        return allByLocale.mapValues { (languageTag, displayNames) ->
            if (languageTag == LanguageTag.Root) {
                UniqueValuesForLocale(displayNames)
            } else {
                val parent = languageTag.parent ?: LanguageTag.Root // date times have to be resolved up to root
                filterRedundantValues(allByLocale, parent, displayNames)
            }
        }
    }

    private fun filterRedundantValues(
        allByLocale: Map<LanguageTag, UnitsDisplayNamesForLocale>,
        parentLanguageTag: LanguageTag,
        displayNames: UnitsDisplayNamesForLocale
    ): UniqueValuesForLocale {
        val parentDisplayNames = allByLocale[parentLanguageTag] ?: allByLocale[parentLanguageTag.parent] // e.g. "ca-ES" has no explicit mapping -> go directly to "ca", ...
        if (parentDisplayNames == null) {
            return UniqueValuesForLocale(displayNames)
        }

        val long = filterRedundantValues(displayNames.long, parentDisplayNames.long)
        val short = filterRedundantValues(displayNames.short, parentDisplayNames.short)
        val narrow = filterRedundantValues(displayNames.narrow, parentDisplayNames.narrow)

        return UniqueValuesForLocale(long, short, narrow)
    }

    private fun filterRedundantValues(displayNames: UnitsLocaleDisplayNames, parentDisplayNames: UnitsLocaleDisplayNames): UniqueValues? {
        val units = displayNames.units.filter { unit ->
            val parentUnit = parentDisplayNames.units.firstOrNull { it.unit == unit.unit }
            parentUnit == null || unit.displayName != parentUnit.displayName || unit.perUnitPattern != parentUnit.perUnitPattern ||
                    unit.unitPatternCountOne != parentUnit.unitPatternCountOne || unit.unitPatternCountOther != parentUnit.unitPatternCountOther
        }

        val prefixPatterns = displayNames.prefixPatterns.filter { prefix ->
            val parentPrefix = parentDisplayNames.prefixPatterns.first { it.unit == prefix.unit }
            prefix.unitPattern != parentPrefix.unitPattern
        }

        val powerPatterns = displayNames.powerPatterns.filter { power ->
            val parentPower = parentDisplayNames.powerPatterns.first { it.unit == power.unit }
            power.unitPattern != parentPower.unitPattern
        }

        val compoundPatterns = displayNames.compoundPatterns.filter { compound ->
            val parentCompound = parentDisplayNames.compoundPatterns.first { it.unit == compound.unit }
            compound.unitPattern != parentCompound.unitPattern
        }

        return UniqueValues(units, prefixPatterns, powerPatterns, compoundPatterns)
    }

}