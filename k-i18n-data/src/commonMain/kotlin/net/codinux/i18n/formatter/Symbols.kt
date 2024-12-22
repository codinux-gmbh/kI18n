package net.codinux.i18n.formatter

data class Symbols(
    val decimal: String,
    val group: String,
    val plusSign: String,
    val minusSign: String,
    val infinity: String,
    val nan: String,
    val percentSign: String,
    val perMille: String,
    val approximatelySign: String,
    val exponential: String,
    val superscriptingExponent: String,
    val list: String,

    val timeSeparator: String,
    val timeSeparatorVariant: String? = null,

    val currencyGroup: String? = null,
    val currencyDecimal: String? = null,

    val decimalAltUs: String? = null,
    val groupAltUs: String? = null
)