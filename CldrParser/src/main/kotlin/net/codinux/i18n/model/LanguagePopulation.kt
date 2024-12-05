package net.codinux.i18n.model

data class LanguagePopulation(
    val languageIsoCode: String,
    val populationPercent: Float,
    val officialStatus: String? = null,
    val writingPercent: Float? = null,
)