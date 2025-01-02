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
    val powerPatterns: List<CompoundUnitPattern>,
    val compoundPatterns: List<UnitPattern>,

    val coordinates: CoordinatesDisplayNames? = null
)

data class UnitDisplayNames(
    val unit: String,
    val displayName: String,
    val perUnitPattern: String? = null,
    // TODO: there are 59 other patterns like unitPattern-count-few, accusative-count-one, instrumental-count-many, illative-count-one, oblique-count-one, ...
    val unitPatternCountOne: String? = null,
    val unitPatternCountOther: String? = null,
)

data class UnitPattern(
    val unit: String,
    val unitPattern: String
)

data class CompoundUnitPattern(
    val unit: String,
    val unitPattern: String,
    // TODO: there are 160 more compoundUnitPattern1-count-xyz and compoundUnitPattern1-gender-xyz properties
    // only for ff- locales compoundUnitPattern1CountOther differs from compoundUnitPattern1. compoundUnitPattern1CountOne is always null
//    val unitPatternCountOne: String? = null,
//    val unitPatternCountOther: String? = null
)

data class CoordinatesDisplayNames(
    val west: String,
    val north: String,
    val east: String,
    val south: String
)