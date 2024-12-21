package net.codinux.i18n.datetime

import net.codinux.csv.reader.CsvReader
import net.codinux.csv.reader.CsvRow
import net.codinux.i18n.LanguageTag

class DateTimeDisplayNamesResolver {

    companion object {
        const val CsvFormatsSeparator = '|'
    }

    private val csvReader = CsvReader(CsvFormatsSeparator, reuseRowInstance = true)


    fun getLocalizedFormatDisplayNames(locale: LanguageTag): DateTimeDisplayNames? =
        resolve(locale) {
            AvailableDateTimeDisplayNames.getLocalizedFormatDisplayNames(it.tag)
        }

    fun getLocalizedStandaloneDisplayNames(locale: LanguageTag): DateTimeDisplayNames? =
        resolve(locale) {
            AvailableDateTimeDisplayNames.getLocalizedFormatDisplayNames(it.tag)
        }

    private fun resolve(locale: LanguageTag, getDisplayNames: (LanguageTag) -> DateTimeDisplayNamesLookup): DateTimeDisplayNames? {
        val lookup = getDisplayNames(locale)
        var parent: LanguageTag? = locale.parent ?: LanguageTag.Root

        while ((lookup.months == null || lookup.days == null || lookup.quarters == null || lookup.dayPeriods == null)
            && parent != null) {
            val parentLookup = getDisplayNames(parent)

            if (lookup.months == null) {
                lookup.months = parentLookup.months
            }
            if (lookup.days == null) {
                lookup.days = parentLookup.days
            }
            if (lookup.quarters == null) {
                lookup.quarters = parentLookup.quarters
            }
            if (lookup.dayPeriods == null) {
                lookup.dayPeriods = parentLookup.dayPeriods
            }

            parent = if (parent == LanguageTag.Root) null else parent.parent ?: LanguageTag.Root
        }

        return mapDisplayNames(lookup)
    }

    private fun mapDisplayNames(lookup: DateTimeDisplayNamesLookup): DateTimeDisplayNames? {
        if (lookup.months == null || lookup.days == null || lookup.quarters == null || lookup.dayPeriods == null) {
            return null // should only happen for custom language tags, not for language tags defined in CLDR
        }

        return DateTimeDisplayNames(mapMonths(lookup.months!!), mapDays(lookup.days!!), mapQuarters(lookup.quarters!!), mapDayPeriods(lookup.dayPeriods!!))
    }

    private fun mapMonths(csv: String): DisplayNameSet<MonthDisplayNames> {
        val rows = csvReader.read(csv).toList()

        return DisplayNameSet(mapMonthDisplayNames(rows[0]), mapMonthDisplayNames(rows[1]), mapMonthDisplayNames(rows[2]))
    }

    private fun mapMonthDisplayNames(row: CsvRow) = MonthDisplayNames(
        row.getString(0), row.getString(1), row.getString(2), row.getString(3), row.getString(4), row.getString(5),
        row.getString(6), row.getString(7), row.getString(8), row.getString(9), row.getString(10), row.getString(11)
    )

    private fun mapDays(csv: String): DisplayNameSet<DayDisplayNames> {
        val rows = csvReader.read(csv).toList()

        return DisplayNameSet(mapDayDisplayNames(rows[0]), mapDayDisplayNames(rows[1]), mapDayDisplayNames(rows[2]), if (rows.size > 3) mapDayDisplayNames(rows[3]) else null)
    }

    private fun mapDayDisplayNames(row: CsvRow) = DayDisplayNames(
        row.getString(0), row.getString(1), row.getString(2), row.getString(3),
        row.getString(4), row.getString(5), row.getString(6)
    )

    private fun mapQuarters(csv: String): DisplayNameSet<QuarterDisplayNames> {
        val rows = csvReader.read(csv).toList()

        return DisplayNameSet(mapQuarterDisplayNames(rows[0]), mapQuarterDisplayNames(rows[1]), mapQuarterDisplayNames(rows[2]))
    }

    private fun mapQuarterDisplayNames(row: CsvRow) = QuarterDisplayNames(
        row.getString(0), row.getString(1), row.getString(2), row.getString(3)
    )

    private fun mapDayPeriods(csv: String): DisplayNameSet<DayPeriodDisplayNames> {
        val rows = csvReader.read(csv).toList()

        return DisplayNameSet(mapDayPeriodDisplayNames(rows[0]), mapDayPeriodDisplayNames(rows[1]), mapDayPeriodDisplayNames(rows[2]))
    }

    private fun mapDayPeriodDisplayNames(row: CsvRow) = DayPeriodDisplayNames(
        row.getString(0), row.getString(1), row.getStringOrNull(2), row.getStringOrNull(3)
    )

}