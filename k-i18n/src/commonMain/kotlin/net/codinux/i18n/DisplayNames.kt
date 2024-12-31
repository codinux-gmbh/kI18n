package net.codinux.i18n

import kotlin.jvm.JvmOverloads

open class DisplayNames(
    protected open val resolver: DisplayNamesResolver = DisplayNamesResolver()
) {

    @JvmOverloads
    open fun getAllLanguageDisplayNamesForLanguage(language: LanguageTag = LanguageTag.current): Map<String, String>? =
        resolver.getAllLanguageDisplayNamesForLanguage(language)

    @JvmOverloads
    open fun getLanguageDisplayName(language: Language, displayLanguage: LanguageTag = LanguageTag.current): String? =
        getLanguageDisplayName(language.isoCode, displayLanguage)

    @JvmOverloads
    open fun getLanguageDisplayName(languageIsoCode: String, displayLanguage: LanguageTag = LanguageTag.current): String? =
        resolver.getLanguageDisplayName(languageIsoCode, displayLanguage)


    @JvmOverloads
    open fun getAllRegionDisplayNamesForLanguage(language: LanguageTag = LanguageTag.current): Map<String, String>? =
        getDisplayNameHierarchically(language) { RegionDisplayNames.getDisplayNamesForLocale(it) }

    @JvmOverloads
    open fun getRegionDisplayName(region: Region, language: LanguageTag = LanguageTag.current): String? =
        getRegionDisplayName(region.code, language)

    @JvmOverloads
    open fun getRegionDisplayName(regionCode: String, language: LanguageTag = LanguageTag.current): String? =
        getDisplayNameHierarchically(language) { RegionDisplayNames.getDisplayName(regionCode, it) }


    @JvmOverloads
    open fun getAllCurrencyDisplayNamesForLanguage(language: LanguageTag = LanguageTag.current): Map<String, String>? =
        getDisplayNameHierarchically(language) { CurrencyDisplayNames.getDisplayNamesForLocale(it) }

    @JvmOverloads
    open fun getCurrencyDisplayName(currency: Currency, language: LanguageTag = LanguageTag.current): String? =
        getCurrencyDisplayName(currency, language)

    @JvmOverloads
    open fun getCurrencyDisplayName(currencyIsoCode: String, language: LanguageTag = LanguageTag.current): String? =
        getDisplayNameHierarchically(language) { CurrencyDisplayNames.getDisplayName(currencyIsoCode, it) }


    protected open fun <T> getDisplayNameHierarchically(language: LanguageTag, getForTag: (LanguageTag) -> T?): T? {
        val displayName = getForTag(language)

        return if (displayName != null && (displayName !is Map<*, *> || displayName.isNotEmpty())) {
            displayName
        } else {
            val parent = language.parent
            if (parent != null) {
                getDisplayNameHierarchically(parent, getForTag)
            } else {
                null
            }
        }
    }

}