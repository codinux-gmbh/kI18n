package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode

data class NumberFormatsFile(
    val main: Map<String, NumberFormatsFileMain>
)

data class NumberFormatsFileMain(
    val numbers: NumberFormatsFileNumbers
)

data class NumberFormatsFileNumbers(
    val defaultNumberingSystem: String,
    @JsonProperty("defaultNumberingSystem-alt-latn")
    val defaultNumberingSystemAltLatn: String? = null,
    val otherNumberingSystems: Map<String, String> = emptyMap(),
    val minimumGroupingDigits: Int,
    val minimalPairs: MinimalPairs,

    // contains: symbols, decimalFormats, scientificFormats, percentFormats, currencyFormats and miscPatterns
    // it's impossible to map all these Maps with different value objects directly, so we have to first catch
    // them all and then map them to their specific value object
    @JsonAnySetter
    var otherProperties: Map<String, JsonNode> = emptyMap()
)