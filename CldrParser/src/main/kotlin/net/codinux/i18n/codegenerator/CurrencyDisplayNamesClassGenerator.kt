package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import net.codinux.csv.use
import net.codinux.csv.writer.CsvWriter
import net.codinux.i18n.DisplayNamesResolver
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.model.Currency
import net.codinux.i18n.parser.CldrJsonParser

class CurrencyDisplayNamesClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    companion object {
        private val ClassKdoc = "Had to switch from Map<String, String> to CSV as compiler complained about too many parameters in function, wasmJs didn't even start in release build"
    }


    private val csvWriter = CsvWriter.builder(DisplayNamesResolver.CsvFormatsSeparator)


    fun generate() {
        val locales = cldrJsonParser.getLocalesWithLocalizedCurrencies().map { LanguageTag.ofAvailable(it) }

        val displayNamesByLanguageTag = locales.associateWith { cldrJsonParser.parseCurrenciesForLocale(it) }
        // don't add display names redundantly, if they have the same display name as in parent locale, don't add them to file but look them up in parent locale
        val uniqueDisplayNamesByLanguageTag = removeRedundantValuesFromSubLocales(displayNamesByLanguageTag)

        val nullableString = String::class.asTypeName().copy(nullable = true)

        // all LanguageTags as lazy property returning a Map with all available display names
        val currencyDisplayNamesProperties = uniqueDisplayNamesByLanguageTag
            .map { (languageTag, currencyDisplayNames) ->
                PropertySpec.builder(languageTag.tag.replace('-', '_'), nullableString.copy(nullable = currencyDisplayNames.isEmpty())).apply {
                    if (currencyDisplayNames.isEmpty()) {
                        this.initializer("%L", "null")
                    } else {
                        val csv = StringBuilder()
                        csvWriter.writer(csv).use { csvWriter ->
                            currencyDisplayNames.forEach { currency ->
                                val displayName = currency.displayName ?: currency.displayNameCountOther ?: currency.displayNameCountOne
                                if (displayName != null) {
                                    csvWriter.writeRow(currency.isoCode, displayName)
                                }
                            }
                        }
                        this.delegate("lazy { \"\"\"\n%L\"\"\".trimIndent() }", csv.toString())
                    }
                }.build()
            }

        // method to find all currency display names of a LanguageTag
        val getDisplayNamesForLocaleMethod = FunSpec.builder("getDisplayNamesForLocale")
            .addParameter("language", String::class)
            .returns(nullableString)
            .apply {
                beginControlFlow("return when(language) {")
                uniqueDisplayNamesByLanguageTag.forEach { (languageTag, _) ->
                    addStatement("%S -> %N", languageTag.tag, languageTag.tag.replace('-', '_'))
                }
                addStatement("else -> null")
                endControlFlow()
            }.build()

        util.writeClass("CurrencyDisplayNames", currencyDisplayNamesProperties, listOf(getDisplayNamesForLocaleMethod), kdoc = ClassKdoc)
    }

    private fun removeRedundantValuesFromSubLocales(displayNamesByLanguageTag: Map<LanguageTag, List<Currency>>): Map<LanguageTag, List<Currency>> {

        return displayNamesByLanguageTag.mapValues { (languageTag, displayNames) ->
            val parent = languageTag.parent
            if (parent != null) {
                filterRedundantValues(displayNamesByLanguageTag, parent, displayNames)
            } else {
                displayNames // when there is no parent for this languageTag, then there are no redundant values to remove -> use displayNames
            }
        }
    }

    private fun filterRedundantValues(
        displayNamesByLanguageTag: Map<LanguageTag, List<Currency>>,
        parentLanguageTag: LanguageTag,
        displayNames: List<Currency>
    ): List<Currency> {
        val parentDisplayValues = displayNamesByLanguageTag[parentLanguageTag]

        return if (parentDisplayValues == null) {
            displayNames
        } else {
            val parentDisplayValuesByCode = parentDisplayValues.associateBy { it.isoCode }
            displayNames.filter { it.displayName != parentDisplayValuesByCode[it.isoCode]?.displayName }
        }
    }

}