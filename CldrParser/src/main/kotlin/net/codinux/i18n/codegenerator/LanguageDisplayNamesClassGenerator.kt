package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import net.codinux.collections.ImmutableMap
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.model.LanguageDisplayNames
import net.codinux.i18n.parser.CldrJsonParser

class LanguageDisplayNamesClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val locales = cldrJsonParser.getLocalesWithLocalizedLanguageNames().map { LanguageTag.ofAvailable(it) }

        val displayNamesByLanguageTag = locales.associateWith { cldrJsonParser.parseLanguageNamesForLocale(it) }
        // don't add display names redundantly, if they have the same display name as in parent locale, don't add them to file but look them up in parent locale
        val uniqueDisplayNamesByLanguageTag = removeRedundantValuesFromSubLocales(displayNamesByLanguageTag)

        val parameterizedType = ImmutableMap::class.parameterizedBy(String::class, String::class)
        val immutableMapOfReference = MemberName("net.codinux.collections", "immutableMapOf")

        // all LanguageTags as lazy property returning a Map with all available display names
        val languageDisplayNamesProperties = uniqueDisplayNamesByLanguageTag
            .map { (languageTag, languageDisplayNames) ->
                PropertySpec.builder(languageTag.tag.replace('-', '_'), parameterizedType)
                    .delegate(CodeBlock.builder().apply {
                        addStatement("lazy { %M(", immutableMapOfReference)

                        languageDisplayNames.forEach { displayName ->
                            addStatement("  %S to %S,", displayName.languageIsoCode, displayName.displayName)
                        }

                        add(") }")
                    }.build()
                    )
                    .build()
            }

        // method to find language display name by LanguageTag and languageIsoCode
        val getDisplayNameMethod = FunSpec.builder("getDisplayName")
            .addParameter("languageIsoCode", String::class)
            .addParameter("language", LanguageTag::class)
            .returns(String::class.asTypeName().copy(nullable = true))
            .apply {
                beginControlFlow("return when(language.tag) {")
                uniqueDisplayNamesByLanguageTag.forEach { (languageTag, _) ->
                    addStatement("%S -> %N[languageIsoCode]", languageTag.tag, languageTag.tag.replace('-', '_'))
                }
                addStatement("else -> null")
                endControlFlow()
            }.build()

        util.writeClass("LanguageDisplayNames", languageDisplayNamesProperties, companionObjectMethods = listOf(getDisplayNameMethod))
    }

    private fun removeRedundantValuesFromSubLocales(displayNamesByLanguageTag: Map<LanguageTag, List<LanguageDisplayNames>>): Map<LanguageTag, List<LanguageDisplayNames>> {

        return displayNamesByLanguageTag.mapValues { (languageTag, displayNames) ->
            val parent = languageTag.parent()
            if (parent != null) {
                filterRedundantValues(displayNamesByLanguageTag, parent, displayNames)
            } else {
                displayNames // when there is no parent for this languageTag, then there are no redundant values to remove -> use displayNames
            }
        }
    }

    private fun filterRedundantValues(
        displayNamesByLanguageTag: Map<LanguageTag, List<LanguageDisplayNames>>,
        parentLanguageTag: LanguageTag,
        displayNames: List<LanguageDisplayNames>
    ): List<LanguageDisplayNames> {
        val parentDisplayValues = displayNamesByLanguageTag[parentLanguageTag]

        return if (parentDisplayValues == null) {
            displayNames
        } else {
            val parentDisplayValuesByCode = parentDisplayValues.associateBy { it.languageIsoCode }
            displayNames.filter { it.displayName != parentDisplayValuesByCode[it.languageIsoCode]?.displayName }
        }
    }

}