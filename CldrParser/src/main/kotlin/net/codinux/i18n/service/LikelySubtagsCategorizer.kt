package net.codinux.i18n.service

import net.codinux.i18n.Language
import net.codinux.i18n.Region
import net.codinux.i18n.Script
import net.codinux.i18n.parser.CldrJsonParser

class LikelySubtagsCategorizer(
    private val likelySubtags: Map<String, String>
) {

    constructor(cldrJsonParser: CldrJsonParser) : this(cldrJsonParser.parseLikelySubtags())


    fun getDefaultScriptAndRegionForAllLanguages(): Map<String, Pair<Region, Script>> {
        val languageTags = likelySubtags.filter { it.key.length in 2..3 && it.key.all { it.isLowerCase() } }

        // there are so much more languages than we have in our Language enum
        return languageTags.map { it.key }
            .associateWith { getDefaultScriptAndRegionForLanguage(it)!! }
    }

    fun getDefaultScriptAndRegionForLanguage(language: Language) =
        getDefaultScriptAndRegionForLanguage(language.isoCode)

    fun getDefaultScriptAndRegionForLanguage(languageIsoCode: String): Pair<Region, Script>? {
        val languageEntry = likelySubtags[languageIsoCode]
        if (languageEntry != null) {
            val (_, scriptOrRegion, region: String?) = languageEntry.split('-')

            return Pair(regionFor(region), scriptFor(scriptOrRegion))
        }

        return null
    }


    fun getDefaultLanguageAndScriptForAllRegions(): Map<Region, Pair<Language, Script>> {
        val regionTags = likelySubtags.filter { it.key.startsWith("und-") && it.key.length == 6 && it.key.drop(4).all { it.isUpperCase() } }

        return regionTags.map { regionFor(it.key.substring(4)) }
            .associateWith { getDefaultLanguageAndScriptForRegion(it)!! }
    }

    fun getDefaultLanguageAndScriptForRegion(region: Region) =
        getDefaultLanguageAndScriptForRegion(region.code)

    fun getDefaultLanguageAndScriptForRegion(regionCode: String): Pair<Language, Script>? {
        val regionEntry = likelySubtags["und-$regionCode"]

        return regionEntry?.let {
            val parts = it.split('-')
            languageFor(parts.first()) to scriptFor(parts[1])
        }
    }


    fun getDefaultLanguageAndRegionForAllScripts(): Map<Script, Pair<Language?, Region>> {
        val scriptTags = likelySubtags.filter { it.key.startsWith("und-") && it.key.length == 8 && it.key[4].isUpperCase() && it.key.drop(5).all { it.isLowerCase() } }

        return scriptTags.map { scriptFor(it.key.substring(4)) }
            .associateWith { getDefaultLanguageAndRegionForScript(it)!! }
    }

    fun getDefaultLanguageAndRegionForScript(script: Script) =
        getDefaultLanguageAndRegionForScript(script.code)

    fun getDefaultLanguageAndRegionForScript(scriptCode: String): Pair<Language?, Region>? {
        val regionEntry = likelySubtags["und-$scriptCode"]

        return regionEntry?.let {
            val parts = it.split('-')

            // there are much more languages than we have in our Language enum
            languageForOrNull(parts.first()) to regionFor(parts[2])
        }
    }


    private fun languageForOrNull(languageCode: String): Language? =
        Language.entries.firstOrNull { languageCode == it.isoCode }

    private fun languageFor(languageCode: String) =
        languageForOrNull(languageCode)!!

    private fun regionFor(regionCode: String): Region =
        Region.entries.first { regionCode == it.code }

    private fun scriptFor(scriptCode: String): Script =
        Script.entries.first { scriptCode == it.code }

}