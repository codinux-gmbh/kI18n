package net.codinux.i18n.datetime

data class DateTimeDisplayNames(
    val months: DisplayNameSet<MonthDisplayNames>,
    val days: DisplayNameSet<DayDisplayNames>,
    val quarters: DisplayNameSet<QuarterDisplayNames>,
    val dayPeriods: DisplayNameSet<DayPeriodDisplayNames>,
)

data class MonthDisplayNames(
    // this name mappings are only valid for gregorian calendar. Other calendars also may have more months
    val january: String,
    val february: String,
    val march: String,
    val april: String,
    val may: String,
    val june: String,
    val july: String,
    val august: String,
    val september: String,
    val october: String,
    val november: String,
    val december: String
) {
    fun getMonth(date: LocalDate): String = getMonth(date.month)

    fun getMonth(month: Month): String = getMonth(month.monthNumber)

    fun getMonth(monthInt: Int): String = when (monthInt) {
        1 -> january
        2 -> february
        3 -> march
        4 -> april
        5 -> may
        6 -> june
        7 -> july
        8 -> august
        9 -> september
        10 -> october
        11 -> november
        12 -> december
        else -> throw IllegalArgumentException("Month is not within its valid bounds 1-12: $monthInt")
    }
}

data class DayDisplayNames(
    // this name mappings are only valid for gregorian calendar. Other calendars may also have more or less days
    val monday: String,
    val tuesday: String,
    val wednesday: String,
    val thursday: String,
    val friday: String,
    val saturday: String,
    val sunday: String,
) {
    fun getDay(day: DayOfWeek): String = when (day) {
        DayOfWeek.Monday -> monday
        DayOfWeek.Tuesday -> tuesday
        DayOfWeek.Wednesday -> wednesday
        DayOfWeek.Thursday -> thursday
        DayOfWeek.Friday -> friday
        DayOfWeek.Saturday -> saturday
        DayOfWeek.Sunday -> sunday
    }
}

data class QuarterDisplayNames(
    val first: String,
    val second: String,
    val third: String,
    val fourth: String
)

data class DayPeriodDisplayNames(
    val am: String,
    val pm: String,
    val midnight: String? = null,
    val noon: String? = null,
) {
    fun getDayPeriod(time: LocalTime, alsoFormatNoonAndMidnight: Boolean): String {
        if (alsoFormatNoonAndMidnight) {
            if (time.hour == 0 && midnight != null) {
                return midnight
            }
            if (time.hour == 12 && noon != null) {
                return noon
            }
        }

        return if (time.hour < 12) {
            am
        } else {
            pm
        }
    }
}

data class DisplayNameSet<T>(
    val wide: T,
    val abbreviated: T,
    val narrow: T,

    /**
     * Only set for days.
     */
    val short: T? = null
)