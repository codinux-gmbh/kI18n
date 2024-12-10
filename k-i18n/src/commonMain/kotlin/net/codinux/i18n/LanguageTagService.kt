package net.codinux.i18n

class LanguageTagService {

    fun parseOrNull(languageTag: String): LanguageTag? {
        val parts = languageTag.split('-')
        val languageCode = parts[0]
        if (languageCode.length !in 2..3 || languageCode.any { it.isLetter() && it.isLowerCase() == false }) {
            return null
        }

        val regionCode = parts.drop(1).firstOrNull {
            // two-letter alpha-2 code or three-digit UN M.49 code
            (it.length == 2 && it.all { it.isUpperCase() }) || (it.length == 3 && it.all { it.isDigit() })
        }

        // four-letter ISO 15924 code in title case (= first letter uppercase, the three remaining letters lowercase)
        val scriptCode = parts.drop(1).firstOrNull { it.length == 4 && it[0].isUpperCase() && it.drop(1).all { it.isLowerCase() } }

        // five to eight lowercase letters
        val variant = parts.drop(1).firstOrNull { it.length in 5..8 && it.all { it.isLowerCase() } }

        // feasibility check: if parts size == 2 then we have to find either region, script or variant; for parts size == 3 two have to be non-null; for parts.size == 4 all three have to be non-null; code or both; currently we cannot handle parts sized > 4
        val countNonNull = (if (regionCode == null) 0 else 1) + (if (scriptCode == null) 0 else 1) + (if (variant != null) 0 else 1)
        if ((parts.size == 2 && countNonNull == 1)
            || (parts.size == 3 && countNonNull == 2)
            || (parts.size == 4 && countNonNull == 3)
            || parts.size > 4) {
            return null
        }

        return LanguageTag(languageTag, languageCode, regionCode, scriptCode, variant)
    }

    fun parse(languageTag: String): LanguageTag =
        parseOrNull(languageTag)
            ?: throw IllegalArgumentException("Cannot create a LanguageTag from string '$languageTag'. A valid LanguageTag starts with two- or three lower case characters for the language, see [Language] class for available values. Optionally, all separated by hyphens, a two-letter upper case or three-digit region code and a four-letter script code in title case follow.")


    /**
     *
     * cldr-json/cldr-core/supplemental/parentLocales.json parsen und zu LanguageTag hinzufuegen (oder Lookup dafuer erstellen)?
     * Ebenso cldr-json/cldr-core/supplemental/likelySubtags.json ?
     *
     *
     * Thus there are two cases where the truncation inheritance needs to be overridden:
     *
     *     1. When the parent locale would have a different script, and text would be mixed.
     *     2. In certain exceptional circumstances where the 'truncation' parent needs to be adjusted.
     *
     * The parentLocale element is used to override the normal inheritance when accessing CLDR data.
     *
     * For case 1, there is a special attribute and value, localeRules="nonlikelyScript", which specifies all locales of the form lang_script, wherever the script is not the likely script for lang. For migration, the previous short list of locales (a subset of the nonlikelyScript locales) is retained, but those locales are slated for removal in the future. For example, ru_Latn is not included in the short list but is included (programmatically) in the rule.
     *
     * <parentLocale parent="root" localeRules="nonlikelyScript" locales="az_Arab az_Cyrl bal_Latn … yue_Hans zh_Hant"/>/>
     *
     * The localeRules is used for the main component, for example. It is not used to components where text is not mixed, such as the collations component or the plurals component.
     *
     * For case 2, the children and parent share the same primary language, but the region is changed. For example:
     *
     * <parentLocale parent="es_419" locales="es_AR es_BO … es_UY es_VE"/>
     *
     * There are certain invariants that must always be true:
     *
     *     3. The parent must either be the root locale or have the same script as the child. This rule applies to component=main.
     *     4. There must never be cycles, such as: X parent of Y ... parent of X.
     *     5. Following the inheritance path, using parentLocale where available and otherwise truncating the locale, must always lead eventually to the root locale.
     *
     * (https://www.unicode.org/reports/tr35/tr35-73/tr35.html#Locale)
     */
    fun tryFindParent(languageTag: LanguageTag): LanguageTag? =
        if (languageTag.variant != null) {
            LanguageTag.parse(languageTag.tag.replace("-${languageTag.variant}", ""))
        } else if (languageTag.regionCode != null) {
            LanguageTag.parse(languageTag.tag.replace("-${languageTag.regionCode}", ""))
        } else {
            // currently we cannot determine correct parent if script is set
            null // we are already at the parent for this language; theoretically we could go up to world etc.
        }


    fun findLanguageOrNull(language: String): Language? =
        Language.entries.firstOrNull { it.isoCode.equals(language, true) }

    fun findLanguage(language: String): Language =
        findLanguageOrNull(language)
            ?: throw IllegalArgumentException("Language with ISO code '$language' not found in Language enum. Parameter language must be a two- or three-letter ISO 639 language code. See Language enum for possible values.")


    fun findRegionOrNull(regionCode: String): Region? =
        Region.entries.firstOrNull {
            regionCode.equals(it.alpha2Code, true) || regionCode.equals(it.alpha3Code, true) ||
                    // numericCodeAsString is padded with zero, may regionCode is passed without leading zeros -> compare also against numericCode.toString()
                    regionCode.equals(it.numericCodeAsString, true) || regionCode.equals(it.numericCode?.toString(), true)
        }

}