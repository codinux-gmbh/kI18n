package net.codinux.i18n.formatter

open class DecimalFormat(
    open val standard: String

    // for decimalFormat there are also long and short formats, for currencyFormat short formats
) {
    override fun toString() = standard
}