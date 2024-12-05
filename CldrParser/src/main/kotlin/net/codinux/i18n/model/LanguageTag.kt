package net.codinux.i18n.model

/**
 * A BCP 47 language tag, for example en, en-US or zh-Hans-HK.
 * References:
 * https://tools.ietf.org/html/bcp47
 */
data class LanguageTag(
    val tag: String
) {
    override fun toString() = tag
}