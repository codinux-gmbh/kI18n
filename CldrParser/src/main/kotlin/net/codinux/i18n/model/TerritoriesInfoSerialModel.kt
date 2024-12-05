package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonProperty

data class TerritoriesInfoFile(
    val supplemental: TerritoriesInfoSupplementalSerialModel
)

data class TerritoriesInfoSupplementalSerialModel(
    val territoryInfo: Map<String, TerritoriesInfoSerialModel>
)

class TerritoriesInfoSerialModel(
    @JsonProperty("_gdp")
    val gdp: Long,
    @JsonProperty("_literacyPercent")
    val literacyPercent: Float,
    @JsonProperty("_population")
    val population: Int,
    val languagePopulation: Map<String, LanguagePopulationSerialModel> = emptyMap()
)

data class LanguagePopulationSerialModel(
    @JsonProperty("_populationPercent")
    val populationPercent: Float,
    @JsonProperty("_officialStatus")
    val officialStatus: String? = null,
    @JsonProperty("_writingPercent")
    val writingPercent: Float? = null,
)