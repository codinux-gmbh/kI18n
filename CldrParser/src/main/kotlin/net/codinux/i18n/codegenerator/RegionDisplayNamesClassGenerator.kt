package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import net.codinux.collections.ImmutableMap
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.model.TerritoryDisplayNames
import net.codinux.i18n.parser.CldrJsonParser

class RegionDisplayNamesClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val locales = cldrJsonParser.getLocalesWithLocalizedRegionNames().map { LanguageTag.ofAvailable(it) }

        val displayNamesByLanguageTag = locales.associateWith { cldrJsonParser.parseRegionNamesForLocale(it) }
        // don't add display names redundantly, if they have the same display name as in parent locale, don't add them to file but look them up in parent locale
        val uniqueDisplayNamesByLanguageTag = removeRedundantValuesFromSubLocales(displayNamesByLanguageTag)

        val parameterizedType = ImmutableMap::class.parameterizedBy(String::class, String::class)
        val immutableMapOfReference = MemberName("net.codinux.collections", "immutableMapOf")

        // all LanguageTags as lazy property returning a Map with all available display names
        val regionDisplayNamesProperties = uniqueDisplayNamesByLanguageTag
            .map { (languageTag, regionDisplayNames) ->
                PropertySpec.builder(languageTag.tag.replace('-', '_'), parameterizedType)
                    .delegate(CodeBlock.builder().apply {
                        addStatement("lazy { %M(", immutableMapOfReference)

                        regionDisplayNames.forEach { displayName ->
                            addStatement("  %S to %S,", displayName.territoryCode, displayName.displayName)
                        }

                        add(") }")
                    }.build()
                    )
                    .build()
            }

        // method to find all region display names of a LanguageTag
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

        // method to find region display name by LanguageTag and regionCode
        val getDisplayNameMethod = FunSpec.builder("getDisplayName")
            .addParameter("regionCode", String::class)
            .addParameter("language", String::class)
            .returns(String::class.asTypeName().copy(nullable = true))
            .addStatement("return %N(language)?.get(regionCode)", getDisplayNamesForLocaleMethod)
            .build()

        util.writeClass("RegionDisplayNames", regionDisplayNamesProperties, companionObjectMethods = listOf(getDisplayNamesForLocaleMethod, getDisplayNameMethod))
    }

    private fun removeRedundantValuesFromSubLocales(displayNamesByLanguageTag: Map<LanguageTag, List<TerritoryDisplayNames>>): Map<LanguageTag, List<TerritoryDisplayNames>> {

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
        displayNamesByLanguageTag: Map<LanguageTag, List<TerritoryDisplayNames>>,
        parentLanguageTag: LanguageTag,
        displayNames: List<TerritoryDisplayNames>
    ): List<TerritoryDisplayNames> {
        val parentDisplayValues = displayNamesByLanguageTag[parentLanguageTag]

        return if (parentDisplayValues == null) {
            displayNames
        } else {
            val parentDisplayValuesByCode = parentDisplayValues.associateBy { it.territoryCode }
            displayNames.filter { it.displayName != parentDisplayValuesByCode[it.territoryCode]?.displayName }
        }
    }

}