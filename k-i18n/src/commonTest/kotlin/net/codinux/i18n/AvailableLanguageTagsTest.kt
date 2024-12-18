package net.codinux.i18n

import assertk.assertThat
import assertk.assertions.hasSize
import kotlin.test.Test

class AvailableLanguageTagsTest {

    @Test
    fun getAvailableLocales() {
        val result = AvailableLanguageTags.availableLanguageTags

        assertThat(result).hasSize(725) // tests asserts that all language tags are parsed correctly by LangaugeTag.parse()
    }

}