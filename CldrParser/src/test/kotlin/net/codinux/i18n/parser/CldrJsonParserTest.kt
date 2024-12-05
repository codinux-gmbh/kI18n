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

}