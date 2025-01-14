package net.codinux.i18n.model

data class TerritoryDisplayNames(
    /**
     * Territory two-letter ISO code or three-digit UN M.49 code
     */
    val territoryCode: String,
    val displayName: String,
    val shortDisplayName: String? = null,
    val variantDisplayName: String? = null
) {
    override fun toString() = "$territoryCode $displayName"
}