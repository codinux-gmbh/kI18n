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
)

data class DayDisplayNames(
    // this name mappings are only valid for gregorian calendar. Other calendars may also have more or less days
    val monday: String,
    val tuesday: String,
    val wednesday: String,
    val thursday: String,
    val friday: String,
    val saturday: String,
    val sunday: String,
)

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
)

data class DisplayNameSet<T>(
    val wide: T,
    val abbreviated: T,
    val narrow: T,

    /**
     * Only set for days.
     */
    val short: T? = null
)