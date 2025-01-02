package net.codinux.i18n.model

data class UnitsMetadata(
    val unitPrefixes: List<UnitPrefix>,
    val unitConstants: List<UnitConstant>,
    val unitQuantities: List<UnitQuantity>,
    val convertUnits: List<ConvertUnit>
)

data class UnitPrefix(
    val name: String,
    val symbol: String,
    val power10: Int,
    val power2: Int? = null
)

data class UnitConstant(
    val name: String,
    val value: String,
    val description: String? = null,
    val isApproximate: Boolean = false
)

data class UnitQuantity(
    val name: String,
    val unitType: String,
    val isSimple: Boolean
)

data class ConvertUnit(
    val name: String,
    val baseUnit: String,
    val factor: String? = null,
    val systems: List<String>,
    val description: String? = null,
    val offset: String? = null,
    val special: String? = null
)