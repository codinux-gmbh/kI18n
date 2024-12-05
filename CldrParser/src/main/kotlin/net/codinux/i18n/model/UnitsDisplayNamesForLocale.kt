package net.codinux.i18n.model

class UnitsDisplayNamesForLocale(
    val long: UnitsLocaleDisplayNames,
    val short: UnitsLocaleDisplayNames,
    val narrow: UnitsLocaleDisplayNames,

    val durationUnitTypeHm: DurationUnitPattern,
    val durationUnitTypeHms: DurationUnitPattern,
    val durationUnitTypeMs: DurationUnitPattern
)

class UnitsLocaleDisplayNames(
    val units: List<UnitDisplayNames>,

    val prefixPatterns: List<UnitPattern>,
    val powerPatterns: List<UnitPattern>,
    val compoundPatterns: List<UnitPattern>,

    val coordinates: CoordinatesDisplayNames? = null
)

data class UnitDisplayNames(
    val unit: String,
    val displayName: String,
    val unitPatternCountOne: String? = null,
    val unitPatternCountOther: String? = null,
    val perUnitPattern: String? = null,
)

data class UnitPattern(
    val unit: String,
    val unitPattern: String,
    val unitPatternCountOne: String? = null,
    val unitPatternCountOther: String? = null
)

data class CoordinatesDisplayNames(
    val west: String,
    val north: String,
    val east: String,
    val south: String
)