package net.codinux.i18n

import net.codinux.i18n.platform.Platform

class DisplayNames {

    fun getLanguageDisplayName(languageIsoCode: String, language: LanguageTag = Platform.getSystemLocale()): String? {
        val displayName = LanguageDisplayNames.getDisplayName(languageIsoCode, language)

        return if (displayName != null) {
            displayName
        } else {
            val parent = language.parent()
            if (parent != null) {
                getLanguageDisplayName(languageIsoCode, parent)
            } else {
                null
            }
        }
    }

    fun getRegionDisplayName(regionCode: String, language: LanguageTag = Platform.getSystemLocale()): String? {
        val displayName = RegionDisplayNames.getDisplayName(regionCode, language)

        return if (displayName != null) {
            displayName
        } else {
            val parent = language.parent()
            if (parent != null) {
                getRegionDisplayName(regionCode, parent)
            } else {
                null
            }
        }
    }

    fun getCurrencyDisplayName(currencyIsoCode: String, language: LanguageTag = Platform.getSystemLocale()): String? {
        val displayName = CurrencyDisplayNames.getDisplayName(currencyIsoCode, language)

        return if (displayName != null) {
            displayName
        } else {
            val parent = language.parent()
            if (parent != null) {
                getCurrencyDisplayName(currencyIsoCode, parent)
            } else {
                null
            }
        }
    }

}