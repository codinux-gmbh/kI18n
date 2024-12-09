package net.codinux.i18n.parser

import assertk.assertThat
import assertk.assertions.*
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.model.UnitsDisplayNamesForLocale
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class CldrJsonParserTest {

    private val underTest = CldrJsonParser()


    @Test
    fun parseAvailableLocales() {
        val result = underTest.parseAvailableLocales()

        assertThat(result).hasSize(725)

        val minLength = 2
        val maxLength = "yue-Hant-CN".length
        assertThat(result.all { it.tag.length in minLength..maxLength || it.tag == "ca-ES-valencia" }).isTrue()
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
        val result = underTest.parseCurrenciesForLocale(LanguageTag.ofAvailable("en"))

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

        val availableLocales = underTest.parseAvailableLocales().map { it.tag }
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
    fun parseAvailableCountries() {
        val result = underTest.parseAvailableCountries()

        assertThat(result).hasSize(492)

        val alpha2Codes = result.mapNotNull { it.alpha2Code }
        assertThat(alpha2Codes.all { it.length == 2 && it.all { it.isLetter() && it.isUpperCase() } }).isTrue()

        val alpha3Codes = result.mapNotNull { it.alpha3Code }
        assertThat(alpha3Codes.all { it.length == 3 && it.all { it.isLetter() && it.isUpperCase() } }).isTrue()

        val numericCodes = result.mapNotNull { it.numeric }
        assertThat(numericCodes.all { it in 1..999 }).isTrue()
    }

    @Test
    fun parseTerritoryInfo() {
        val result = underTest.parseTerritoryInfo()

        assertThat(result).hasSize(258)
    }

    @Test
    fun parseLanguageNamesForLocale() {
        val result = underTest.parseLanguageNamesForLocale(LanguageTag.ofAvailable("en"))

        assertThat(result.languages).hasSize(685)
    }

    @Test
    fun getLocalesWithLocalizedLanguageNames() {
        val result = underTest.getLocalesWithLocalizedLanguageNames()

        val availableLocales = underTest.parseAvailableLocales().map { it.tag }
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
            assertThat(result.languages).isNotEmpty() // TODO: there are a lot of locales that don't have translations for all 685 languages - add sanity check
        }
    }

    @Test
    fun parseCountryNamesForLocale() {
        val result = underTest.parseCountryNamesForLocale(LanguageTag.ofAvailable("en"))

        assertThat(result).hasSize(315)
    }

    @Test
    fun getLocalesWithLocalizedCountryNames() {
        val result = underTest.getLocalesWithLocalizedCountryNames()

        val availableLocales = underTest.parseAvailableLocales().map { it.tag }
        val availableLocalesWithLocalizedCountryNames = availableLocales.filter { it !in net.codinux.i18n.model.LanguageTag.LanguageTagsWithoutLocalizedCountryNames }
        assertThat(result).hasSize(availableLocalesWithLocalizedCountryNames.size)
        assertThat(result).containsExactlyInAnyOrder(*availableLocalesWithLocalizedCountryNames.toTypedArray())
    }

    @Test
    fun parseAllCountryNamesForLocale() {
        val locales = underTest.getLocalesWithLocalizedCountryNames().map { LanguageTag.ofAvailable(it) }

        for (locale in locales) {
            val result = underTest.parseCountryNamesForLocale(locale)

//            assertThat(territories.territories).hasSize(315)
            assertThat(result).isNotEmpty() // TODO: there are a lot of locales that don't have translations for all 315 countries - add sanity check
        }
    }


    @Test
    fun parseUnities() {
        val result = underTest.parseUnities()

        assertThat(result.unitPrefixes).hasSize(32)
        assertThat(result.unitConstants).hasSize(19)
        assertThat(result.unitQuantities).hasSize(48)
        assertThat(result.convertUnits).hasSize(155)
    }

    @Test
    fun getLocalesWithLocalizedUnits() {
        val result = underTest.getLocalesWithLocalizedUnits()

        val availableLocales = underTest.parseAvailableLocales().map { it.tag }
        assertThat(result).hasSize(availableLocales.size)
        assertThat(result).containsExactlyInAnyOrder(*availableLocales.toTypedArray())
    }

    @Test
    fun parseUnityNamesForLocale() {
        val result = underTest.parseUnityNamesForLocale(LanguageTag.ofAvailable("en"))

        assertUnitDisplayNames(result)
    }

    @Test
    fun parseAllUnityNamesForLocale() {
        val locales = underTest.parseAvailableLocales()

        for (locale in locales) {
            val result = underTest.parseUnityNamesForLocale(locale)

            assertUnitDisplayNames(result)
        }
    }


    @Test
    fun languageTagContainsScriptTag_CannotFindParentLanguageTag() {
        assertThrows<IllegalArgumentException> {
            underTest.parseCurrenciesForLocale(LanguageTag.parse("fr-Latn"))
        }
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

}