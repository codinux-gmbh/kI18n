package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import net.codinux.csv.use
import net.codinux.csv.writer.CsvWriter
import net.codinux.i18n.DisplayNamesResolver
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.model.TerritoryDisplayNames
import net.codinux.i18n.parser.CldrJsonParser

class RegionDisplayNamesClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    companion object {
        private val ClassKdoc = "Had to switch from Map<String, String> to CSV as compiler complained about too many parameters in function, wasmJs didn't even start in release build"
    }


    private val csvWriter = CsvWriter.builder(DisplayNamesResolver.CsvFormatsSeparator)


    fun generate() {
        val locales = cldrJsonParser.getLocalesWithLocalizedRegionNames().map { LanguageTag.ofAvailable(it) }

        val displayNamesByLanguageTag = locales.associateWith { cldrJsonParser.parseRegionNamesForLocale(it) }
        // don't add display names redundantly, if they have the same display name as in parent locale, don't add them to file but look them up in parent locale
        val uniqueDisplayNamesByLanguageTag = removeRedundantValuesFromSubLocales(displayNamesByLanguageTag)

        val nullableString = String::class.asTypeName().copy(nullable = true)

        // all LanguageTags as lazy property returning a Map with all available display names
        val regionDisplayNamesProperties = uniqueDisplayNamesByLanguageTag
            .map { (languageTag, regionDisplayNames) ->
                PropertySpec.builder(languageTag.tag.replace('-', '_'), nullableString.copy(nullable = regionDisplayNames.isEmpty())).apply {
                    if (regionDisplayNames.isEmpty()) {
                        this.initializer("%L", "null")
                    } else {
                        val csv = StringBuilder()
                        csvWriter.writer(csv).use { csvWriter ->
                            regionDisplayNames.forEach { displayName ->
                                csvWriter.writeRow(displayName.territoryCode, displayName.displayName.replace("\"", "\'"))
                            }
                        }
                        this.delegate("lazy { \"\"\"\n%L\"\"\".trimIndent() }", csv.toString())
                    }
                }.build()
            }

        // method to find all region display names of a LanguageTag
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

        util.writeClass("RegionDisplayNames", regionDisplayNamesProperties, listOf(getDisplayNamesForLocaleMethod), kdoc = ClassKdoc)
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