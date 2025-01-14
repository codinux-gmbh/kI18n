package net.codinux.i18n.parser

import assertk.assertThat
import assertk.assertions.*
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.Region
import net.codinux.i18n.model.DateAndTimeFormats
import net.codinux.i18n.model.UnitsDisplayNamesForLocale
import org.junit.jupiter.api.assertThrows
import kotlin.test.Ignore
import kotlin.test.Test

class CldrJsonParserTest {

    companion object {
        const val CountAvailableLocales = 725
    }

    private val underTest = CldrJsonParser()


    @Test
    fun parseAvailableLocalesAsString() {
        val result = underTest.parseAvailableLocalesAsString()

        assertThat(result).hasSize(CountAvailableLocales)

        val minLength = 2
        val maxLength = "yue-Hant-CN".length
        assertThat(result.all { it.length in minLength..maxLength || it == "ca-ES-valencia" }).isTrue()
    }

    @Test
    fun parseAvailableLocales() { // a test if all parsed language tags can be mapped to LanguageTag
        val result = underTest.parseAvailableLocales()

        assertThat(result).hasSize(CountAvailableLocales)

        val minLength = 2
        val maxLength = "yue-Hant-CN".length
        assertThat(result.all { it.tag.length in minLength..maxLength || it.tag == "ca-ES-valencia" }).isTrue()
    }

    @Test
    fun parseParentLocales() {
        val result = underTest.parseParentLocales()

        assertThat(result).hasSize(182)
    }

    @Test
    fun parseLikelySubtags() {
        val result = underTest.parseLikelySubtags()

        assertThat(result).hasSize(7738)
    }


    @Test
    fun getLocalesWithLocalizedLocaleDisplayNamesNames() {
        val result = underTest.getLocalesWithLocalizedLocaleDisplayNamesNames()

        assertThat(result).hasSize(CountAvailableLocales)
    }

    @Test
    fun parseLocaleDisplayNamesForLocale() {
        val result = underTest.parseLocaleDisplayNamesForLocale(LanguageTag.English)

        assertThat(result.numberingSystems).hasSize(100)
    }

    @Test
    fun parseAllLocaleDisplayNamesForLocale() {
        val locales = underTest.getLocalesWithLocalizedLocaleDisplayNamesNames().map { LanguageTag.ofAvailable(it) }

        val localeDisplayNamesByLocale = locales.associateWith {
            underTest.parseLocaleDisplayNamesForLocale(it)
        }

        // all values seem to be optional, so i cannot check if any value is set on all LocaleDisplayNames
    }


    @Test
    fun parseNumberingSystems() {
        val result = underTest.parseNumberingSystems()

        assertThat(result).hasSize(96)
    }

    @Test
    fun getLocalesWithLocalizedNumberFormats() {
        val result = underTest.getLocalesWithLocalizedNumberFormats()

        assertThat(result).hasSize(CountAvailableLocales)
    }

    @Test
    fun parseNumberFormatsForLocale() {
        val result = underTest.parseNumberFormatsForLocale(LanguageTag.German)

        assertThat(result.decimalFormats).isNotEmpty()
    }

    @Test
    fun parseAllNumberFormats() {
        val locales = underTest.getLocalesWithLocalizedNumberFormats().map { LanguageTag.ofAvailable(it) }

        val numberFormatsByLocale = locales.associateWith {
            underTest.parseNumberFormatsForLocale(it)
        }

        numberFormatsByLocale.forEach { (locale, numbers) ->
            assertThat(numbers.otherNumberingSystems).isNotEmpty()
        }
    }


    @Test
    fun parseAvailableCurrencies() {
        val result = underTest.parseAvailableCurrencies()

        assertThat(result).hasSize(307)

        assertThat(result.all { it.isoCode.length == 3 }).isTrue()
        assertThat(result.all { it.englishName.length >= 4 }).isTrue() // Euro and Gold are the currencies with the shortest names
    }

    @Test
    fun parseCurrenciesForLocale_en() {
        val result = underTest.parseCurrenciesForLocale(LanguageTag.English)

        assertThat(result).hasSize(307)

        val withoutDisplayName = result.filter { it.displayName == null }
        assertThat(withoutDisplayName).isEmpty()
    }

    @Test
    fun `parseCurrenciesForLocale_de-DE - Resolves parent Locale`() {
        val result = underTest.parseCurrenciesForLocale(LanguageTag.parse("de-DE"))

        assertThat(result).hasSize(304)

        val withoutDisplayName = result.filter { it.displayName == null }
        assertThat(withoutDisplayName).hasSize(1)
    }

    @Test
    fun `parseCurrenciesForLocale_az-Arab-TR`() {
        val result = underTest.parseCurrenciesForLocale(LanguageTag.ofAvailable("az-Arab-TR"))

        assertThat(result).hasSize(106)
    }

