package net.codinux.i18n.unit

import net.codinux.i18n.units.UnitDisplayNameKey
import net.codinux.i18n.units.UnitPrefix

data class UnitDisplayNames(
    val long: UnitDisplayFormatNames,
    val short: UnitDisplayFormatNames,
    val narrow: UnitDisplayFormatNames
) {
    override fun toString(): String = long.toString()
}

data class UnitDisplayFormatNames(
    val units: Map<UnitDisplayNameKey, Any>,
    val prefixPatterns: Map<UnitPrefix, Any>,
    val powerPatterns: Any,
    val compoundPatterns: Any
)