package net.codinux.i18n

class LanguageTag(
    val tag: String,

    val language: String,
    val region: String? = null,
    val script: String? = null,
    val variant: String? = null
) {
    override fun toString() = tag
}