    @Test
    fun `parseCurrenciesForLocale_ca-ES-valencia`() {
        val result = underTest.parseCurrenciesForLocale(LanguageTag.ofAvailable("ca-ES-valencia"))

        assertThat(result).hasSize(301)

        val withoutDisplayName = result.filter { it.displayName == null }
        assertThat(withoutDisplayName).hasSize(2)
    }

    @Test
    fun getLocalesWithLocalizedCurrencies() {
        val result = underTest.getLocalesWithLocalizedCurrencies()

        val availableLocales = underTest.parseAvailableLocalesAsString()
        assertThat(result).hasSize(availableLocales.size)
        assertThat(result).containsExactlyInAnyOrder(*availableLocales.toTypedArray())
    }

    @Test
    fun parseAllCurrenciesForLocale() {
        val locales = underTest.parseAvailableLocales()

        for (locale in locales) {
            val result = underTest.parseCurrenciesForLocale(locale)

            assertThat(result.size).isGreaterThan(100)
        }
    }


    @Test
    fun parseRegionCodeMappings() {
        val result = underTest.parseRegionCodeMappings()

        assertThat(result).hasSize(309)

        val alpha2Codes = result.mapNotNull { it.alpha2Code }
        assertThat(alpha2Codes.all { it.length == 2 && it.all { it.isLetter() && it.isUpperCase() } }).isTrue()

        val alpha3Codes = result.mapNotNull { it.alpha3Code }
        assertThat(alpha3Codes.all { it.length == 3 && it.all { it.isLetter() && it.isUpperCase() } }).isTrue()

        val numericCodes = result.mapNotNull { it.numeric }
        assertThat(numericCodes.all { it in 1..999 }).isTrue()

        // assert that numeric codes are set for Ascension Island and Tristan da Cunha
        val ascensionIsland = result.first { it.alpha2Code == "AC" }
        assertThat(ascensionIsland.numeric).isEqualTo(654)
        val tristanDaCunha = result.first { it.alpha2Code == "TA" }
        assertThat(tristanDaCunha.numeric).isEqualTo(654)
    }

    @Test
    fun parseAvailableRegions() {
        val result = underTest.parseAvailableRegions()

        assertThat(result).hasSize(343) // 309 in CodeMappings, additional 34 from TerritoryContainment
    }

    @Test
    fun parseTerritoryInfo() {
        val result = underTest.parseTerritoryInfo()

        assertThat(result).hasSize(258)
    }

    @Test
    fun parseTerritoryContainment() {
        val result = underTest.parseTerritoryContainment()

        assertThat(result).hasSize(46)

        val un = result[Region.UnitedNations.code]
        assertThat(un).isNotNull()
        assertThat(un!!.contains).hasSize(193)
        assertThat(un.grouping).isTrue()

        val eu = result[Region.EuropeanUnion.code]
        assertThat(eu).isNotNull()
        assertThat(eu!!.contains).hasSize(27)
        assertThat(eu.grouping).isTrue()
    }

    @Test
    fun parseLanguageNamesForLocale() {
        val result = underTest.parseLanguageNamesForLocale(LanguageTag.English)

        assertThat(result).hasSize(685)
    }

    @Test
    fun getLocalesWithLocalizedLanguageNames() {
        val result = underTest.getLocalesWithLocalizedLanguageNames()

        val availableLocales = underTest.parseAvailableLocalesAsString()
        val availableLocalesWithLocalizedLanguageNames = availableLocales.filter { it !in net.codinux.i18n.model.LanguageTag.LanguageTagsWithoutLocalizedLanguageNames }
        assertThat(result).hasSize(availableLocalesWithLocalizedLanguageNames.size)
        assertThat(result).containsExactlyInAnyOrder(*availableLocalesWithLocalizedLanguageNames.toTypedArray())
    }

    @Test
    fun parseAllLanguageNamesForLocale() {
        val locales = underTest.getLocalesWithLocalizedLanguageNames().map { LanguageTag.ofAvailable(it) }

        for (locale in locales) {
            val result = underTest.parseLanguageNamesForLocale(locale)

//            assertThat(result.languages).hasSize(685)
            assertThat(result).isNotEmpty() // TODO: there are a lot of locales that don't have translations for all 685 languages - add sanity check
        }
    }

    @Test
    fun parseRegionNamesForLocale() {
        val result = underTest.parseRegionNamesForLocale(LanguageTag.English)

        assertThat(result).hasSize(295)
    }

