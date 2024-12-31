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