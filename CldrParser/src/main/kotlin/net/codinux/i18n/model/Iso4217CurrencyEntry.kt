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
    /**
     * The name as it gets used for Enum name; for internal use only
     */
    var nameToUseForEnum: String = currencyName

    override fun toString() = "$currencyAlpha3Code $currencyName ($country)"
}