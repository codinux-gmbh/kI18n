package net.codinux.i18n

class DisplayNames {

    fun getLanguageDisplayName(languageIsoCode: String, language: LanguageTag = LanguageTag.current): String? {
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

    fun getRegionDisplayName(regionCode: String, language: LanguageTag = LanguageTag.current): String? {
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

    fun getCurrencyDisplayName(currencyIsoCode: String, language: LanguageTag = LanguageTag.current): String? {
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