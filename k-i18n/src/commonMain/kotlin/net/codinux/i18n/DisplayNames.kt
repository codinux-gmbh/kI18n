package net.codinux.i18n

import kotlin.jvm.JvmOverloads

class DisplayNames {

    @JvmOverloads
    fun getAllLanguageDisplayNamesForLanguage(language: LanguageTag = LanguageTag.current): Map<String, String>? {
        val displayNames = LanguageDisplayNames.getDisplayNamesForLocale(language)

        return if (displayNames.isNullOrEmpty() == false) {
            displayNames
        } else {
            val parent = language.parent
            if (parent != null) {
                getAllLanguageDisplayNamesForLanguage(parent)
            } else {
                null
            }
        }
    }

    @JvmOverloads
    fun getLanguageDisplayName(language: Language, displayLanguage: LanguageTag = LanguageTag.current): String? =
        getLanguageDisplayName(language.isoCode, displayLanguage)

    @JvmOverloads
    fun getLanguageDisplayName(languageIsoCode: String, language: LanguageTag = LanguageTag.current): String? {
        val displayName = LanguageDisplayNames.getDisplayName(languageIsoCode, language)

        return if (displayName != null) {
            displayName
        } else {
            val parent = language.parent
            if (parent != null) {
                getLanguageDisplayName(languageIsoCode, parent)
            } else {
                null
            }
        }
    }


    @JvmOverloads
    fun getAllRegionDisplayNamesForLanguage(language: LanguageTag = LanguageTag.current): Map<String, String>? {
        val displayNames = RegionDisplayNames.getDisplayNamesForLocale(language)

        return if (displayNames.isNullOrEmpty() == false) {
            displayNames
        } else {
            val parent = language.parent
            if (parent != null) {
                getAllRegionDisplayNamesForLanguage(parent)
            } else {
                null
            }
        }
    }

    @JvmOverloads
    fun getRegionDisplayName(region: Region, language: LanguageTag = LanguageTag.current): String? =
        getRegionDisplayName(region.code, language)

    @JvmOverloads
    fun getRegionDisplayName(regionCode: String, language: LanguageTag = LanguageTag.current): String? {
        val displayName = RegionDisplayNames.getDisplayName(regionCode, language)

        return if (displayName != null) {
            displayName
        } else {
            val parent = language.parent
            if (parent != null) {
                getRegionDisplayName(regionCode, parent)
            } else {
                null
            }
        }
    }


    @JvmOverloads
    fun getAllCurrencyDisplayNamesForLanguage(language: LanguageTag = LanguageTag.current): Map<String, String>? {
        val displayNames = CurrencyDisplayNames.getDisplayNamesForLocale(language)

        return if (displayNames.isNullOrEmpty() == false) {
            displayNames
        } else {
            val parent = language.parent
            if (parent != null) {
                getAllCurrencyDisplayNamesForLanguage(parent)
            } else {
                null
            }
        }
    }

    @JvmOverloads
    fun getCurrencyDisplayName(currency: Currency, language: LanguageTag = LanguageTag.current): String? =
        getCurrencyDisplayName(currency, language)

    @JvmOverloads
    fun getCurrencyDisplayName(currencyIsoCode: String, language: LanguageTag = LanguageTag.current): String? {
        val displayName = CurrencyDisplayNames.getDisplayName(currencyIsoCode, language)

        return if (displayName != null) {
            displayName
        } else {
            val parent = language.parent
            if (parent != null) {
                getCurrencyDisplayName(currencyIsoCode, parent)
            } else {
                null
            }
        }
    }

}