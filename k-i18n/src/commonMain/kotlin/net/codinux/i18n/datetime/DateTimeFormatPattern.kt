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

enum class HourStyle {
    /**
     * h: 1, 12
     * hh: 01, 12
     */
   TwelveHoursOneBased,

    /**
     * H: 0, 23
     * HH: 00, 23
     */
    TwentyFourHoursZeroBased,

    /**
     * K: 0, 11
     * KK: 00, 11
     */
    TwelveHoursZeroBased,

    /**
     * k: 1, 24
     * kk: 01, 24
     */
    TwentyFourHoursOneBased,
}