package net.codinux.i18n.example

import net.codinux.i18n.*

class Demonstration {

    fun LanguageTagFromConstants() {
        val language = LanguageTag.of(Language.Hindi)

        val languageAndRegion = LanguageTag.of(Language.Arabic, Region.Yemen)

        val languageAndScript = LanguageTag.of(Language.Asu, script = Script.Latin)

        val languageAndVariant = LanguageTag.of(Language.Belarusian, variant = Variant.Tarask)
    }

    fun LanguageTagParse() {
        val language = LanguageTag.parse("es-AR") // throws an exception if language tag is invalid
        val languageOrNull = LanguageTag.parseOrNull("invalid") // returns null if language tag is invalid
    }

    fun LanguageTagAvailableLanguageTags() {
        val availables: List<LanguageTag> = LanguageTag.availableLanguageTags
        val availableTags: List<String> = LanguageTag.availableLanguageTagsAsString
        val availablesByTag: Map<String, LanguageTag> = LanguageTag.availableLanguageTagsByTag

        val fromAvailableTags = LanguageTag.ofAvailable("jp")
        // it's a valid LanguageTag, but there's no instance for it in LanguageTag.availableLanguageTags (as CLDR as no direct data for it)
        val fromAvailableTagsOrNull = LanguageTag.ofAvailableOrNull("en-001")
    }

    fun getCurrentLanguageTag() {
        val current = LanguageTag.current // equal to Java's Locale.getDefault()
    }
}