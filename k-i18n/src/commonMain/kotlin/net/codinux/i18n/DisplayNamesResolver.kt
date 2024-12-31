package net.codinux.i18n

import net.codinux.csv.reader.CsvReader
import kotlin.jvm.JvmOverloads

open class DisplayNamesResolver {

    companion object {
        val CsvFormatsSeparator = ':'
    }


    protected open val csvReader = CsvReader(CsvFormatsSeparator)

    // TODO: use thread safe Map / Cache (but should actually also work without as display names should only be resolved from UI thread)
    protected open val languageDisplayNamesCache = mutableMapOf<String, Map<String, String>>()

    protected open val regionDisplayNamesCache = mutableMapOf<String, Map<String, String>>()

    protected open val currencyDisplayNamesCache = mutableMapOf<String, Map<String, String>>()


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
        getDisplayNamesHierarchically(language, languageDisplayNamesCache) {
            LanguageDisplayNames.getDisplayNamesForLocale(it.tag)
        }


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
        getDisplayNamesHierarchically(language, regionDisplayNamesCache) { RegionDisplayNames.getDisplayNamesForLocale(it.tag) }


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
        getDisplayNamesHierarchically(language, currencyDisplayNamesCache) { CurrencyDisplayNames.getDisplayNamesForLocale(it.tag) }


    protected open fun getDisplayNamesHierarchically(language: LanguageTag, cache: MutableMap<String, Map<String, String>>? = null, getForTag: (LanguageTag) -> String?): Map<String, String>? {
        cache?.get(language.tag)?.let {
            return it
        }

        val displayNamesCsv = getForTag(language)

        return if (displayNamesCsv != null) {
            csvReader.read(displayNamesCsv).associate { it.getString(0) to it.getString(1) }.also {
                cache?.put(language.tag, it)
            }
        } else {
            val parent = language.parent
            if (parent != null) {
                getDisplayNamesHierarchically(parent, cache, getForTag)
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