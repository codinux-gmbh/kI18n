package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonProperty

data class TimeDataFile(
    val supplemental: TimeDataFileSupplemental
)

data class TimeDataFileSupplemental(
    val timeData: Map<String, TimeDataEntry>
)

data class TimeDataEntry(
    @JsonProperty("_preferred")
    val preferred: String,

    @JsonProperty("_allowed")
    val allowed: String
)