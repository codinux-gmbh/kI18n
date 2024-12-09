package net.codinux.i18n

import net.codinux.i18n.platform.Platform

class DisplayNames {

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

}