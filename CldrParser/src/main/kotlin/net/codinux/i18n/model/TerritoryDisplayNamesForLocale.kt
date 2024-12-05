package net.codinux.i18n.model

data class TerritoryDisplayNamesForLocale(
    val territories: Map<String, TerritoryDisplayNames>
)

data class TerritoryDisplayNames(
    val territoryIsoCode: String,
    val displayName: String
)