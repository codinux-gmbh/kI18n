package net.codinux.i18n.datetime

import net.codinux.csv.reader.CsvReader
import net.codinux.i18n.LanguageTag

class LocalizedDateTimeFormatsResolver {

    companion object {
        const val CsvFormatsSeparator = '|'
    }

    private val csvReader = CsvReader(CsvFormatsSeparator)


    fun getDateTimeFormatsForLocale(locale: LanguageTag): LocalizedDateTimeFormats? {
        val lookup = AllLocalizedDateTimeFormats.getDateTimeFormatsForLocale(locale.tag)
        var parent: LanguageTag? = locale.parent ?: LanguageTag.Root

        while ((lookup.date == null || lookup.time == null || lookup.dateTime == null) && parent != null) {
            val parentLookup = AllLocalizedDateTimeFormats.getDateTimeFormatsForLocale(parent.tag)

            if (lookup.date == null) {
                lookup.date = parentLookup.date
            }
            if (lookup.time == null) {
                lookup.time = parentLookup.time
            }
            if (lookup.dateTime == null) {
                lookup.dateTime = parentLookup.dateTime
            }

            parent = if (parent == LanguageTag.Root) null else parent.parent ?: LanguageTag.Root
        }

        return mapFormats(lookup)
    }

    private fun mapFormats(lookup: LocalizedDateTimeFormatsLookup): LocalizedDateTimeFormats? {
        if (lookup.date == null || lookup.time == null || lookup.dateTime == null) {
            return null // should only happen for custom language tags, not for language tags defined in CLDR
        }

        return LocalizedDateTimeFormats(mapFormat(lookup.date!!), mapFormat(lookup.time!!), mapFormat(lookup.dateTime!!))
    }

    private fun mapFormat(formatsCsv: String): DateOrTimeFormats {
        val formatsRow = csvReader.read(formatsCsv).first()

        return DateOrTimeFormats(formatsRow.getString(0), formatsRow.getString(1), formatsRow.getString(2), formatsRow.getString(3))
    }

}