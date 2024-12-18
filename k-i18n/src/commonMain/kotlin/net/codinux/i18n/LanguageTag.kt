package net.codinux.i18n

import net.codinux.collections.toImmutableList
import net.codinux.i18n.platform.Platform

/**
 * A BCP 47 language tag, for example en, en-US or zh-Hans-HK.
 * References:
 * [https://tools.ietf.org/html/bcp47](https://tools.ietf.org/html/bcp47)
 *
 * It does however not implement the full language tag specification. The full specification is:
 *
 * To distinguish language variants for countries, regions, or writing systems (scripts), IETF language
 * tags combine subtags from other standards such as ISO 639, ISO 15924, ISO 3166-1 and UN M.49.
 *
 * For example, the tag en stands for English; es-419 for Latin American Spanish; rm-sursilv for Romansh
 * Sursilvan; sr-Cyrl for Serbian written in Cyrillic script; nan-Hant-TW for Min Nan Chinese using
 * traditional Han characters, as spoken in Taiwan; yue-Hant-HK for Cantonese using traditional Han
 * characters, as spoken in Hong Kong; and gsw-u-sd-chzh for Zürich German.
 *
 * Each language tag is composed of one or more "subtags" separated by hyphens (-). Each subtag is composed
 * of basic Latin letters or digits only.
 *
 * With the exceptions of private-use language tags beginning with an x- prefix and grandfathered language
 * tags (including those starting with an i- prefix and those previously registered in the old Language Tag
 * Registry), subtags occur in the following order:
 *
 * - A single primary language subtag based on a two-letter language code from ISO 639-1 (2002) or a
 * three-letter code from ISO 639-2 (1998), ISO 639-3 (2007) or ISO 639-5 (2008), or registered through
 * the BCP 47 process and composed of five to eight letters;

 * - (Not implemented) Up to three optional extended language subtags composed of three letters each,
 * separated by hyphens; (There is currently no extended language subtag registered in the Language
 * Subtag Registry without an equivalent and preferred primary language subtag. This component of
 * language tags is preserved for backwards compatibility and to allow for future parts of ISO 639.)
 *
 * - An optional script subtag, based on a four-letter script code from ISO 15924 (usually written in Title Case);
 *
 * - An optional region subtag based on a two-letter country code from ISO 3166-1 alpha-2 (usually
 * written in upper case), or a three-digit code from UN M.49 for geographical regions;
 *
 * - Optional variant subtags, separated by hyphens, each composed of five to eight letters, or of
 * four characters starting with a digit; (Variant subtags are registered with IANA and not
 * associated with any external standard.)
 *
 * - (Not implemented) Optional extension subtags, separated by hyphens, each composed of a single
 * character, with the exception of the letter x, and a hyphen followed by one or more subtags of
 * two to eight characters each, separated by hyphens;
 *
 * - (Not implemented) An optional private-use subtag, composed of the letter x and a hyphen followed
 * by subtags of one to eight characters each, separated by hyphens.
 *
 * Subtags are not case-sensitive, but the specification recommends using the same case as in the
 * Language Subtag Registry, where region subtags are UPPERCASE, script subtags are Title Case, and
 * all other subtags are lowercase. This capitalization follows the recommendations of the
 * underlying ISO standards.
 *
 * Optional script and region subtags are preferred to be omitted when they add no distinguishing
 * information to a language tag. For example, es is preferred over es-Latn, as Spanish is fully
 * expected to be written in the Latin script; ja is preferred over ja-JP, as Japanese as used in Japan
 * does not differ markedly from Japanese as used elsewhere.
 *
 * Not all linguistic regions can be represented with a valid region subtag: the subnational regional
 * dialects of a primary language are registered as variant subtags. For example, the valencia variant
 * subtag for the Valencian variant of the Catalan is registered in the Language Subtag Registry with the
 * prefix ca. As this dialect is spoken almost exclusively in Spain, the region subtag ES can normally be
 * omitted.
 *
 * Or as formally defined in [Unicode Locale Data Markup Language](https://unicode.org/reports/tr35/#unicode-language-identifier):
 *
 * |                                                                                        | **EBNF**                                                                                                                                                        | **Validity / Comments**                                                                                                                                                               |
 * |----------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
 * | [`unicode_language_id`](https://unicode.org/reports/tr35/#unicode_language_id)         | = `"root"<br> \| (unicode_language_subtag (sep unicode_script_subtag)?<br> \| unicode_script_subtag) (sep unicode_region_subtag)? (sep unicode_variant_subtag)* ;` | "root" is treated as a special `unicode_language_subtag`                                                                                                                              |
 * | [`unicode_language_subtag`](https://unicode.org/reports/tr35/#unicode_language_subtag) | = `alpha{2,3}      \| alpha{5,8};`                                                                                                                                | [validity](https://unicode.org/reports/tr35/#unicode_language_subtag_validity)<br>[latest-data](https://github.com/unicode-org/cldr/blob/maint/maint-41/common/validity/language.xml) |
 * | [`unicode_script_subtag`](https://unicode.org/reports/tr35/#unicode_script_subtag)     | = `alpha{4} ;`                                                                                                                                                   | [validity](https://unicode.org/reports/tr35/#unicode_script_subtag_validity)<br>[latest-data](https://github.com/unicode-org/cldr/blob/maint/maint-41/common/validity/script.xml)     |
 * | [`unicode_region_subtag`](https://unicode.org/reports/tr35/#unicode_region_subtag)     | = `(alpha{2} \| digit{3}) ;`                                                                                                                                      | [validity](https://unicode.org/reports/tr35/#unicode_region_subtag_validity)<br>[latest-data](https://github.com/unicode-org/cldr/blob/maint/maint-41/common/validity/region.xml)     |
 * | [`unicode_variant_subtag`](https://unicode.org/reports/tr35/#unicode_variant_subtag)   | = `(alphanum{5,8}<br> \| digit alphanum{3}) ;`                                                                                                                    | [validity](https://unicode.org/reports/tr35/#unicode_variant_subtag_validity)<br>[latest-data](https://github.com/unicode-org/cldr/blob/maint/maint-41/common/validity/variant.xml)   |
 * | `sep`                                                                                  | = `[-_] ; `                                                                                                                                                       |                                                                                                                                                                                       |
 * | `digit`                                                                                | = `[0-9] ;`                                                                                                                                                       |                                                                                                                                                                                       |
 * | `alpha`                                                                                | = `[A-Z a-z] ;`                                                                                                                                                   |                                                                                                                                                                                       |
 * | `alphanum`                                                                             | = `[0-9 A-Z a-z]` ;                                                                                                                                               |                                                                                                                                                                                       |
 *
 */
