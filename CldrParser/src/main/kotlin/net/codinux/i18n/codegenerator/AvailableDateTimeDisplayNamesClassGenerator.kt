package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import net.codinux.csv.use
import net.codinux.csv.writer.CsvWriter
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.datetime.DateTimeDisplayNamesLookup
import net.codinux.i18n.datetime.LocalizedDateTimeFormatsResolver
import net.codinux.i18n.model.*
import net.codinux.i18n.parser.CldrJsonParser

class AvailableDateTimeDisplayNamesClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    class UniqueValues<T>(
        val formatWide: T?, val formatAbbreviated: T?, val formatNarrow: T?, val formatShort: T?,
        val standAloneWide: T?, val standAloneAbbreviated: T?, val standAloneNarrow: T?, val standAloneShort: T?
    ) {
        constructor(names: AllDisplayNames<T>) : this(names.format.wide, names.format.abbreviated, names.format.narrow, names.format.short,
            names.standAlone.wide, names.standAlone.abbreviated, names.standAlone.narrow, names.standAlone.short)

        fun allValuesNull(standalone: Boolean) =
            if (standalone) standAloneWide == null && standAloneAbbreviated == null && standAloneNarrow == null && standAloneShort == null
            else formatWide == null && formatAbbreviated ==  null && formatNarrow == null && formatShort == null

    }


    private val csvWriter = CsvWriter.builder(LocalizedDateTimeFormatsResolver.CsvFormatsSeparator)


    fun generate() {
        val locales = cldrJsonParser.getLocalesWithLocalizedDateTimeFormats().map { LanguageTag.ofAvailable(it) }

        val formatsByLocale = locales.associateWith { cldrJsonParser.parseDateTimeFormatsForLocale(it) }

        // don't add date time formats redundantly, if they have the same format as in parent locale, don't add them to file but look them up in parent locale
        val uniqueMonthsByLocale = removeRedundantValuesFromSubLocales(formatsByLocale.mapValues { it.value.months })
        val uniqueDaysByLocale = removeRedundantValuesFromSubLocales(formatsByLocale.mapValues { it.value.days })
        val uniqueQuartersByLocale = removeRedundantValuesFromSubLocales(formatsByLocale.mapValues { it.value.quarters })
        val uniqueDayPeriodsByLocale = removeRedundantValuesFromSubLocales(formatsByLocale.mapValues { it.value.dayPeriods }) { one, two ->
            one?.am == two?.am && one?.pm == two?.pm && one?.midnight == two?.midnight && one?.noon == two?.noon
        }
//        val uniqueErasByLocale = removeRedundantValuesFromSubLocales(formatsByLocale.mapValues { it.value.eras })

        val formatsProperties = formatsByLocale.keys.flatMap { locale ->
            listOf(generateMonthsProperty(locale, uniqueMonthsByLocale[locale]!!, false), generateDaysProperty(locale, uniqueDaysByLocale[locale]!!, false),
                generateQuartersProperty(locale, uniqueQuartersByLocale[locale]!!, false), generateDayPeriodsProperty(locale, uniqueDayPeriodsByLocale[locale]!!, false),
                generateMonthsProperty(locale, uniqueMonthsByLocale[locale]!!, true), generateDaysProperty(locale, uniqueDaysByLocale[locale]!!, true),
                generateQuartersProperty(locale, uniqueQuartersByLocale[locale]!!, true), generateDayPeriodsProperty(locale, uniqueDayPeriodsByLocale[locale]!!, true),
            )
        }


        // method to find all date time display names of a LanguageTag
        val getLocalizedDisplayNamesMethods = listOf(generateGetLocalizedDisplayNamesMethod(formatsByLocale, false),
            generateGetLocalizedDisplayNamesMethod(formatsByLocale, true))

        util.writeClass("AvailableDateTimeDisplayNames", formatsProperties, subPackage = "datetime", companionObjectMethods = getLocalizedDisplayNamesMethods)
    }


    private fun generateGetLocalizedDisplayNamesMethod(formatsByLocale: Map<LanguageTag, DateAndTimeFormats>, forStandalone: Boolean): FunSpec =
        FunSpec.builder("getLocalized${if (forStandalone) "Standalone" else "Format"}DisplayNames")
            .addParameter("languageTag", String::class)
            .returns(DateTimeDisplayNamesLookup::class)
            .apply {
                beginControlFlow("return when(languageTag) {")
                formatsByLocale.forEach { (languageTag, _) ->
                    val baseName = languageTag.tag.replace('-', '_') + "_" + (if (forStandalone) "Standalone" else "Format") + "_"
                    addStatement("%S -> %T(%N, %N, %N, %N, %L)", languageTag.tag, DateTimeDisplayNamesLookup::class, baseName + "Months", baseName + "Days", baseName + "Quarters", baseName + "DayPeriods", "null")
                }
                addStatement("else -> %T(%L, %L, %L, %L, %L)", DateTimeDisplayNamesLookup::class, "null", "null", "null", "null", "null")
                endControlFlow()
            }.build()


    private fun generateMonthsProperty(locale: LanguageTag, displayNames: UniqueValues<MonthDisplayNames>, standalone: Boolean): PropertySpec {
        return generateProperty(locale, displayNames, standalone, "Months") { names ->
            listOf(names.january, names.february, names.march, names.april, names.may, names.june, names.july,
            names.august, names.september, names.october, names.november, names.december)
        }
    }

    private fun generateDaysProperty(locale: LanguageTag, displayNames: UniqueValues<DayDisplayNames>, standalone: Boolean): PropertySpec {
        return generateProperty(locale, displayNames, standalone, "Days") { names ->
            listOf(names.monday, names.tuesday, names.wednesday, names.thursday,
                names.friday, names.saturday, names.sunday)
        }
    }

    private fun generateQuartersProperty(locale: LanguageTag, displayNames: UniqueValues<QuarterDisplayNames>, standalone: Boolean): PropertySpec {
        return generateProperty(locale, displayNames, standalone, "Quarters") { names ->
            listOf(names.first, names.second, names.third, names.fourth)
        }
    }

    private fun generateDayPeriodsProperty(locale: LanguageTag, displayNames: UniqueValues<DayPeriodDisplayNames>, standalone: Boolean): PropertySpec {
        return generateProperty(locale, displayNames, standalone, "DayPeriods") { names ->
            listOf(names.am, names.pm, names.midnight, names.noon)
        }
    }

    private fun generateErasProperty(locale: LanguageTag, displayNames: UniqueValues<EraDisplayNames>, standalone: Boolean): PropertySpec {
        return generateProperty(locale, displayNames, standalone, "Eras") { names ->
            listOf(names.gregoryInverse, names.gregoryInverseVariant, names.gregory, names.gregoryVariant)
        }
    }

    private fun <T> generateProperty(locale: LanguageTag, displayNames: UniqueValues<T>, standalone: Boolean, name: String, getCsvRow: (T) -> List<String?>): PropertySpec {
        val property = PropertySpec.builder(locale.tag.replace('-', '_') +
                "_" + (if (standalone) "Standalone" else "Format") + "_" + name,
            String::class.asTypeName().copy(nullable = displayNames.allValuesNull(standalone)))
            .addModifiers(KModifier.PRIVATE)

        return if (displayNames.allValuesNull(standalone)) {
            property.initializer("%L", "null")
        } else {
            val csv = StringBuilder()
            csvWriter.writer(csv).use { csvWriter ->
                if (standalone) {
                    appendRow(csvWriter, displayNames.standAloneWide, getCsvRow)
                    appendRow(csvWriter, displayNames.standAloneAbbreviated, getCsvRow)
                    appendRow(csvWriter, displayNames.standAloneNarrow, getCsvRow)
                } else {
                    appendRow(csvWriter, displayNames.formatWide, getCsvRow)
                    appendRow(csvWriter, displayNames.formatAbbreviated, getCsvRow)
                    appendRow(csvWriter, displayNames.formatNarrow, getCsvRow)
                }
            }

            property.addModifiers(KModifier.CONST)
                .initializer("%S", csv.toString())
//                .initializer(buildCodeBlock {
//                    val lines = csv.toString().split("\r\n")
//                    lines.forEachIndexed { index, line ->
//                        val isLast = index == lines.lastIndex
//                        addStatement("${if (index == 0) "" else "    "}%S${if (isLast) "" else " +"}", line)
//                    }
//                })
        }.build()
    }

    private fun <T> appendRow(writer: CsvWriter, names: T?, getCsvRow: (T) -> List<String?>) {
        if (names == null) {
            writer.writeRow()
        } else {
            writer.writeRow(*getCsvRow(names).toTypedArray())
        }
    }

    private fun <T> removeRedundantValuesFromSubLocales(formatsByLocale: Map<LanguageTag, AllDisplayNames<T>>, compare: ((T?, T?) -> Boolean)? = null): Map<LanguageTag, UniqueValues<T>> {

        return formatsByLocale.mapValues { (languageTag, displayNames) ->
            if (languageTag == LanguageTag.Root) {
                UniqueValues(displayNames)
            } else {
                val parent = languageTag.parent ?: LanguageTag.Root // date times have to be resolved up to root
                filterRedundantValues(formatsByLocale, parent, displayNames, compare)
            }
        }
    }

    private fun <T> filterRedundantValues(
        formatsByLocale: Map<LanguageTag, AllDisplayNames<T>>,
        parentLanguageTag: LanguageTag,
        displayNames: AllDisplayNames<T>,
        customCompare: ((T?, T?) -> Boolean)? = null
    ): UniqueValues<T> {
        val parentFormats = formatsByLocale[parentLanguageTag] ?: formatsByLocale[parentLanguageTag.parent] // e.g. "ca-ES" has no explicit mapping -> go directly to "ca", ...
        if (parentFormats == null) {
            return UniqueValues(displayNames)
        }

        val allFormatsEqual = compare(displayNames.format.wide, parentFormats.format.wide, customCompare)
                && compare(displayNames.format.abbreviated, parentFormats.format.abbreviated, customCompare)
                && compare(displayNames.format.narrow, parentFormats.format.narrow, customCompare)
                && compare(displayNames.format.short, parentFormats.format.short, customCompare)
        val allStandalonesEqual = compare(displayNames.standAlone.wide, parentFormats.standAlone.wide, customCompare)
                && compare(displayNames.standAlone.abbreviated, parentFormats.standAlone.abbreviated, customCompare)
                && compare(displayNames.standAlone.narrow, parentFormats.standAlone.narrow, customCompare)
                && compare(displayNames.standAlone.short, parentFormats.standAlone.short, customCompare)

        return UniqueValues(
            if (allFormatsEqual) null else displayNames.format.wide,
            if (allFormatsEqual) null else displayNames.format.abbreviated,
            if (allFormatsEqual) null else displayNames.format.narrow,
            if (allFormatsEqual) null else displayNames.format.short,
            if (allStandalonesEqual) null else displayNames.standAlone.wide,
            if (allStandalonesEqual) null else displayNames.standAlone.abbreviated,
            if (allStandalonesEqual) null else displayNames.standAlone.narrow,
            if (allStandalonesEqual) null else displayNames.standAlone.short,
        )
    }

    private fun <T> compare(names: T, parentNames: T, customCompare: ((T?, T?) -> Boolean)?): Boolean =
        if (customCompare != null) {
            customCompare(names, parentNames)
        } else {
            names == parentNames
        }

}