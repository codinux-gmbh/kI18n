package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty

class UnitsLocaleNamesFile : LocalSpecificFileHeader<UnitsLocaleNamesFileContent>()

data class UnitsLocaleNamesFileContent(
    val units: UnitsLocaleNamesCategoriesSerialModel
)

data class UnitsLocaleNamesCategoriesSerialModel(
    val long: UnitsLocaleDisplayNamesSerialModel,
    val short: UnitsLocaleDisplayNamesSerialModel,
    val narrow: UnitsLocaleDisplayNamesSerialModel,

    @JsonProperty("durationUnit-type-hm")
    val durationUnitTypeHm: DurationUnitPattern,
    @JsonProperty("durationUnit-type-hms")
    val durationUnitTypeHms: DurationUnitPattern,
    @JsonProperty("durationUnit-type-ms")
    val durationUnitTypeMs: DurationUnitPattern
)

class UnitsLocaleDisplayNamesSerialModel(
    @JsonAnySetter
    val unitPattern: Map<String, UnitPatternsSerialModel>,
)

class UnitPatternsSerialModel(
    // don't know why but Jackson doesn't parse properties like "gender", "accusative-count-one" and "compoundUnitPattern1-count-one-case-accusative"

    val unitPrefixPattern: String? = null,

    val compoundUnitPattern: String? = null,

    val displayName: String? = null,
    val gender: String? = null,

    @JsonProperty("unitPattern-count-one")
    val unitPatternCountOne: String? = null,
    @JsonProperty("unitPattern-count-other")
    val unitPatternCountOther: String? = null,
    val perUnitPattern: String? = null,

    val compoundUnitPattern1: String? = null,
    @JsonProperty("compoundUnitPattern1-count-one")
    val compoundUnitPattern1CountOne: String? = null,
    @JsonProperty("compoundUnitPattern1-count-other")
    val compoundUnitPattern1CountOther: String? = null,

    val east: String? = null,
    val north: String? = null,
    val south: String? = null,
    val west: String? = null,

    @JsonAnySetter
    val otherProperties: Map<String, String>
)

data class DurationUnitPattern(
    val durationUnitPattern: String
)