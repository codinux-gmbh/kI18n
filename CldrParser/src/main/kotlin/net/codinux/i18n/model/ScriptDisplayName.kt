package net.codinux.i18n.model

class ScriptDisplayName(
    val code: String,
    val displayName: String,
    val shortDisplayName: String? = null,
    val variantDisplayName: String? = null,
    val standaloneDisplayName: String? = null
) {
    override fun toString() = "$code: $displayName"
}