class LanguageTag(
    val tag: String,

    /**
     * Lowercase alpha-2 two-letter or alpha-3 three-letter ISO 639 language code. See [Language] for available language codes.
     */
    val languageCode: String,

    /**
     * Optional region subtag based on a two-letter country code from ISO 3166-1 alpha-2 (usually
     * written in upper case), or a three-digit code from UN M.49 for geographical regions.
     *
     * See [Region] for available region codes.
     */
    val regionCode: String? = null,

    /**
     * Optional script subtag, based on a four-letter script code from ISO 15924 (usually written in Title Case).
     */
    val scriptCode: String? = null,

    /**
     * Optional variant subtags, separated by hyphens, each composed of five to eight letters, or of
     * four characters starting with a digit.
     */
    val variantCode: String? = null,

    language: Language? = null,

    region: Region? = null,

    script: Script? = null,

    variant: Variant? = null,
) {

    companion object {

        private val service = LanguageTagService()

        /**
         * The current language tag as returned by the system
         */
        val current: LanguageTag by lazy { Platform.getSystemLocale() }

        val availableLanguageTagsAsString: List<String> by lazy { availableLanguageTagsByTag.keys.sorted().toImmutableList() }

        val availableLanguageTags: List<LanguageTag> by lazy { availableLanguageTagsByTag.values.sortedBy { it.tag }.toImmutableList() }

        val availableLanguageTagsByTag: Map<String, LanguageTag> by lazy { AvailableLanguageTags.availableLanguageTags }

        fun hasTag(languageTag: String): Boolean = availableLanguageTagsByTag.containsKey(languageTag)


        // constants for languages, selection similar to that one from java.util.Locale

        val English: LanguageTag by lazy { ofAvailable("en") }

        val French: LanguageTag by lazy { ofAvailable("fr") }

        val German: LanguageTag by lazy { ofAvailable("de") }

        val Italian: LanguageTag by lazy { ofAvailable("it") }

        val Japanese: LanguageTag by lazy { ofAvailable("ja") }

        val Korean: LanguageTag by lazy { ofAvailable("ko") }

        val Chinese: LanguageTag by lazy { ofAvailable("zh") }

        val Arabic: LanguageTag by lazy { ofAvailable("ar") }

        val Russian: LanguageTag by lazy { ofAvailable("ru") }


        fun of(language: Language, region: Region? = null, script: Script? = null, variant: Variant? = null) = LanguageTag(
            service.createTag(language, region, script, variant),
            language.isoCode, region?.code, script?.code, variant?.code, language, region, script, variant)

        /**
         * Returns the existing LanguageTag object for this languageTag from [availableLanguageTagsByTag] or null.
         *
         * Returns null if [languageTag] is not found in [availableLanguageTagsByTag], even though [languageTag] may is
         * formally correct.
         */
        fun ofAvailableOrNull(languageTag: String): LanguageTag? =
            availableLanguageTagsByTag[languageTag]

        /**
         * Returns the existing LanguageTag object for this languageTag from [availableLanguageTagsByTag] or
         * throws an exception if no LanguageTag with this languageTag is known.
         */
        fun ofAvailable(languageTag: String): LanguageTag =
            ofAvailableOrNull(languageTag)
                ?: throw IllegalArgumentException("A LanguageTag with tag '$languageTag' is not found in LanguageTag.availableLanguageTags (even though it may is formally correct).")


        fun parseOrNull(languageTag: String): LanguageTag? = service.parseOrNull(languageTag)

        fun parse(languageTag: String): LanguageTag = service.parse(languageTag)

    }


    val parent: LanguageTag? by lazy { service.tryFindParent(this) }

    /**
     * The [languageCode] mapped to [Language], if possible (should almost always be possible
     * except for rare cases like root locale.
     */
    val language: Language? by lazy { language ?: service.findLanguageOrNull(languageCode) }

    /**
     * The [regionCode] mapped to [Region], if possible.
     */
    val region: Region? by lazy { region ?: regionCode?.let { service.findRegionOrNull(it) } }

    /**
     * The [scriptCode] mapped to [Script], if possible.
     */
    val script: Script? by lazy { script ?: scriptCode?.let { service.findScriptOrNull(it) } }

    /**
     * The [variantCode] mapped to [Variant], if possible.
     */
    val variant: Variant? by lazy { variant ?: variantCode?.let { service.findVariantOrNull(it) } }

    val hasOnlyLanguageCode: Boolean = regionCode == null && scriptCode == null && variantCode == null


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LanguageTag) return false

        if (tag != other.tag) return false

        return true
    }

    override fun hashCode(): Int {
        return tag.hashCode()
    }

    override fun toString() = tag
}