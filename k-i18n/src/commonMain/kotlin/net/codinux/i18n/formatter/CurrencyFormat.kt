package net.codinux.i18n.formatter

data class CurrencyFormat(
    override val standard: String,
    val standardNoCurrency: String? = null,
    val standardAlphaNextToNumber: String? = null,

    val accounting: String? = null,
    val accountingNoCurrency: String? = null,
    val accountingAlphaNextToNumber: String? = null,

    val currencyPatternAppendISO: String? = null,

    val currencySpacing: CurrencySpacing? = null,

    val unitPatternCountZero: String? = null,
    val unitPatternCountOne: String? = null,
    val unitPatternCountTwo: String? = null,
    val unitPatternCountFew: String? = null,
    val unitPatternCountMany: String? = null,
    val unitPatternCountOther: String? = null
) : DecimalFormat(standard)

data class CurrencySpacing(
    val beforeCurrency: CurrencySpacingValues? = null,
    val afterCurrency: CurrencySpacingValues? = null
)

data class CurrencySpacingValues(
    val currencyMatch: String,
    val surroundingMatch: String,
    val insertBetween: String
)