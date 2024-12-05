package net.codinux.i18n.model

class Currency(
    val isoCode: String,
    val displayName: String? = null,

    val displayNameCountOne: String? = null,
    val displayNameCountOther: String? = null,

    val symbol: String? = null,
    val symbolAltNarrow: String? = null

) {
    override fun toString() = "$isoCode $displayName"
}