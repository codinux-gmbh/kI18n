package net.codinux.i18n.datetime

data class DateTimeFormatPattern(
    val pattern: String,

    val yearMinLength: Int? = null,
    val yearMaxLength: Int? = null,

    val monthStyle: MonthStyle? = null,

    val dayMinLength: Int? = null,
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