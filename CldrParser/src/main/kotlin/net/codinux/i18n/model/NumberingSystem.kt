package net.codinux.i18n.model

import net.codinux.i18n.NumberingSystemType

data class NumberingSystem(
    val code: String,

    val type: NumberingSystemType,
    val digits: String? = null,
    val rules: String? = null,
)