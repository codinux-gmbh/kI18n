package net.codinux.i18n.parser

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEmpty
import assertk.assertions.isTrue
import net.codinux.i18n.model.LanguageTag
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
        val result = underTest.parseCurrenciesForLocale(LanguageTag("en"))

        assertThat(result).hasSize(307)

        val withoutDisplayName = result.filter { it.displayName == null }
        assertThat(withoutDisplayName).isEmpty()
    }

    @Test
    fun `parseCurrenciesForLocale_de-DE - Resolves parent Locale`() { // TODO: not implemented yet
        val result = underTest.parseCurrenciesForLocale(LanguageTag("de-DE"))

        assertThat(result).hasSize(304)

        val withoutDisplayName = result.filter { it.displayName == null }
        assertThat(withoutDisplayName).hasSize(1)
    }

    @Test
    fun `parseCurrenciesForLocale_az-Arab-TR`() {
        val result = underTest.parseCurrenciesForLocale(LanguageTag("az-Arab-TR"))

        assertThat(result).hasSize(106)
    }

    @Test
    fun `parseCurrenciesForLocale_ca-ES-valencia`() {
        val result = underTest.parseCurrenciesForLocale(LanguageTag("ca-ES-valencia"))

        assertThat(result).hasSize(301)

        val withoutDisplayName = result.filter { it.displayName == null }
        assertThat(withoutDisplayName).hasSize(2)
    }


    @Test
    fun parseAvailableCountryIsoCodes() {
        val result = underTest.parseAvailableCountryIsoCodes()

        assertThat(result).hasSize(258)

        assertThat(result.all { it.length == 2 && it.all { it.isLetter() && it.isUpperCase() } }).isTrue()
    }

    @Test
    fun parseTerritoryInfo() {
        val result = underTest.parseTerritoryInfo()

        assertThat(result).hasSize(258)
    }

    @Test
    fun parseLanguageNamesForLocale() {
        val result = underTest.parseLanguageNamesForLocale(LanguageTag("en"))

        assertThat(result).hasSize(1)

        val territories = result.first()
        assertThat(territories.languages).hasSize(685)
    }

    @Test
    fun parseCountryNamesForLocale() {
        val result = underTest.parseCountryNamesForLocale(LanguageTag("en"))

        assertThat(result).hasSize(1)

        val territories = result.first()
        assertThat(territories.territories).hasSize(315)
    }


    @Test
    fun parseUnities() {
        val result = underTest.parseUnities()

        assertThat(result.unitPrefixes).hasSize(32)
        assertThat(result.unitConstants).hasSize(19)
        assertThat(result.unitQuantities).hasSize(48)
        assertThat(result.convertUnits).hasSize(155)
    }

}