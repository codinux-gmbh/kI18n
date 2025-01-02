package net.codinux.i18n.parser

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.treeToValue
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.NumberingSystemType
import net.codinux.i18n.datetime.DayOfWeek
import net.codinux.i18n.datetime.HourStyle
import net.codinux.i18n.datetime.PreferredWeekData
import net.codinux.i18n.model.*
import net.codinux.i18n.model.UnitDisplayNames
import net.codinux.i18n.service.FileSystemUtil
import java.io.File
import java.nio.file.Path

/**
 * CLDR types:
 * - ca: Calendar
 * - cf: Currency Format style
 * - co: Collation type
 * - cu: Currency type
 * - dx: Dictionary break script exclusions
 * - em: Emoji presentation style
 * - fw: First day of week
 * - hc: Hour cycle
 * - lb: Line break style
 * - lw: Line break word handling
 * - ms: Measurement system
 * - mu: Measurement unit override
 * - nu: Numbering system
 * - rg: Region override
 * - sd: Regional subdivision
 * - ss: Sentence break suppressions
 * - tz: Time zone
 * - va: Common variant type
 */
open class CldrJsonParser(
    protected open val cldrJsonBaseDir: Path = FileSystemUtil.determineCldrJsonBasePath(),
    protected open val objectMapper: ObjectMapper = ObjectMapper().apply {
        findAndRegisterModules()
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }
) {

    fun parseAvailableLocales(): List<LanguageTag> =
        parseAvailableLocalesAsString().map { LanguageTag.parse(it) }

    fun parseAvailableLocalesAsString(): List<String> =
        objectMapper.readValue<AvailableLocalesSerialModel>(resolvePath("cldr-core/availableLocales.json")).let {
            it.availableLocales.full + it.availableLocales.modern
        }

    /**
     * There are three locales that end with a region code for a geographical region:
     * - en-001 (English-World)
     * - en-150 (English-Europe)
     * - es-419 (Spanish-South America)
     */
    fun parseParentLocales(): Map<String, String> =
        objectMapper.readValue<ParentLocalesFile>(resolvePath("cldr-core//supplemental/parentLocales.json"))
            .supplemental.parentLocales.parentLocale

    fun parseLikelySubtags(): Map<String, String> =
        objectMapper.readValue<LikelySubtagsFile>(resolvePath("cldr-core//supplemental/likelySubtags.json")).let {
            it.supplemental.likelySubtags
        }

    fun parseCoverageLevels(): CoverageLevels =
        objectMapper.readValue<CoverageLevels>(resolvePath("cldr-core/coverageLevels.json"))


    fun getLocalesWithLocalizedLanguageNames(): List<String> =
        getLocales(resolvePath("cldr-localenames-full/main"), "languages.json")

    fun parseLanguageNamesForLocale(locale: LanguageTag): List<LanguageDisplayNames> =
        objectMapper.readValue<LanguagesLocaleNamesFile>(resolvePathForLocale("cldr-localenames-full/main", locale, "languages.json")).let {
            assertLocalSpecificFileStart(it, locale)

            val content = it.main.localeSpecificProperties.values.first()
            content.localeDisplayNames.languages.map { (languageIsoCode, displayName) ->
                LanguageDisplayNames(languageIsoCode, displayName)
            }
        }

    fun getLocalesWithLocalizedLocaleDisplayNamesNames(): List<String> =
        getLocales(resolvePath("cldr-localenames-full/main"), "localeDisplayNames.json")


    fun parseLocaleDisplayNamesForLocale(languageTag: LanguageTag): LocaleDisplayNames =
        objectMapper.readValue<LocaleDisplayNamesFile>(resolvePathForLocale("cldr-localenames-full/main", languageTag, "localeDisplayNames.json")).let {
            require(it.main.size == 1) {
                "There must be exactly one entry in main Map with key '${languageTag.tag}' (or one of its parent LanguageTags)."
            }

            val displayNames = it.main.values.first().localeDisplayNames

            LocaleDisplayNames(displayNames.types.numbers, displayNames.types.currencyFormatStyle, displayNames.types.calendar,
                displayNames.localeDisplayPattern, displayNames.subdivisions, displayNames.keys, displayNames.codePatterns,
                displayNames.types.measurementSystem, displayNames.types.measurementUnitOverride)
        }


    /**
     * Be aware, CodeMappings contains mappings for Regions AND for Currencies on the same level (who came to that idea?).
     * The user therefore has to filter the keys if the are two-letter Region- or three letter Currency codes.
     *
     * "The code mapping information provides mappings between the subtags used in the CLDR locale IDs (from BCP 47) and
     * other coding systems or related information. The language codes are only provided for those codes that have two
     * letters in BCP 47 to their ISO three-letter equivalents. The territory codes provide mappings to numeric (UN M.49
     * [UNM49] codes, equivalent to ISO numeric codes), ISO three-letter codes, FIPS 10 codes, and the internet top-level
     * domain codes.
     *
     * Where there is no corresponding code, sometimes private use codes are used, such as the numeric code for XK.
     *
     * The currencyCodes are mappings from three letter currency codes to numeric values (ISO 4217, see Current currency
     * & funds code list). The mapping currently covers only current codes and does not include historic currencies."
     *
     * The languageCodes information seems to be out of date, i haven't found any language code in current version.
     * But yes, three-letter codes are for currencies
     */
    fun parseCodeMappings(): Map<String, CodeMappingSerialModel> =
        objectMapper.readValue<CodeMappingsFile>(resolveSupplementalPath("codeMappings.json")).supplemental.codeMappings

    /**
     * There's only one alpha2 ISO code in [parseTerritoryInfo] that [parseRegionCodeMappings] does not return, "CQ" for
     * "Island of Sark", see [net.codinux.i18n.model.ExceptionalRegionIsoCodes].
     */
    fun parseRegionCodeMappings(): List<Region> =
        parseCodeMappings().let { codeMappings ->
            // two letter codes are for regions, three letter codes for currencies
            val twoLetterRegionCodes = codeMappings.filter { it.key.length == 2 }

            val saintHelena = codeMappings["SH"]

            twoLetterRegionCodes.map { (isoCode, properties) ->
                // Ascension Island (AC) and Tristan da Cunha (TA) have the same region code as Saint Helena (according to Wikipedia: https://en.wikipedia.org/wiki/ISO_3166-1_numeric), but it isn't set in CLDR
                // other regions without numeric code: Clipperton Island (CP), Diego Garcia (DG), Ceuta & Melilla (EA) and Canary Islands (IC)
                val numericCode = if (isoCode == "AC" || isoCode == "TA") saintHelena?.numeric else properties.numeric
                Region(isoCode, properties.alpha3, numericCode)
            }
        }

    fun parseAvailableRegions(): List<Region> {
        val codeMappings = parseRegionCodeMappings()
        val regionCodesInCodeMappings = codeMappings.map { it.code }

        val territoryContainment = parseTerritoryContainment()
        val regionCodesInTerritoryContainment = territoryContainment.entries
            .flatMap { it.value.contains + it.key }.toSet()
            .filter { it.contains("-status-") == false }

        // the problem is neither regionCodeMappings nor territoryContainment contain all region codes.
        // regionCodeMappings misses regions with only numeric codes like "World", "WesternAfrica", ...;
        // territoryContainment not the user assigned codes AA, QM to QZ, XA to XZ, and ZZ, which CLDR uses anyway and
        // would result in an error in some cases if not available
        val codesNotInCodeMappings = regionCodesInTerritoryContainment.filter { it !in regionCodesInCodeMappings }
        val regionsNotInCodeMappings = codesNotInCodeMappings.map { code ->
            val alpha2Code = code.takeIf { it.length == 2 }
            val alpha3Code = code.takeIf { it.length == 3 && it.all { it.isUpperCase() } }
            val numericCode = code.takeIf { it.length == 3 && it.all { it.isDigit() } }
            Region(alpha2Code, alpha3Code, numericCode?.toInt())
        }

        return regionsNotInCodeMappings + codeMappings
    }

    fun parseTerritoryInfo(): List<TerritoryInfo> =
        objectMapper.readValue<TerritoriesInfoFile>(resolveSupplementalPath("territoryInfo.json")).let {
            it.supplemental.territoryInfo.map { (isoCode, info) ->
                TerritoryInfo(isoCode, info.gdp, info.literacyPercent, info.population, info.languagePopulation.map { (lang, population) ->
                    LanguagePopulation(lang, population.populationPercent, population.officialStatus, population.writingPercent)
                })
            }
        }

    fun parseTerritoryContainment(): Map<String, TerritoryContainment> =
        objectMapper.readValue<TerritoryContainmentFile>(resolveSupplementalPath("territoryContainment.json")).let {
            it.supplemental.territoryContainment
        }

    fun getLocalesWithLocalizedRegionNames(): List<String> =
        getLocales(resolvePath("cldr-localenames-full/main"), "territories.json")

    fun parseRegionNamesForLocale(locale: LanguageTag): List<TerritoryDisplayNames> =
        objectMapper.readValue<TerritoriesLocaleNamesFile>(resolvePathForLocale("cldr-localenames-full/main", locale, "territories.json")).let {
            assertLocalSpecificFileStart(it, locale)

            val territories = it.main.localeSpecificProperties.values.first().localeDisplayNames.territories
            val alternativeNames = territories.filter { it.key.contains("-alt-") }

            territories.filterNot { it.key.contains("-alt-") }.map { (territoryCode, displayName) ->
                TerritoryDisplayNames(territoryCode, displayName, alternativeNames[territoryCode + "-alt-short"], alternativeNames[territoryCode + "-alt-variant"])
            }
        }


    fun parseAvailableScripts(): Set<String> =
        parseScriptsMetadata().keys

    fun parseScriptsMetadata(): Map<String, ScriptMetadata> =
        objectMapper.readValue<ScriptMetadataFile>(resolvePath("cldr-core/scriptMetadata.json")).scriptMetadata

    fun getLocalesWithLocalizedScriptDisplayNames(): List<String> =
        getLocales(resolvePath("cldr-localenames-full/main"), "scripts.json")

    fun parseScriptDisplayNamesForLocale(locale: LanguageTag): List<ScriptDisplayName> =
        objectMapper.readValue<ScriptLocaleNamesFile>(resolvePathForLocale("cldr-localenames-full/main", locale, "scripts.json")).let {
            assertLocalSpecificFileStart(it, locale)

            val scripts = it.main.localeSpecificProperties.values.first().localeDisplayNames.scripts
            val alternativeNames = scripts.filter { it.key.contains("-alt-") }

            scripts.filterNot { it.key.contains("-alt-") }.map { (scriptCode, displayName) ->
                ScriptDisplayName(scriptCode, displayName, alternativeNames[scriptCode + "-alt-short"], alternativeNames[scriptCode + "-alt-variant"], alternativeNames[scriptCode + "-alt-stand-alone"])
            }
        }


    fun getLocalesWithLocalizedVariantDisplayNames(): List<String> =
        getLocales(resolvePath("cldr-localenames-full/main"), "variants.json")

    fun parseVariantDisplayNamesForLocale(locale: LanguageTag): List<VariantDisplayName> =
        objectMapper.readValue<VariantLocaleNamesFile>(resolvePathForLocale("cldr-localenames-full/main", locale, "variants.json")).let {
            assertLocalSpecificFileStart(it, locale)

            val variants = it.main.localeSpecificProperties.values.first().localeDisplayNames.variants

            variants.map { (scriptCode, displayName) ->
                VariantDisplayName(scriptCode, displayName)
            }
        }


    fun parseNumberingSystems(): List<NumberingSystem> =
        objectMapper.readValue<NumberingSystemsFile>(resolveSupplementalPath("numberingSystems.json"))
            .supplemental.numberingSystems.map { (code, numberingSystem) ->
                val type = NumberingSystemType.valueOf(numberingSystem.type.replaceFirstChar { it.uppercase() })
                NumberingSystem(code, type, numberingSystem.digits, numberingSystem.rules)
            }


    fun getLocalesWithLocalizedNumberFormats(): List<String> =
        getLocales(resolvePath("cldr-numbers-full/main"), "numbers.json")

    fun parseNumberFormatsForLocale(languageTag: LanguageTag): NumberFormats =
        objectMapper.readValue<NumberFormatsFile>(resolvePathForLocale("cldr-numbers-full/main", languageTag, "numbers.json")).let {
            require(it.main.size == 1) {
                "There must be exactly one entry in main Map with key '${languageTag.tag}' (or one of its parent LanguageTags)."
            }

            mapNumberFormats(it.main.values.first().numbers)
        }

    private fun mapNumberFormats(numbers: NumberFormatsFileNumbers): NumberFormats {
        val symbols = mapNumbersFormatMap<Symbols>(numbers, "symbols")

        val decimalFormats = mapNumbersFormatMap<DecimalFormat>(numbers, "decimalFormats")
        val scientificFormats = mapNumbersFormatMap<DecimalFormat>(numbers, "scientificFormats")
        val percentFormats = mapNumbersFormatMap<DecimalFormat>(numbers, "percentFormats")
        val currencyFormats = mapNumbersFormatMap<CurrencyFormat>(numbers, "currencyFormats")

        val miscPatterns = mapNumbersFormatMap<MiscPatterns>(numbers, "miscPatterns")

        return NumberFormats(numbers.defaultNumberingSystem, numbers.defaultNumberingSystemAltLatn, numbers.otherNumberingSystems, numbers.minimumGroupingDigits,
            symbols, decimalFormats, scientificFormats, percentFormats, currencyFormats,
            miscPatterns, numbers.minimalPairs)
    }

    private inline fun <reified T> mapNumbersFormatMap(numbers: NumberFormatsFileNumbers, name: String): Map<net.codinux.i18n.NumberingSystem, T> =
        numbers.otherProperties.filter { it.key.startsWith("$name-") }.map { (key, node) ->
            val numberingSystemCode = key.substringAfter("$name-numberSystem-")
            net.codinux.i18n.NumberingSystem.forCode(numberingSystemCode) to objectMapper.treeToValue<T>(node)
        }.toMap()


    fun parseAvailableCurrencies(): List<AvailableCurrency> =
        objectMapper.readValue<AvailableCurrenciesSerialModel>(resolvePath("cldr-bcp47/bcp47/currency.json")).let {
            it.keyword.u.cu.currencyInfos.map { (name, properties) ->
                AvailableCurrency(name.uppercase(), properties.description) // here the ISO alpha3 code is in lowercase -> make uppercase to make conform with standard
            }
        }

    fun parseCurrencyNumericCodes(): Map<String, Int> =
        parseCodeMappings().let { codeMappings ->
            // two-letter codes are for regions, three-letter codes for currencies
            val threeLetterCurrencyCodes = codeMappings.filter { it.key.length == 3 }

            threeLetterCurrencyCodes.mapValues { it.value.numeric!! } // numeric code is a mandatory field for currency codes
        }

    fun getLocalesWithLocalizedCurrencies(): List<String> =
        getLocales(resolvePath("cldr-numbers-full/main"), "currencies.json")

    fun parseCurrenciesForLocale(locale: LanguageTag): List<Currency> =
        objectMapper.readValue<LanguageCurrenciesSerialModel>(resolvePathForLocale("cldr-numbers-full/main", locale, "currencies.json")).let {
            assertLocalSpecificFileStart(it, locale)

            val inner = it.main.localeSpecificProperties.values.first()
            inner.numbers.currencies.currencies.map { (isoCode, properties) ->
                Currency(isoCode, properties.displayName, properties.pattern, properties.symbol, properties.narrowSymbol, properties.formalSymbol, properties.symbolVariant,
                    properties.decimal, properties.group, properties.displayNameCountZero, properties.displayNameCountOne, properties.displayNameCountTwo,
                    properties.displayNameCountFew, properties.displayNameCountMany, properties.displayNameCountOther)
            }
        }


    fun parseUnitsMetadata(): UnitsMetadata =
        objectMapper.readValue<UnitsFile>(resolveSupplementalPath("units.json")).supplemental.let { units ->
            UnitsMetadata(
                // keys (Namen) werden zwischen Type und Unit namen gehaengt, z. B. length-meter & centi -> length-centimeter
                units.unitPrefixes.map { UnitPrefix(it.key, it.value.symbol, it.value.power10, it.value.power2) },
                units.unitConstants.map { UnitConstant(it.key, it.value.value, it.value.description, it.value.status == "approximate") },
                units.unitQuantities.map { UnitQuantity(it.key, it.value.quantity, it.value.status == "simple") },
                units.convertUnits.map { ConvertUnit(it.key, it.value.baseUnit, it.value.factor, it.value.systems, it.value.description, it.value.offset, it.value.special) }
            )
        }

    fun getLocalesWithLocalizedUnits(): List<String> =
        getLocales(resolvePath("cldr-units-full/main"), "units.json")

    fun parseUnitNamesForLocale(locale: LanguageTag) =
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

    fun getLocalesWithLocalizedDateTimeFormats(): List<String> =
        getLocales(resolvePath("cldr-dates-full/main"), "ca-gregorian.json")

    // TODO: may also parse dateFields.json, it contains translations like for day, week, month, year, quarter, week day, yesterday, hour, minute, second, time zone, ..

    fun parseDateTimeFormatsForLocale(language: LanguageTag): DateAndTimeFormats =
        objectMapper.readValue<DateFormatsFile>(resolvePathForLocale("cldr-dates-full/main", language, "ca-gregorian.json")).let {
            require(it.main.size == 1) {
                "There must be exactly one entry in ca-gregorian.json main Map with key '${language.tag}' (or one of its parent LanguageTags)."
            }

            val calendars = it.main.values.first().dates.calendars
            require(calendars.size == 1) {
                "There must be exactly one entry calendar entry in ca-gregorian.json main Map with key '${language.tag}' (or one of its parent LanguageTags)."
            }

            val formats = calendars.values.first()

            DateAndTimeFormats(formats.months, formats.days, formats.quarters, formats.dayPeriods, formats.eras,
                map(formats.dateFormats), map(formats.dateSkeletons), map(formats.timeFormats), map(formats.timeSkeletons),
                formats.dateTimeFormats, formats.dateTimeFormatsAtTime
            )
        }

    private fun map(formats: DateOrTimeFormatsSerialModel) = DateOrTimeFormats(
        formats.full, formats.long, formats.medium, mapShort(formats.short),
        formats.fullAscii, formats.longAscii, formats.mediumAscii, formats.shortAscii,
        formats.fullVariant, formats.longVariant, formats.mediumVariant, formats.shortVariant
    )

    private fun mapShort(short: JsonNode): String =
        if (short.isTextual) {
            short.textValue()
        } else {
            // hilarious, there's one ca-gregorian.json file (locale: haw), that does not set short to a string but to an object:
            // { "_value":"", "_number":"" }
            // i decided to ignore the different numbers
            short.get("_value").textValue()
        }

    open fun parseTimeData(): List<PreferredHourStyle> =
        objectMapper.readValue<TimeDataFile>(resolveSupplementalPath("timeData.json")).supplemental.timeData.let {
            it.map { (regionCode, timeData) ->
                // Also note that the regions allows either region codes (001, JP) or locale IDs (gu_IN).
                val isRegion = regionCode.substring(0, 2).all { it.isUpperCase() } || regionCode.substring(0, 2).all { it.isDigit() }
                val locale = if (isRegion) "und-$regionCode" else regionCode

                // encountered values: h, H, hB, hb, K
                val preferred = HourStyle.entries.first { it.fieldSymbol == timeData.preferred }
                val allowed = timeData.allowed.split(' ').map { hourStyle -> HourStyle.entries.first { it.fieldSymbol == hourStyle } }

                PreferredHourStyle(LanguageTag.parse(locale), preferred, allowed)
            }
        }

    open fun parseWeekData(): PreferredWeekData =
        objectMapper.readValue<WeekDataFile>(resolveSupplementalPath("weekData.json")).supplemental.weekData.let {
            PreferredWeekData(mapKeyToRegion(it.minDays), mapKeyToRegion(it.firstDay).mapValues { dayFor(it.value) },
                mapKeyToRegion(it.weekendStart).mapValues { dayFor(it.value) }, mapKeyToRegion(it.weekendEnd).mapValues { dayFor(it.value) },
                it.weekOfPreference.mapKeys { LanguageTag.parse(it.key) }
            )
        }

    private fun dayFor(weekDataDay: String): DayOfWeek = when (weekDataDay) {
        "mon" -> DayOfWeek.Monday
        "tue" -> DayOfWeek.Tuesday
        "wed" -> DayOfWeek.Wednesday
        "thu" -> DayOfWeek.Thursday
        "fri" -> DayOfWeek.Friday
        "sat" -> DayOfWeek.Saturday
        "sun" -> DayOfWeek.Sunday
        else -> throw IllegalArgumentException("Illegal value of '$weekDataDay' encountered for day of week in weekData.json")
    }

    private fun <T> mapKeyToRegion(map: Map<String, T>): Map<net.codinux.i18n.Region, T> =
        map.filter { it.key.contains("-alt-") == false }.mapKeys { regionFor(it.key) }


    protected open fun assertLocalSpecificFileStart(localeSpecificFile: LocaleSpecificFileHeader<*>, languageTag: LanguageTag) {
        require(localeSpecificFile.main.localeSpecificProperties.size == 1) {
            "There must be exactly one entry in localeSpecificProperties Map with key '${languageTag.tag}' (or one of its parent LanguageTags)."
        }

        val key = localeSpecificFile.main.localeSpecificProperties.keys.first()
        require(languageTag.tag.startsWith(key, true)) {
            "Key of localeSpecificProperties '${key}' should be contained at start of LanguageTag '${languageTag.tag}'."
        }
    }


    private fun languageFor(languageCode: String): net.codinux.i18n.Language =
        net.codinux.i18n.Language.entries.firstOrNull { it.isoCode == languageCode }
            ?: throw IllegalArgumentException("No Language found with ISO code '$languageCode'")

    private fun regionFor(regionCode: String): net.codinux.i18n.Region =
        net.codinux.i18n.Region.entries.firstOrNull { it.code == regionCode || it.numericCodeAsString == regionCode }
            ?: throw IllegalArgumentException("No Region found with code '$regionCode'")


    protected open fun getLocales(directoryWithLocalizedFiles: File, hasToContainFile: String? = null): List<String> =
        directoryWithLocalizedFiles.listFiles().orEmpty().filter { it.isDirectory }
            .filter { hasToContainFile == null || it.list().orEmpty().contains(hasToContainFile) }
            .map { it.name } // TODO: add sanity test if it's really a LanguageTag
            .sorted()

    protected open fun resolvePathForLocale(subPath: String, locale: LanguageTag, filename: String): File =
        resolvePathForLocale(subPath, locale).resolve(filename).toFile()

    protected open fun resolvePathForLocale(subPath: String, locale: LanguageTag): Path {
        val baseDirectory = resolvePath(subPath)
        val fullPath = baseDirectory.resolve(locale.tag)
        if (fullPath.exists()) {
            return fullPath.toPath()
        }

        var parentLanguageTag = locale.tag
        while (parentLanguageTag.contains('-')) {
            val index = parentLanguageTag.lastIndexOf('-')
            val removedTag = parentLanguageTag.substring(index + 1)
            if (removedTag.length == 4 && removedTag[0].isUpperCase() && removedTag.drop(1).all { it.isLowerCase() }) {
                break // it's a script tag -> don't go on to parent locale as we cannot know locale's default language, may it's different from the script denoted by <removedTag>
            }

            parentLanguageTag = parentLanguageTag.substring(0, index)

            val path = baseDirectory.resolve(parentLanguageTag)
            if (path.exists()) {
                return path.toPath()
            }
        }

        throw IllegalArgumentException("Cannot find directory for LanguageTag '${locale.tag} in '${baseDirectory.absolutePath}")
    }

    protected open fun resolveSupplementalPath(filename: String): File =
        resolvePath("cldr-core/supplemental/$filename")

    protected open fun resolvePath(subPath: String): File =
        cldrJsonBaseDir.resolve("cldr-json").resolve(subPath).toFile()

}