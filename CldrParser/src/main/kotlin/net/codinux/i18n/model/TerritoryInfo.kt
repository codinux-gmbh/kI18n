package net.codinux.i18n.model

data class TerritoryInfo(
    val isoCode: String,
    val gdp: Long,
    val literacyPercent: Float,
    val population: Int,
    val languagePopulation: List<LanguagePopulation> = emptyList()
)