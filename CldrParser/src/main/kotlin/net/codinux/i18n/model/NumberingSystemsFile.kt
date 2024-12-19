package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonProperty

data class NumberingSystemsFile(
    val supplemental: NumberingSystemsFileSupplemental
)

data class NumberingSystemsFileSupplemental(
    val numberingSystems: Map<String, NumberingSystemEntry>
)


data class NumberingSystemEntry(
    @JsonProperty("_type")
    val type: String,
    @JsonProperty("_digits")
    val digits: String? = null,
    @JsonProperty("_rules")
    val rules: String? = null
)