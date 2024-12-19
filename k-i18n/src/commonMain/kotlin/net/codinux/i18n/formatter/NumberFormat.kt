package net.codinux.i18n.formatter

import net.codinux.i18n.NumberingSystem

data class NumberFormat(
    val defaultNumberingSystem: NumberingSystem,

    val minimumGroupingDigits: Int,

    val symbols: Map<NumberingSystem, Symbols>,

    val decimalFormats: Map<NumberingSystem, DecimalFormat>,
    val percentFormats: Map<NumberingSystem, DecimalFormat>,
    val scientificFormats: Map<NumberingSystem, DecimalFormat>,
    val currencyFormats: Map<NumberingSystem, CurrencyFormat>,
)