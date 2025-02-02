package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty

class UnitsFile(
    val supplemental: UnitsFileSupplemental
)

data class UnitsFileSupplemental(
    val unitPrefixes: Map<String, UnitPrefixSerialModel>,
    val unitConstants: Map<String, UnitConstantSerialModel>,
    val unitQuantities: Map<String, UnitQuantitySerialModel>,
    val convertUnits: Map<String, ConvertUnitSerialModel>
)

data class UnitPrefixSerialModel(
    @JsonProperty("_symbol")
    val symbol: String,
    @JsonProperty("_power10")
    val power10: Int,
    @JsonProperty("_power2")
    val power2: Int? = null
)

data class UnitConstantSerialModel(
    @JsonProperty("_value")
    val value: String,
    @JsonProperty("_description")
    val description: String? = null,
    @JsonProperty("_status")
    val status: String? = null
)

data class UnitQuantitySerialModel(
    @JsonProperty("_quantity")
    val quantity: String,
    @JsonProperty("_status")
    val status: String? = null
)

data class ConvertUnitSerialModel(
    @JsonProperty("_baseUnit")
    val baseUnit: String,
    @JsonProperty("_factor")
    val factor: String? = null,
    @JsonProperty("_systems")
    val systems: List<String>,
    @JsonProperty("_description")
    val description: String? = null,
    @JsonProperty("_offset")
    val offset: String? = null,
    @JsonProperty("_special")
    val special: String? = null,

    @JsonAnySetter
    val otherProperties: Map<String, Any>
)