package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeSpec
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.model.UnitsDisplayNamesForLocale
import net.codinux.i18n.model.UnitsMetadata
import net.codinux.i18n.parser.CldrJsonParser

class AvailableUnitDisplayNamesClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val locales = cldrJsonParser.getLocalesWithLocalizedUnits().map { LanguageTag.ofAvailable(it) }

        val allByLocale = locales.associateWith { cldrJsonParser.parseUnitNamesForLocale(it) }

        val metadata = cldrJsonParser.parseUnitsMetadata()
        // TODO: also parse unitConstants (some contain conversion factors e.g. from feet to meter)?
        generateUnitTypesEnum(metadata)

        generateUnitPrefixesEnum(metadata)

        generateAvailableUnitDisplayNameKeysEnum(allByLocale)
    }


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
        val prefixesMapped = prefixes.associateBy({ it.name }, { it.symbol to (it.power2?.let { "2p$it" } ?: it.power10!!.let { "10p$it" })})
            .toMutableMap().apply { putAll(listOf(
                "Square" to ("²" to "1p2"),
                "Cubic" to ("³" to "1p3"),
            ))}


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


        util.writeEnumClass("UnitPrefix", enumConstants, constructor, subPackage = "units")
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


        util.writeEnumClass("UnitDisplayNameKey", enumConstants, constructor, subPackage = "units")
    }
}