    @Test
    fun getLocalesWithLocalizedRegionNames() {
        val result = underTest.getLocalesWithLocalizedRegionNames()

        val availableLocales = underTest.parseAvailableLocalesAsString()
        val availableLocalesWithLocalizedRegionNames = availableLocales.filter { it !in net.codinux.i18n.model.LanguageTag.LanguageTagsWithoutLocalizedRegionNames }
        assertThat(result).hasSize(availableLocalesWithLocalizedRegionNames.size)
        assertThat(result).containsExactlyInAnyOrder(*availableLocalesWithLocalizedRegionNames.toTypedArray())
    }

    @Test
    fun parseAllRegionNamesForLocale() {
        val locales = underTest.getLocalesWithLocalizedRegionNames().map { LanguageTag.ofAvailable(it) }

        for (locale in locales) {
            val result = underTest.parseRegionNamesForLocale(locale)

//            assertThat(territories.territories).hasSize(315)
            assertThat(result).isNotEmpty() // TODO: there are a lot of locales that don't have translations for all 315 regions - add sanity check
        }
    }


    @Test
    fun parseAvailableScripts() {
        val result = underTest.parseAvailableScripts()

        assertThat(result).hasSize(177)
        assertThat(result).containsAtLeast("Latn", "Arab", "Hans", "Hebr", "Cyrl")
    }

    @Test
    fun parseScriptsMetadata() {
        val result = underTest.parseScriptsMetadata()

        assertThat(result).hasSize(177)
    }

    @Test
    fun parseScriptDisplayNamesForLocale() {
        val result = underTest.parseScriptDisplayNamesForLocale(LanguageTag.English)

        assertThat(result).hasSize(209)
    }

    @Test
    fun parseAllScriptDisplayNamesForLocale() {
        val locales = underTest.getLocalesWithLocalizedScriptDisplayNames().map { LanguageTag.ofAvailable(it) }

        val allScriptDisplayNames = locales.map { it to underTest.parseScriptDisplayNamesForLocale(it) }

        for (displayNames in allScriptDisplayNames) {
//            assertThat(displayNames).hasSize(177)
            assertThat(displayNames.second).isNotEmpty() // TODO: there are a lot of locales that don't have translations for all 177 scripts - add sanity check
        }
    }


    @Test
    fun parseVariantDisplayNamesForLocale() {
        val result = underTest.parseVariantDisplayNamesForLocale(LanguageTag.English)

        assertThat(result).hasSize(55)
    }

    @Test
    fun parseAllVariantDisplayNamesForLocale() {
        val locales = underTest.getLocalesWithLocalizedVariantDisplayNames().map { LanguageTag.ofAvailable(it) }

        val allVariantDisplayNames = locales.map { it to underTest.parseVariantDisplayNamesForLocale(it) }

        for (displayNames in allVariantDisplayNames) {
//            assertThat(displayNames).hasSize(55)
            assertThat(displayNames.second).isNotEmpty() // TODO: there are a lot of locales that don't have translations for all 55 variants - add sanity check
        }
    }


    @Test
    fun parseUnitsMetadata() {
        val result = underTest.parseUnitsMetadata()

        assertThat(result.unitPrefixes).hasSize(32)
        assertThat(result.unitConstants).hasSize(19)
        assertThat(result.unitQuantities).hasSize(48)
        assertThat(result.convertUnits).hasSize(155)
    }

    @Test
    fun getLocalesWithLocalizedUnits() {
        val result = underTest.getLocalesWithLocalizedUnits()

        val availableLocales = underTest.parseAvailableLocalesAsString()
        assertThat(result).hasSize(availableLocales.size)
        assertThat(result).containsExactlyInAnyOrder(*availableLocales.toTypedArray())
    }

    @Test
    fun parseUnitNamesForLocale() {
        val result = underTest.parseUnitNamesForLocale(LanguageTag.English)

        assertUnitDisplayNames(result)
    }

    @Test
    fun parseAllUnitNamesForLocale() {
        val locales = underTest.parseAvailableLocales()

        for (locale in locales) {
            val result = underTest.parseUnitNamesForLocale(locale)

            assertUnitDisplayNames(result)
        }
    }


    @Test
    fun languageTagContainsScriptTag_CannotFindParentLanguageTag() {
        assertThrows<IllegalArgumentException> {
            underTest.parseCurrenciesForLocale(LanguageTag.parse("fr-Latn"))
        }
    }


    @Test
    fun parseTimeData() {
        val result = underTest.parseTimeData()

        assertThat(result).hasSize(274)
    }

    @Test
    fun parseWeekData() {
        val result = underTest.parseWeekData()

        assertThat(result.minDays).hasSize(49)
        assertThat(result.firstDay).hasSize(150)
        assertThat(result.weekendStart).hasSize(19)
        assertThat(result.weekendEnd).hasSize(17)
        assertThat(result.weekOfPreference).hasSize(74)
    }

