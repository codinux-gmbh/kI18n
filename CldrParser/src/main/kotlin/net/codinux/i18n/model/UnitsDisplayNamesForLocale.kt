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
    val units: List<UnitDisplayName>,

    val prefixPatterns: List<UnitPattern>,
    val powerPatterns: List<UnitPattern>,
    val compoundPatterns: List<CompoundUnitPattern>,

    val coordinates: CoordinatesDisplayNames? = null
)

data class UnitDisplayName(
    val unit: String,
    val displayName: String,
    val perUnitPattern: String? = null,
    // TODO: there are 59 other patterns like unitPattern-count-few, accusative-count-one, instrumental-count-many, illative-count-one, oblique-count-one, ...
    val unitPatternCountOne: String? = null,
    val unitPatternCountOther: String? = null,
)

open class UnitPattern(
    val unit: String,
    val unitPattern: String
) {
    override fun toString() = "$unit = $unitPattern"
}

class CompoundUnitPattern(
    unit: String,
    unitPattern: String,
    // TODO: there are 160 more compoundUnitPattern1-count-xyz and compoundUnitPattern1-gender-xyz properties
//    val unitPatternCountOne: String? = null,
//    val unitPatternCountOther: String? = null
) : UnitPattern(unit, unitPattern)

data class CoordinatesDisplayNames(
    val west: String,
    val north: String,
    val east: String,
    val south: String
)