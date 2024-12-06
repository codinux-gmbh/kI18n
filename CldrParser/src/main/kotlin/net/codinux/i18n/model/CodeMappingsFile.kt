package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonProperty

class CodeMappingsFile(
    val supplemental: CodeMappingsFileSupplemental
)

data class CodeMappingsFileSupplemental(
    val codeMappings: Map<String, CodeMappingSerialModel>
)

data class CodeMappingSerialModel(
    @JsonProperty("_numeric")
    val numeric: Int? = null,
    @JsonProperty("_alpha3")
    val alpha3: String? = null,
    @JsonProperty("_fips10")
    val fips10: String? = null
)