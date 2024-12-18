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


    @Test
    fun getDefaultRegionForAllLanguagesAndScripts() {
        val result = underTest.getDefaultRegionForAllLanguagesAndScripts()

        assertThat(result).hasSize(28) // actually 31, but for 3 languageCodes we don't have a Language enum value
    }

    @Test
    fun getDefaultRegionForAllLanguagesAndRegions() {
        val result = underTest.getDefaultRegionForAllLanguagesAndRegions()

        assertThat(result).hasSize(42) // actually 43, but for 1 languageCode we don't have a Language enum value
    }


    @Test
    fun getDefaultLanguageForAllRegionsAndScripts() {
        val result = underTest.getDefaultLanguageForAllRegionsAndScripts()

        assertThat(result).hasSize(102)
    }

}