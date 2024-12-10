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


    fun tryFindParent(languageTag: LanguageTag): LanguageTag? =
        if (languageTag.variant != null) {
            LanguageTag.parse(languageTag.tag.replace("-${languageTag.variant}", ""))
        } else if (languageTag.region != null) {
            LanguageTag.parse(languageTag.tag.replace("-${languageTag.region}", ""))
        } else {
            // currently we cannot determine correct parent if script is set
            null // we are already at the parent for this language; theoretically we could go up to world etc.
        }

}