package net.codinux.i18n.model

class Currency(
    val isoCode: String,
    val displayName: String? = null,

    val pattern: String? = null,

    val symbol: String? = null,
    val narrowSymbol: String? = null,
    val formalSymbol: String? = null,
    val symbolVariant: String? = null,

    val decimal: String? = null,
    val group: String? = null,

    val displayNameCountZero: String? = null,
    val displayNameCountOne: String? = null,
    val displayNameCountTwo: String? = null,
    val displayNameCountFew: String? = null,
    val displayNameCountMany: String? = null,
    val displayNameCountOther: String? = null

) {
    override fun toString() = "$isoCode $displayName"
}