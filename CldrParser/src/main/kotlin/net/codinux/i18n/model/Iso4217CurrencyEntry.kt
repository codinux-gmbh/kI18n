package net.codinux.i18n.model

class Iso4217CurrencyEntry(
    val country: String,
    val currencyName: String,
    val currencyAlpha3Code: String,
    val currencyNumericCode: Int? = null,
    val isCurrentCurrency: Boolean,
    val minorUnit: Int? = null,
    val withdrawalDate: String? = null
) {
    override fun toString() = "$currencyAlpha3Code $currencyName ($country)"
}