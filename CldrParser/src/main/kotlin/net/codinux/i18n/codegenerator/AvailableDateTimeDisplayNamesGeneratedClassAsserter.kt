package net.codinux.i18n.codegenerator

import net.codinux.i18n.LanguageTag
import net.codinux.i18n.datetime.DateTimeDisplayNames
import net.codinux.i18n.datetime.DateTimeDisplayNamesResolver
import net.codinux.i18n.datetime.DisplayNameSet
import net.codinux.i18n.model.*
import net.codinux.i18n.parser.CldrJsonParser

fun main() {
    AvailableDateTimeDisplayNamesGeneratedClassAsserter().assert()
}

/**
 * It cannot be run directory after [AvailableDateTimeDisplayNamesClassGenerator.generate] as
 * [net.codinux.i18n.datetime.AvailableDateTimeDisplayNames] has to be compiled first. So i extracted this class, which
 * has to be run manually after [AvailableDateTimeDisplayNamesClassGenerator.generate].
 */
class AvailableDateTimeDisplayNamesGeneratedClassAsserter(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser()
) {

    fun assert() {
        val locales = cldrJsonParser.getLocalesWithLocalizedDateTimeFormats().map { LanguageTag.ofAvailable(it) }

        val formatsByLocale = locales.associateWith { cldrJsonParser.parseDateTimeFormatsForLocale(it) }

        assertDisplayNamesHaveBeenWrittenCorrectly(formatsByLocale)

        println("Great work, all date time display names have been resolved correctly!")
    }

    private fun assertDisplayNamesHaveBeenWrittenCorrectly(formatsByLocale: Map<LanguageTag, DateAndTimeFormats>) {
        val resolver = DateTimeDisplayNamesResolver()

        formatsByLocale.forEach { (locale, formats) ->
            val resolvedFormatDisplayNames = resolver.getLocalizedFormatDisplayNames(locale)
            val resolvedStandaloneDisplayNames = resolver.getLocalizedStandaloneDisplayNames(locale)

            assertDisplayNamesEqual(locale, formats, resolvedFormatDisplayNames, resolvedStandaloneDisplayNames)
        }
    }

    private fun assertDisplayNamesEqual(
        locale: LanguageTag,
        formats: DateAndTimeFormats,
        resolvedFormatDisplayNames: DateTimeDisplayNames?,
        resolvedStandaloneDisplayNames: DateTimeDisplayNames?
    ) {
        requireNotNull(resolvedFormatDisplayNames) {
            "Could not resolve DateTime Format DisplayNames for locale $locale"
        }
        requireNotNull(resolvedStandaloneDisplayNames) {
            "Could not resolve DateTime Standalone DisplayNames for locale $locale"
        }

        assertMonthsEqual(locale, formats.months.format, resolvedFormatDisplayNames.months, false)
        assertDaysEqual(locale, formats.days.format, resolvedFormatDisplayNames.days, false)
        assertQuartersEqual(locale, formats.quarters.format, resolvedFormatDisplayNames.quarters, false)
        assertDayPeriodsEqual(locale, formats.dayPeriods.format, resolvedFormatDisplayNames.dayPeriods, false)

        assertMonthsEqual(locale, formats.months.standAlone, resolvedStandaloneDisplayNames.months, true)
        assertDaysEqual(locale, formats.days.standAlone, resolvedStandaloneDisplayNames.days, true)
        assertQuartersEqual(locale, formats.quarters.standAlone, resolvedStandaloneDisplayNames.quarters, true)
        assertDayPeriodsEqual(locale, formats.dayPeriods.standAlone, resolvedStandaloneDisplayNames.dayPeriods, true)
    }

    private fun assertMonthsEqual(locale: LanguageTag, expectedNames: DisplayNameSet<MonthDisplayNames>, resolvedNames: DisplayNameSet<net.codinux.i18n.datetime.MonthDisplayNames>, standalone: Boolean) {
        assertMonthsEqual(locale, expectedNames.wide, resolvedNames.wide, standalone, "wide")

        assertMonthsEqual(locale, expectedNames.abbreviated, resolvedNames.abbreviated, standalone, "abbreviated")

        assertMonthsEqual(locale, expectedNames.narrow, resolvedNames.narrow, standalone, "narrow")
    }

    private fun assertMonthsEqual(locale: LanguageTag, expectedNames: MonthDisplayNames, resolvedNames: net.codinux.i18n.datetime.MonthDisplayNames, standalone: Boolean, type: String) {
        require(expectedNames.january == resolvedNames.january) {
            "January of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.january}', resolved: '${resolvedNames.january}'"
        }

        require(expectedNames.february == resolvedNames.february) {
            "February of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.february}', resolved: '${resolvedNames.february}'"
        }

        require(expectedNames.march == resolvedNames.march) {
            "March of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.march}', resolved: '${resolvedNames.march}'"
        }

        require(expectedNames.april == resolvedNames.april) {
            "April of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.april}', resolved: '${resolvedNames.april}'"
        }

        require(expectedNames.may == resolvedNames.may) {
            "May of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.may}', resolved: '${resolvedNames.may}'"
        }

        require(expectedNames.june == resolvedNames.june) {
            "June of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.june}', resolved: '${resolvedNames.june}'"
        }

        require(expectedNames.june == resolvedNames.june) {
            "July of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.june}', resolved: '${resolvedNames.june}'"
        }

        require(expectedNames.august == resolvedNames.august) {
            "August of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.august}', resolved: '${resolvedNames.august}'"
        }

        require(expectedNames.september == resolvedNames.september) {
            "September of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.september}', resolved: '${resolvedNames.september}'"
        }

        require(expectedNames.october == resolvedNames.october) {
            "October of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.october}', resolved: '${resolvedNames.october}'"
        }

        require(expectedNames.november == resolvedNames.november) {
            "November of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.november}', resolved: '${resolvedNames.november}'"
        }

        require(expectedNames.december == resolvedNames.december) {
            "December of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.december}', resolved: '${resolvedNames.december}'"
        }
    }

    private fun assertDaysEqual(locale: LanguageTag, expectedNames: DisplayNameSet<DayDisplayNames>, resolvedNames: DisplayNameSet<net.codinux.i18n.datetime.DayDisplayNames>, standalone: Boolean) {
        assertDaysEqual(locale, expectedNames.wide, resolvedNames.wide, standalone, "wide")

        assertDaysEqual(locale, expectedNames.abbreviated, resolvedNames.abbreviated, standalone, "abbreviated")

        assertDaysEqual(locale, expectedNames.narrow, resolvedNames.narrow, standalone, "narrow")

        if (expectedNames.short != null && resolvedNames.short != null) {
            assertDaysEqual(locale, expectedNames.short!!, resolvedNames.short!!, standalone, "short")
        } else {
            require(expectedNames.short == null && resolvedNames.short == null) {
                "expectedNames.short is not null, but resolvedNames.short is"
            }
        }
    }

    private fun assertDaysEqual(locale: LanguageTag, expectedNames: DayDisplayNames, resolvedNames: net.codinux.i18n.datetime.DayDisplayNames, standalone: Boolean, type: String) {
        require(expectedNames.monday == resolvedNames.monday) {
            "Monday of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.monday}', resolved: '${resolvedNames.monday}'"
        }

        require(expectedNames.tuesday == resolvedNames.tuesday) {
            "Tuesday of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.tuesday}', resolved: '${resolvedNames.tuesday}'"
        }

        require(expectedNames.wednesday == resolvedNames.wednesday) {
            "Wednesday of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.wednesday}', resolved: '${resolvedNames.wednesday}'"
        }

        require(expectedNames.thursday == resolvedNames.thursday) {
            "Thursday of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.thursday}', resolved: '${resolvedNames.thursday}'"
        }

        require(expectedNames.friday == resolvedNames.friday) {
            "Friday of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.friday}', resolved: '${resolvedNames.friday}'"
        }

        require(expectedNames.saturday == resolvedNames.saturday) {
            "Saturday of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.saturday}', resolved: '${resolvedNames.saturday}'"
        }

        require(expectedNames.sunday == resolvedNames.sunday) {
            "Sunday of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.sunday}', resolved: '${resolvedNames.sunday}'"
        }
    }

    private fun assertQuartersEqual(locale: LanguageTag, expectedNames: DisplayNameSet<QuarterDisplayNames>, resolvedNames: DisplayNameSet<net.codinux.i18n.datetime.QuarterDisplayNames>, standalone: Boolean) {
        assertQuartersEqual(locale, expectedNames.wide, resolvedNames.wide, standalone, "wide")

        assertQuartersEqual(locale, expectedNames.abbreviated, resolvedNames.abbreviated, standalone, "abbreviated")

        assertQuartersEqual(locale, expectedNames.narrow, resolvedNames.narrow, standalone, "narrow")
    }

    private fun assertQuartersEqual(locale: LanguageTag, expectedNames: QuarterDisplayNames, resolvedNames: net.codinux.i18n.datetime.QuarterDisplayNames, standalone: Boolean, type: String) {
        require(expectedNames.first == resolvedNames.first) {
            "1st Quarter of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.first}', resolved: '${resolvedNames.first}'"
        }

        require(expectedNames.second == resolvedNames.second) {
            "2nd Quarter of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.second}', resolved: '${resolvedNames.second}'"
        }


        require(expectedNames.third == resolvedNames.third) {
            "3rd Quarter of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.third}', resolved: '${resolvedNames.third}'"
        }


        require(expectedNames.fourth == resolvedNames.fourth) {
            "4th Quarter of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.fourth}', resolved: '${resolvedNames.fourth}'"
        }
    }

    private fun assertDayPeriodsEqual(locale: LanguageTag, expectedNames: DisplayNameSet<DayPeriodDisplayNames>, resolvedNames: DisplayNameSet<net.codinux.i18n.datetime.DayPeriodDisplayNames>, standalone: Boolean) {
        assertDayPeriodsEqual(locale, expectedNames.wide, resolvedNames.wide, standalone, "wide")

        assertDayPeriodsEqual(locale, expectedNames.abbreviated, resolvedNames.abbreviated, standalone, "abbreviated")

        assertDayPeriodsEqual(locale, expectedNames.narrow, resolvedNames.narrow, standalone, "narrow")
    }

    private fun assertDayPeriodsEqual(locale: LanguageTag, expectedNames: DayPeriodDisplayNames, resolvedNames: net.codinux.i18n.datetime.DayPeriodDisplayNames, standalone: Boolean, type: String) {
        require(expectedNames.am == resolvedNames.am) {
            "AM of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.am}', resolved: '${resolvedNames.am}'"
        }

        require(expectedNames.pm == resolvedNames.pm) {
            "PM of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.pm}', resolved: '${resolvedNames.pm}'"
        }

        require(expectedNames.midnight == resolvedNames.midnight) {
            "Midnight of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.midnight}', resolved: '${resolvedNames.midnight}'"
        }

        require(expectedNames.noon == resolvedNames.noon) {
            "Noon of ${getName(standalone)}.$type of locale '$locale' does not match. CLDR: '${expectedNames.noon}', resolved: '${resolvedNames.noon}'"
        }
    }

    private fun getName(standalone: Boolean) =
        if (standalone) "Standalone"
        else "Format"

}