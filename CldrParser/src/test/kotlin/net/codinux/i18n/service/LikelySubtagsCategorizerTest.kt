package net.codinux.i18n.service

import assertk.assertThat
import assertk.assertions.hasSize
import net.codinux.i18n.parser.CldrJsonParser
import kotlin.test.Test

class LikelySubtagsCategorizerTest {

    private val underTest = LikelySubtagsCategorizer(CldrJsonParser())


    @Test
    fun getDefaultScriptAndRegionForAllLanguages() {
        val result = underTest.getDefaultScriptAndRegionForAllLanguages()

        assertThat(result).hasSize(7196)
    }

    @Test
    fun getDefaultLanguageAndScriptForAllRegions() {
        val result = underTest.getDefaultLanguageAndScriptForAllRegions()

        assertThat(result).hasSize(193)
    }

    @Test
    fun getDefaultLanguageAndRegionForAllScripts() {
        val result = underTest.getDefaultLanguageAndRegionForAllScripts()

        assertThat(result).hasSize(172)
    }

}