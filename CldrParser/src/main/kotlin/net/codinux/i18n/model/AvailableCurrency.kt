package net.codinux.i18n.model

data class AvailableCurrency(
    val isoCode: String,
    val englishName: String
) {
    override fun toString() = "$isoCode $englishName"
}
