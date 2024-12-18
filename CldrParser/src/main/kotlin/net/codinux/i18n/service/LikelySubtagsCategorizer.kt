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
        val languageTags = likelySubtags.filter { isLanguageCode(it.key) }

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
        val regionTags = likelySubtags.filter { it.key.startsWith("und-") && it.key.length == 6 && isRegionCode(it.key.substring(4)) }

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
        val scriptTags = likelySubtags.filter { it.key.startsWith("und-") && it.key.length == 8 && isScriptCode(it.key.substring(4)) }

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


    fun getDefaultRegionForAllLanguagesAndScripts(): Map<Pair<Language, Script>, Region> {
        val languageToScript = likelySubtags.filter { it.key.startsWith("und-") == false && it.key.split('-').let { it.size == 2 && isLanguageCode(it[0]) && isScriptCode(it[1]) } }
            .mapNotNull {
                val (languageCode, scriptCode) = it.key.split('-')

                languageForOrNull(languageCode)?.let {
                    language -> language to scriptFor(scriptCode)
                }
            }

        return languageToScript.associateWith { getDefaultRegionForLanguageAndScript(it.first, it.second)!! }
    }

    fun getDefaultRegionForLanguageAndScript(language: Language, script: Script) =
        getDefaultRegionForLanguageAndScript(language.isoCode, script.code)

    fun getDefaultRegionForLanguageAndScript(languageIsoCode: String, scriptCode: String): Region? {
        val languageAndScriptEntry = likelySubtags["$languageIsoCode-$scriptCode"]

        return languageAndScriptEntry?.let {
            val parts = it.split('-')

            regionFor(parts[2])
        }
    }

    fun getDefaultRegionForAllLanguagesAndRegions(): Map<Pair<Language, Region>, Script> {
        val languageToRegion = likelySubtags.filter { it.key.startsWith("und-") == false && it.key.split('-').let { it.size == 2 && isLanguageCode(it[0]) && isRegionCode(it[1]) } }
            .mapNotNull {
                val (languageCode, regionCode) = it.key.split('-')

                languageForOrNull(languageCode)?.let {
                        language -> language to regionFor(regionCode)
                }
            }

        return languageToRegion.associateWith { getDefaultRegionForLanguageAndRegion(it.first, it.second)!! }
    }

    fun getDefaultRegionForLanguageAndRegion(language: Language, region: Region) =
        getDefaultRegionForLanguageAndRegion(language.isoCode, region.code)

    fun getDefaultRegionForLanguageAndRegion(languageIsoCode: String, regionCode: String): Script? {
        val languageAndRegionEntry = likelySubtags["$languageIsoCode-$regionCode"]

        return languageAndRegionEntry?.let {
            val parts = it.split('-')

            scriptFor(parts[1])
        }
    }


    fun getDefaultLanguageForAllRegionsAndScripts(): Map<Pair<Region, Script>, Language?> {
        val regionsToScript = likelySubtags.filter { it.key.startsWith("und-") && it.key.split('-').size == 3 }
            .mapNotNull {
                val (_, scriptCode, regionCode) = it.key.split('-')
                if (isScriptCode(scriptCode) && isRegionCode(regionCode)) {
                    regionFor(regionCode) to scriptFor(scriptCode)
                } else {
                    null
                }
            }

        return regionsToScript.associateWith { getDefaultLanguageForRegionAndScript(it.first, it.second) }
    }

    fun getDefaultLanguageForRegionAndScript(region: Region, script: Script) =
        getDefaultLanguageForRegionAndScript(region.code, script.code)

    fun getDefaultLanguageForRegionAndScript(regionCode: String, scriptCode: String): Language? {
        val regionAndScriptEntry = likelySubtags["und-$scriptCode-$regionCode"]

        return regionAndScriptEntry?.let {
            val parts = it.split('-')

            // there are much more languages than we have in our Language enum
            languageForOrNull(parts.first())
        }
    }


    private fun isLanguageCode(code: String) =
        code.length in 2..3 && code.all { it.isLowerCase() }

    private fun isRegionCode(code: String) =
        (code.length == 2 && code.all { it.isUpperCase() }) ||
                (code.length == 3 && code.all { it.isDigit() })

    private fun isScriptCode(code: String) =
        code.length == 4 && code.first().isUpperCase() && code.drop(1).all { it.isLowerCase() }


    private fun languageForOrNull(languageCode: String): Language? =
        Language.entries.firstOrNull { languageCode == it.isoCode }

    private fun languageFor(languageCode: String) =
        languageForOrNull(languageCode)!!

    private fun regionFor(regionCode: String): Region =
        Region.entries.first { regionCode == it.code }

    private fun scriptFor(scriptCode: String): Script =
        Script.entries.first { scriptCode == it.code }

}