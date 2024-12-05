package net.codinux.i18n.parser

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEmpty
import assertk.assertions.isTrue
import kotlin.test.Test

class CldrJsonParserTest {

    private val underTest = CldrJsonParser()


    @Test
    fun parseAvailableLocales() {
        val result = underTest.parseAvailableLocales()

        assertThat(result.availableLocales.modern).isEmpty()
        assertThat(result.availableLocales.full).hasSize(725)

        val minLength = 2
        val maxLength = "yue-Hant-CN".length
        assertThat(result.availableLocales.full.all { it.length in minLength..maxLength || it == "ca-ES-valencia" }).isTrue()
    }

    @Test
    fun parseAvailableCurrencies() {
        val result = underTest.parseAvailableCurrencies()

        assertThat(result).hasSize(307)

        assertThat(result.all { it.isoCode.length == 3 }).isTrue()
        assertThat(result.all { it.englishName.length >= 4 }).isTrue() // Euro and Gold are the currencies with the shortest names
    }

}