    @Test
    fun getLocalesWithLocalizedDateTimeFormats() {
        val result = underTest.getLocalesWithLocalizedDateTimeFormats()

        assertThat(result).hasSize(CountAvailableLocales)
    }

    @Test
    fun parseDateTimeFormatsForLocale() {
        val result = underTest.parseDateTimeFormatsForLocale(LanguageTag.English)

        assertDateAndTimeFormats(result)
    }

    @Test
    fun parseAllDateTimeFormats() {
        val locales = underTest.getLocalesWithLocalizedDateTimeFormats().map { LanguageTag.ofAvailable(it) }

        val allDateTimeFormats = locales.associateWith { underTest.parseDateTimeFormatsForLocale(it) }

        for (format in allDateTimeFormats) {
            assertDateAndTimeFormats(format.value)
        }
    }

    @Ignore // not a test, just to take a look at all available formats in debugger
    @Test
    fun evaluateDateTimeFormats() {
        val locales = underTest.getLocalesWithLocalizedDateTimeFormats().map { LanguageTag.ofAvailable(it) }

        val parsedFormats = locales.associateWith { underTest.parseDateTimeFormatsForLocale(it) }

        val allDateFormats = parsedFormats.values.map { it.dateFormats }.flatMap { setOf(it.full, it.long, it.medium, it.short, it.fullAscii, it.longAscii, it.mediumAscii, it.shortAscii) }.toSet()
        val allDateSkeletons = parsedFormats.values.map { it.dateSkeletons }.flatMap { setOf(it.full, it.long, it.medium, it.short, it.fullAscii, it.longAscii, it.mediumAscii, it.shortAscii) }.toSet()
        val allTimeFormats = parsedFormats.values.map { it.timeFormats }.flatMap { setOf(it.full, it.long, it.medium, it.short, it.fullAscii, it.longAscii, it.mediumAscii, it.shortAscii) }.toSet()
        val allTimeSkeletons = parsedFormats.values.map { it.timeSkeletons }.flatMap { setOf(it.full, it.long, it.medium, it.short, it.fullAscii, it.longAscii, it.mediumAscii, it.shortAscii) }.toSet()
        val allDateTimeFormats = parsedFormats.values.map { it.dateTimeFormats }.flatMap { setOf(it.full, it.long, it.medium, it.short) }.toSet()
        val allDates = (allDateFormats + allDateSkeletons + allDateTimeFormats).toSet().filterNotNull()
        val allTimes = (allTimeFormats + allTimeSkeletons + allDateTimeFormats).toSet().filterNotNull()
        val all = (allDates + allTimes).toSet()

        val availableFormats = parsedFormats.values.map { it.dateTimeFormats }.flatMap { it.availableFormats.values }.toSet()
        val intervalFormats = parsedFormats.values.map { it.dateTimeFormats }.flatMap { it.intervalFormats.formats.values.flatMap { it.values } }.toSet()
        val allIncludingAvailableFormats = (all + availableFormats + intervalFormats).toSet()

        if (allIncludingAvailableFormats.isNotEmpty()) { } // to be able to set breakpoint here
    }


    private fun assertUnitDisplayNames(unitNames: UnitsDisplayNamesForLocale) {
        val long = unitNames.long
        val short = unitNames.short
        val narrow = unitNames.narrow

        assertThat(long.units.size).isGreaterThan(182)
        assertThat(short.units.size).isGreaterThan(182)
        assertThat(narrow.units.size).isGreaterThan(182)

        assertThat(long.prefixPatterns).hasSize(2)
        assertThat(short.prefixPatterns).hasSize(2)
        assertThat(narrow.prefixPatterns).hasSize(2)

        assertThat(long.compoundPatterns).hasSize(2)
        assertThat(short.compoundPatterns).hasSize(2)
        assertThat(narrow.compoundPatterns).hasSize(2)

        assertThat(long.powerPatterns).hasSize(32)
        assertThat(short.powerPatterns).hasSize(32)
        assertThat(narrow.powerPatterns).hasSize(32)

        assertThat(long.coordinates).isNotNull()
        assertThat(short.coordinates).isNotNull()
        assertThat(narrow.coordinates).isNotNull()
    }

    private fun assertDateAndTimeFormats(formats: DateAndTimeFormats) {
        assertThat(formats.days.format.short).isNotNull()
        assertThat(formats.days.standAlone.short).isNotNull()

        assertThat(formats.dateTimeFormats.appendItems).isNotEmpty()
        assertThat(formats.dateTimeFormats.availableFormats).isNotEmpty()
        assertThat(formats.dateTimeFormats.intervalFormats.formats).isNotEmpty()
    }

}