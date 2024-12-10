package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import net.codinux.collections.ImmutableMap
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.model.Currency
import net.codinux.i18n.parser.CldrJsonParser

class CurrencyDisplayNamesClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val locales = cldrJsonParser.getLocalesWithLocalizedCurrencies().map { LanguageTag.ofAvailable(it) }

        val displayNamesByLanguageTag = locales.associateWith { cldrJsonParser.parseCurrenciesForLocale(it) }
        // don't add display names redundantly, if they have the same display name as in parent locale, don't add them to file but look them up in parent locale
        val uniqueDisplayNamesByLanguageTag = removeRedundantValuesFromSubLocales(displayNamesByLanguageTag)

        val parameterizedType = ImmutableMap::class.parameterizedBy(String::class, String::class)
        val immutableMapOfReference = MemberName("net.codinux.collections", "immutableMapOf")

        // all LanguageTags as lazy property returning a Map with all available display names
        val currencyDisplayNamesProperties = uniqueDisplayNamesByLanguageTag
            .map { (languageTag, currencyDisplayNames) ->
                PropertySpec.builder(languageTag.tag.replace('-', '_'), parameterizedType)
                    .delegate(CodeBlock.builder().apply {
                        addStatement("lazy { %M(", immutableMapOfReference)

                        currencyDisplayNames.forEach { currency ->
                            val displayName = currency.displayName ?: currency.displayNameCountOther ?: currency.displayNameCountOne
                            if (displayName != null) {
                                addStatement("  %S to %S,", currency.isoCode, displayName)
                            }
                        }

                        add(") }")
                    }.build()
                    )
                    .build()
            }

        // method to find all currency display names of a LanguageTag
        val getDisplayNamesForLocaleMethod = FunSpec.builder("getDisplayNamesForLocale")
            .addParameter("language", String::class)
            .returns(parameterizedType.copy(nullable = true))
            .apply {
                beginControlFlow("return when(language) {")
                uniqueDisplayNamesByLanguageTag.forEach { (languageTag, _) ->
                    addStatement("%S -> %N", languageTag.tag, languageTag.tag.replace('-', '_'))
                }
                addStatement("else -> null")
                endControlFlow()
            }.build()

        // method to find currency display name by LanguageTag and currencyIsoCode
        val getDisplayNameMethod = FunSpec.builder("getDisplayName")
            .addParameter("currencyIsoCode", String::class)
            .addParameter("language", String::class)
            .returns(String::class.asTypeName().copy(nullable = true))
            .addStatement("return %N(language)?.get(currencyIsoCode)", getDisplayNamesForLocaleMethod)
            .build()

        util.writeClass("CurrencyDisplayNames", currencyDisplayNamesProperties, companionObjectMethods = listOf(getDisplayNamesForLocaleMethod, getDisplayNameMethod))
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