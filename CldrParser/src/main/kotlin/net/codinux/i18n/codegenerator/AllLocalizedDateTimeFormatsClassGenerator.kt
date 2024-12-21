package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.asTypeName
import net.codinux.csv.use
import net.codinux.csv.writer.CsvWriter
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.datetime.LocalizedDateTimeFormatsLookup
import net.codinux.i18n.datetime.LocalizedDateTimeFormatsResolver
import net.codinux.i18n.model.DateAndTimeFormats
import net.codinux.i18n.datetime.DateOrTimeFormats
import net.codinux.i18n.model.DateTimeFormats
import net.codinux.i18n.parser.CldrJsonParser

class AllLocalizedDateTimeFormatsClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    private val csvWriter = CsvWriter.builder(LocalizedDateTimeFormatsResolver.CsvFormatsSeparator)


    fun generate() {
        val locales = cldrJsonParser.getLocalesWithLocalizedDateTimeFormats().map { LanguageTag.ofAvailable(it) }

        val formatsByLocale = locales.associateWith { cldrJsonParser.parseDateTimeFormatsForLocale(it) }

        // don't add date time formats redundantly, if they have the same format as in parent locale, don't add them to file but look them up in parent locale
        val uniqueFormatsByLocale = removeRedundantValuesFromSubLocales(formatsByLocale)

        val formatsProperties = uniqueFormatsByLocale.flatMap { (locale, formats) ->
            listOf(generateProperty(locale, formats.first, "Date"), generateProperty(locale, formats.second, "Time"),
                generateProperty(locale, formats.third, "DateTime"))
        }


        // method to find all date time formats of a LanguageTag
        val getFormatsForLocaleMethod = FunSpec.builder("getDateTimeFormatsForLocale")
            .addParameter("language", String::class)
            .returns(LocalizedDateTimeFormatsLookup::class)
            .apply {
                beginControlFlow("return when(language) {")
                uniqueFormatsByLocale.forEach { (languageTag, _) ->
                    val baseName = languageTag.tag.replace('-', '_') + "_"
                    addStatement("%S -> %T(%N, %N, %N)", languageTag.tag, LocalizedDateTimeFormatsLookup::class, baseName + "Date", baseName + "Time", baseName + "DateTime")
                }
                addStatement("else -> %T(%L, %L, %L)", LocalizedDateTimeFormatsLookup::class, "null", "null", "null")
                endControlFlow()
            }.build()

        util.writeClass("AllLocalizedDateTimeFormats", formatsProperties, subPackage = "datetime", companionObjectMethods = listOf(getFormatsForLocaleMethod))
    }

    private fun generateProperty(locale: LanguageTag, formats: DateOrTimeFormats?, name: String): PropertySpec {
        val property = PropertySpec.builder(locale.tag.replace('-', '_') + "_" + name, String::class.asTypeName().copy(nullable = formats == null))
            .addModifiers(KModifier.PRIVATE)

        return if (formats == null) {
            property.initializer("%L", "null")
        } else {
            val csv = StringBuilder()
            csvWriter.writer(csv).use { csvWriter ->
                csvWriter.writeRow(formats.full, formats.long, formats.medium, formats.short)
            }
            property.addModifiers(KModifier.CONST).initializer("%S", csv.toString())
        }.build()
    }

    private fun removeRedundantValuesFromSubLocales(formatsByLocale: Map<LanguageTag, DateAndTimeFormats>): Map<LanguageTag, Triple<DateOrTimeFormats?, DateOrTimeFormats?, DateTimeFormats?>> {

        return formatsByLocale.mapValues { (languageTag, formats) ->
            if (languageTag == LanguageTag.Root) {
                Triple(formats.dateFormats, formats.timeFormats, formats.dateTimeFormats)
            } else {
                val parent = languageTag.parent ?: LanguageTag.Root // date times have to be resolved up to root
                filterRedundantValues(formatsByLocale, parent, formats)
            }
        }
    }

    private fun filterRedundantValues(
        formatsByLocale: Map<LanguageTag, DateAndTimeFormats>,
        parentLanguageTag: LanguageTag,
        formats: DateAndTimeFormats
    ): Triple<DateOrTimeFormats?, DateOrTimeFormats?, DateTimeFormats?> {
        val parentFormats = formatsByLocale[parentLanguageTag] ?: formatsByLocale[parentLanguageTag.parent] // e.g. "ca-ES" has no explicit mapping -> go directly to "ca", ...
        if (parentFormats == null) {
            return Triple(formats.dateFormats, formats.timeFormats, formats.dateTimeFormats)
        }

        val dateFormats = if (formats.dateFormats.full == parentFormats.dateFormats.full && formats.dateFormats.long == parentFormats.dateFormats.long &&
            formats.dateFormats.medium == parentFormats.dateFormats.medium && formats.dateFormats.short == parentFormats.dateFormats.short) {
            null
        } else {
            formats.dateFormats
        }

        val timeFormats = if (formats.timeFormats.full == parentFormats.timeFormats.full && formats.timeFormats.long == parentFormats.timeFormats.long &&
            formats.timeFormats.medium == parentFormats.timeFormats.medium && formats.timeFormats.short == parentFormats.timeFormats.short) {
            null
        } else {
            formats.timeFormats
        }

        val dateTimeFormats = if (formats.dateTimeFormats.full == parentFormats.dateTimeFormats.full && formats.dateTimeFormats.long == parentFormats.dateTimeFormats.long &&
            formats.dateTimeFormats.medium == parentFormats.dateTimeFormats.medium && formats.dateTimeFormats.short == parentFormats.dateTimeFormats.short) {
            null
        } else {
            formats.dateTimeFormats
        }

        return Triple(dateFormats, timeFormats, dateTimeFormats)
    }

}