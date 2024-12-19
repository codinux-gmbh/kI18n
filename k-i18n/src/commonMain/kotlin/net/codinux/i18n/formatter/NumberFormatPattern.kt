package net.codinux.i18n.formatter

data class NumberFormatPattern(
    val pattern: String,
    val minimumIntegerDigits: Int = 0,
    val minimumFractionDigits: Int = 0,
    val maximumFractionDigits: Int = Int.MAX_VALUE,
    val groupSize: Int = 0
)