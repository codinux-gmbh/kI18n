package net.codinux.i18n

import net.codinux.csv.reader.CsvReader
import kotlin.jvm.JvmOverloads

open class DisplayNamesResolver {

    companion object {
        val CsvFormatsSeparator = ':'
    }


    protected open val csvReader = CsvReader(CsvFormatsSeparator)


    @JvmOverloads
    open fun getLanguageDisplayName(language: Language, displayLanguage: LanguageTag = LanguageTag.current): String? =
        getLanguageDisplayName(language.isoCode, displayLanguage)

    @JvmOverloads
    open fun getLanguageDisplayName(languageIsoCode: String, displayLanguage: LanguageTag = LanguageTag.current): String? =
        getDisplayNameHierarchically(languageIsoCode, displayLanguage) {
            getAllLanguageDisplayNamesForLanguage(it)
        }

    @JvmOverloads
    open fun getAllLanguageDisplayNamesForLanguage(language: LanguageTag = LanguageTag.current): Map<String, String>? =
        getDisplayNamesHierarchically(language) { LanguageDisplayNames.getDisplayNamesForLocale(it.tag) }


    @JvmOverloads
    open fun getRegionDisplayName(region: Region, language: LanguageTag = LanguageTag.current): String? =
        getRegionDisplayName(region.code, language)

    @JvmOverloads
    open fun getRegionDisplayName(regionCode: String, language: LanguageTag = LanguageTag.current): String? =
        getDisplayNameHierarchically(regionCode, language) {
            getAllRegionDisplayNamesForLanguage(it)
        }

    @JvmOverloads
    open fun getAllRegionDisplayNamesForLanguage(language: LanguageTag = LanguageTag.current): Map<String, String>? =
        getDisplayNamesHierarchically(language) { RegionDisplayNames.getDisplayNamesForLocale(it.tag) }


    @JvmOverloads
    open fun getCurrencyDisplayName(currency: Currency, language: LanguageTag = LanguageTag.current): String? =
        getCurrencyDisplayName(currency, language)

    @JvmOverloads
    open fun getCurrencyDisplayName(currencyIsoCode: String, language: LanguageTag = LanguageTag.current): String? =
        getDisplayNameHierarchically(currencyIsoCode, language) {
            getAllCurrencyDisplayNamesForLanguage(it)
        }

    @JvmOverloads
    open fun getAllCurrencyDisplayNamesForLanguage(language: LanguageTag = LanguageTag.current): Map<String, String>? =
        getDisplayNamesHierarchically(language) { CurrencyDisplayNames.getDisplayNamesForLocale(it.tag) }


    protected open fun getDisplayNamesHierarchically(language: LanguageTag, getForTag: (LanguageTag) -> String?): Map<String, String>? {
        val displayNamesCsv = getForTag(language)

        return if (displayNamesCsv != null) {
            csvReader.read(displayNamesCsv).associate { it.getString(0) to it.getString(1) }
        } else {
            val parent = language.parent
            if (parent != null) {
                getDisplayNamesHierarchically(parent, getForTag)
            } else {
                null
            }
        }
    }

    protected open fun getDisplayNameHierarchically(languageIsoCode: String, displayLanguage: LanguageTag, getForTag: (LanguageTag) -> Map<String, String>?): String? {
        val displayNames = getForTag(displayLanguage)

        return if (displayNames != null && displayNames.containsKey(languageIsoCode)) {
            displayNames[languageIsoCode]
        } else {
            val parent = displayLanguage.parent
            if (parent != null) {
                getDisplayNameHierarchically(languageIsoCode, parent, getForTag)
            } else {
                null
            }
        }
    }

}