package net.codinux.i18n.parser

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import net.codinux.i18n.model.*
import net.codinux.i18n.model.UnitDisplayNames
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString
import kotlin.io.path.exists

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

            if (index != null) {
                val cldrJsonPath = Path(currentDir.substring(0, index)).parent.resolve("cldr-json")
                if (cldrJsonPath.exists()) {
                    return cldrJsonPath
                }
            }

            throw IllegalStateException("Could not find base directory of '<project_root>/cldr-json' submodule, please specify it explicitly")
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

    fun getLocalesWithLocalizedCurrencies(): List<String> =
        getLocales(resolvePath("cldr-numbers-full/main"), "currencies.json")

    fun parseCurrenciesForLocale(locale: LanguageTag): List<Currency> =
        objectMapper.readValue<LanguageCurrenciesSerialModel>(resolvePathForLocale("cldr-numbers-full/main", locale, "currencies.json")).let {
            assertLocalSpecificFileStart(it, locale)

            val inner = it.main.localeSpecificProperties.values.first()
            inner.numbers.currencies.currencies.map { (isoCode, properties) ->
                Currency(isoCode, properties.displayName, properties.displayNameCountOne, properties.displayNameCountOther, properties.symbol, properties.symbolAltNarrow)
            }
        }


    /**
     * There's only one alpha2 ISO code in [parseTerritoryInfo] that [parseAvailableCountries] does not return, "CQ" for
     * "Island of Sark", see [net.codinux.i18n.model.ExceptionalCountryIsoCodes].
     */
    fun parseAvailableCountries(): List<Country> =
        objectMapper.readValue<CodeMappingsFile>(resolvePath("cldr-core/supplemental/codeMappings.json")).supplemental.codeMappings.map { (isoCode, properties) ->
            val isAlpha2 = isoCode.length == 2
            Country(if (isAlpha2) isoCode else null, if (isAlpha2) properties.alpha3 else isoCode, properties.numeric)
        }

    fun parseTerritoryInfo(): List<TerritoryInfo> =
        objectMapper.readValue<TerritoriesInfoFile>(resolvePath("cldr-core/supplemental/territoryInfo.json")).let {
            it.supplemental.territoryInfo.map { (isoCode, info) ->
                TerritoryInfo(isoCode, info.gdp, info.literacyPercent, info.population, info.languagePopulation.map { (lang, population) ->
                    LanguagePopulation(lang, population.populationPercent, population.officialStatus, population.writingPercent)
                })
            }
        }

    fun getLocalesWithLocalizedLanguageNames(): List<String> =
        getLocales(resolvePath("cldr-localenames-full/main"), "languages.json")

    fun parseLanguageNamesForLocale(locale: LanguageTag): LanguageDisplayNamesForLocale =
        objectMapper.readValue<LanguagesLocaleNamesFile>(resolvePathForLocale("cldr-localenames-full/main", locale, "languages.json")).let {
            assertLocalSpecificFileStart(it, locale)

            val content = it.main.localeSpecificProperties.values.first()
            LanguageDisplayNamesForLocale(content.localeDisplayNames.languages.mapValues { (languageIsoCode, displayName) ->
                LanguageDisplayNames(languageIsoCode, displayName)
            })
        }

    fun getLocalesWithLocalizedCountryNames(): List<String> =
        getLocales(resolvePath("cldr-localenames-full/main"), "territories.json")

    fun parseCountryNamesForLocale(locale: LanguageTag): TerritoryDisplayNamesForLocale =
        objectMapper.readValue<TerritoriesLocaleNamesFile>(resolvePathForLocale("cldr-localenames-full/main", locale, "territories.json")).let {
            assertLocalSpecificFileStart(it, locale)

            val content = it.main.localeSpecificProperties.values.first()
            TerritoryDisplayNamesForLocale(content.localeDisplayNames.territories.mapValues { (territoryIsoCode, displayName) ->
                TerritoryDisplayNames(territoryIsoCode, displayName)
            })
        }


    fun parseUnities(): Unities =
        objectMapper.readValue<UnitiesFile>(resolvePath("cldr-core/supplemental/units.json")).supplemental.let { unities ->
            Unities(
                unities.unitPrefixes.map { UnitPrefix(it.key, it.value.symbol, it.value.power10, it.value.power2) },
                unities.unitConstants.map { UnitConstant(it.key, it.value.value, it.value.description, it.value.status == "approximate") },
                unities.unitQuantities.map { UnityQuantity(it.key, it.value.quantity, it.value.status == "simple") },
                unities.convertUnits.map { ConvertUnit(it.key, it.value.baseUnit, it.value.factor, it.value.systems, it.value.description, it.value.offset, it.value.special) }
            )
        }

    fun getLocalesWithLocalizedUnits(): List<String> =
        getLocales(resolvePath("cldr-units-full/main"), "units.json")

    fun parseUnityNamesForLocale(locale: LanguageTag) =
        objectMapper.readValue<UnitsLocaleNamesFile>(resolvePathForLocale("cldr-units-full/main/", locale, "units.json")).let {
            assertLocalSpecificFileStart(it, locale)

            val content = it.main.localeSpecificProperties.values.first()
            UnitsDisplayNamesForLocale(
                map(content.units.long), map(content.units.short), map(content.units.narrow),
                content.units.durationUnitTypeHm, content.units.durationUnitTypeHms, content.units.durationUnitTypeMs
            )
        }

    protected open fun map(displayNames: UnitsLocaleDisplayNamesSerialModel): UnitsLocaleDisplayNames {
        val units = displayNames.unitPattern.filter { it.value.displayName != null && it.value.south == null }

        val prefixPatterns = displayNames.unitPattern.filter { it.value.unitPrefixPattern != null }
        val powerPatterns = displayNames.unitPattern.filter { it.value.compoundUnitPattern1 != null }
        val compoundPatterns = displayNames.unitPattern.filter { it.value.compoundUnitPattern != null }

        return UnitsLocaleDisplayNames(
            units.map { UnitDisplayNames(it.key, it.value.displayName!!, it.value.unitPatternCountOne, it.value.unitPatternCountOther, it.value.perUnitPattern) },
            powerPatterns.map { UnitPattern(it.key, it.value.compoundUnitPattern1!!, it.value.compoundUnitPattern1CountOne, it.value.compoundUnitPattern1CountOther) },
            prefixPatterns.map { UnitPattern(it.key, it.value.unitPrefixPattern!!) },
            compoundPatterns.map { UnitPattern(it.key, it.value.compoundUnitPattern!!) },
            displayNames.unitPattern["coordinateUnit"]?.let { CoordinatesDisplayNames(it.west!!, it.north!!, it.east!!, it.south!!) }
        )
    }


    protected open fun assertLocalSpecificFileStart(localeSpecificFile: LocaleSpecificFileHeader<*>, languageTag: LanguageTag) {
        require(localeSpecificFile.main.localeSpecificProperties.size == 1) {
            "There must be exactly one entry in localeSpecificProperties Map with key '${languageTag.tag}' (or one of its parent LanguageTags)."
        }

        val key = localeSpecificFile.main.localeSpecificProperties.keys.first()
        require(languageTag.tag.startsWith(key, true)) {
            "Key of localeSpecificProperties '${key}' should be contained at start of LanguageTag '${languageTag.tag}'."
        }
    }


    protected open fun getLocales(directoryWithLocalizedFiles: File, hasToContainFile: String? = null): List<String> =
        directoryWithLocalizedFiles.listFiles().orEmpty().filter { it.isDirectory }
            .filter { hasToContainFile == null || it.list().orEmpty().contains(hasToContainFile) }
            .map { it.name } // TODO: add sanity test if it's really a LanguageTag

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