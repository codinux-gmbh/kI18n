package net.codinux.i18n.unit

data class UnitDisplayNames(
    val long: UnitDisplayFormatNames,
    val short: UnitDisplayFormatNames,
    val narrow: UnitDisplayFormatNames
) {
    override fun toString(): String = long.toString()
}

data class UnitDisplayFormatNames(
    val units: Map<UnitDisplayNameKey, UnitDisplayName>,
    val prefixPatterns: Map<UnitPrefix, String>,
    val squarePattern: String?,
    val cubicPattern: String?,
    val timesPattern: String?,
    val perPattern: String?,
)

data class UnitDisplayName(
    val displayName: String,
    val perUnitPattern: String? = null,
    val unitPatternCountOne: String? = null,
    val unitPatternCountOther: String? = null,
)