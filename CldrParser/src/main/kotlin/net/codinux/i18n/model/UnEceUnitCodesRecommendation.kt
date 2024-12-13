package net.codinux.i18n.model

class UnEceUnitCodesRecommendation(
    val code: String,
    val name: String,
    val description: String? = null,
    val status: UnEceUnitCodesRecommendationStatus? = null,
    val levelOrCategory: String? = null,
    val symbol: String? = null,
    val conversionFactor: String? = null,

    // only for Annex I units
    val quantity: String? = null,
    val groupNumber: String? = null,
    val groupId: Int? = null,
    val sector: String? = null,
) {
    override fun toString() = "$code $name $symbol"
}

// see PDF rec20_Rev7e_2010.pdf p. 8
enum class UnEceUnitCodesRecommendationStatus {
    Added,
    ChangedName,
    ChangedCharacteristics,
    Deprecated,
    MarkedAsDeleted,
    Reinstated
}