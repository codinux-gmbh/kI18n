package net.codinux.i18n.model

class VariantDisplayName(
    val code: String,
    val displayName: String
) {
    override fun toString() = "$code: $displayName"
}