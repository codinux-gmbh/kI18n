package net.codinux.i18n.datetime

data class DateTimeFormatPattern(
    val pattern: String,

    val yearMinLength: Int? = null,
    val yearMaxLength: Int? = null,

    val monthStyle: MonthStyle? = null,

    val dayMinLength: Int? = null,

    val hourStyle: HourStyle? = null,
    /**
     * If hour is contained in pattern is determined by [hourStyle].
     */
    val hourMinLength: Int = 0,

    val minuteMinLength: Int? = null,

    val secondMinLength: Int? = null,
    val fractionalSecondLength: Int? = null,
) {
    override fun toString() = pattern
}

enum class MonthStyle {
    /**
     * Example: 9, 12
     */
    NumericMinDigits,

    /**
     * Example: 09, 12
     */
    Numeric2Digits,

    /**
     * Example: Sep
     */
    Abbreviated,

    /**
     * Example: September
     */
    Wide,

    /**
     * Example: S
     */
    Narrow
}

enum class HourStyle(val fieldSymbol: String) {
    /**
     * h: 1, 12
     * hh: 01, 12
     */
   TwelveHourStart1("h"),

    /**
     * H: 0, 23
     * HH: 00, 23
     */
    TwentyFourHourStart0("H"),

    /**
     * K: 0, 11
     * KK: 00, 11
     */
    TwelveHourStart0("K"),

    /**
     * k: 1, 24
     * kk: 01, 24
     *
     * No known Locale with that format, neither preferred nor allowed.
     */
    TwentyFourHourStart1("k"),

    /**
     * Uses additionally to AM and PM also Noon and Midnight like "May 6, noon" or “Nov 12, midnight”.
     *
     * May be upper or lowercase depending on the locale and other options.
     */
    TwelveHourStart1_NoonAndMidght("hb"),

    /**
     * Flexible day periods like “Nov 12, at night”
     *
     * May be upper or lowercase depending on the locale and other options.
     */
    TwelveHourStart1_FlexibleDayPeriods("hB")
}