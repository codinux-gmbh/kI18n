package net.codinux.i18n.parser

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import net.codinux.i18n.model.*
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

open class CldrJsonParser(
    protected open val cldrJsonBaseDir: Path = determineDefaultCldrJsonBasePath(),
    protected open val objectMapper: ObjectMapper = ObjectMapper().apply {
        findAndRegisterModules()
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }
) {

    companion object {

        fun determineDefaultCldrJsonBasePath(): Path {
            val currentDir = Path(".").absolutePathString()
            val index = currentDir.indexOf("/src/main/").takeIf { it > 0 }
                ?: currentDir.indexOf("/build/").takeIf { it > 0 }
                ?: currentDir.indexOf("/CldrParser/.").takeIf { it > 0 }?.plus("/CldrParser/".length)

            if (index ==  null) {
                throw IllegalStateException("Could not find base directory of '<project_root>/cldr-json' submodule, please specify it explicitly")
            }

            return Path(currentDir.substring(0, index)).parent.resolve("cldr-json")
        }

    }


    fun parseAvailableLocales(): List<LanguageTag> =
        objectMapper.readValue<AvailableLocalesSerialModel>(resolvePath("cldr-core/availableLocales.json")).let {
            (it.availableLocales.full + it.availableLocales.modern).map {
                LanguageTag(it)
            }
        }

    fun parseAvailableCurrencies(): List<AvailableCurrency> =
        objectMapper.readValue<AvailableCurrenciesSerialModel>(resolvePath("cldr-bcp47/bcp47/currency.json")).let {
            it.keyword.u.cu.currencyInfos.map { (name, properties) ->
                AvailableCurrency(name, properties.description)
            }
        }

    fun parseCurrenciesForLocale(locale: LanguageTag): List<Currency> =
        objectMapper.readValue<LanguageCurrenciesSerialModel>(resolvePathForLocale("cldr-numbers-full/main", locale, "currencies.json")).let {
            it.main.localeSpecificProperties.flatMap { (languageTag, inner) -> // there should actually always only be one node
                inner.numbers.currencies.currencies.map { (isoCode, properties) ->
                    Currency(isoCode, properties.displayName, properties.displayNameCountOne, properties.displayNameCountOther, properties.symbol, properties.symbolAltNarrow)
                }
            }
        }


    fun parseAvailableCountryIsoCodes(): List<String> =
        // TODO: is there any other source for available countries?
        parseTerritoryInfo().map { it.isoCode }

    fun parseTerritoryInfo(): List<TerritoryInfo> =
        objectMapper.readValue<TerritoriesInfoFile>(resolvePath("cldr-core/supplemental/territoryInfo.json")).let {
            it.supplemental.territoryInfo.map { (isoCode, info) ->
                TerritoryInfo(isoCode, info.gdp, info.literacyPercent, info.population, info.languagePopulation.map { (lang, population) ->
                    LanguagePopulation(lang, population.populationPercent, population.officialStatus, population.writingPercent)
                })
            }
        }

    fun parseLanguageNamesForLocale(locale: LanguageTag): List<LanguageDisplayNamesForLocale> =
        objectMapper.readValue<LanguagesLocaleNamesFile>(resolvePathForLocale("cldr-localenames-full/main", locale, "languages.json")).let {
            it.main.localeSpecificProperties.map { (languageTag, content) -> // there should actually always only be one node
                LanguageDisplayNamesForLocale(content.localeDisplayNames.languages.mapValues { (languageIsoCode, displayName) ->
                    LanguageDisplayNames(languageIsoCode, displayName)
                })
            }
        }

    fun parseCountryNamesForLocale(locale: LanguageTag): List<TerritoryDisplayNamesForLocale> =
        objectMapper.readValue<TerritoriesLocaleNamesFile>(resolvePathForLocale("cldr-localenames-full/main", locale, "territories.json")).let {
            it.main.localeSpecificProperties.map { (languageTag, content) -> // there should actually always only be one node
                TerritoryDisplayNamesForLocale(content.localeDisplayNames.territories.mapValues { (territoryIsoCode, displayName) ->
                    TerritoryDisplayNames(territoryIsoCode, displayName)
                })
            }
        }


    protected open fun resolvePathForLocale(subPath: String, locale: LanguageTag, filename: String): File =
        resolvePathForLocale(subPath, locale).resolve(filename).toFile()

    protected open fun resolvePathForLocale(subPath: String, locale: LanguageTag): Path {
        val baseDirectory = resolvePath(subPath)
        val fullPath = baseDirectory.resolve(locale.tag)
        if (fullPath.exists()) {
            return fullPath.toPath()
        }

        // TODO: resolve parent
        throw IllegalArgumentException("")
    }

    protected open fun resolvePath(subPath: String): File =
        cldrJsonBaseDir.resolve("cldr-json").resolve(subPath).toFile()

}