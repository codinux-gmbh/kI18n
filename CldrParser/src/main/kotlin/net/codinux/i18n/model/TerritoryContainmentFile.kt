package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty

data class TerritoryContainmentFile(
    val supplemental: TerritoryContainmentSupplemental
) {
    override fun toString() = supplemental.toString()
}

data class TerritoryContainmentSupplemental(
    val territoryContainment: Map<String, TerritoryContainment>
) {
    override fun toString() = territoryContainment.toString()
}

data class TerritoryContainment(
    @JsonProperty("_contains")
    val contains: List<String>,

    @JsonProperty("_grouping")
    val grouping: Boolean = false,

    @JsonAnySetter
    val otherPropoerties: Map<String, Any?>
) {
    override fun toString() = contains.toString()
}