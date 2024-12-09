package net.codinux.i18n.platform

import assertk.assertThat
import assertk.assertions.isGreaterThanOrEqualTo
import assertk.assertions.isNotEmpty
import assertk.assertions.startsWith
import kotlin.test.Test

class PlatformTest {

    @Test
    fun getSystemLocale() {
        val result = Platform.getSystemLocale()

        assertThat(result.tag).isNotEmpty()
        assertThat(result.tag.length).isGreaterThanOrEqualTo(2)
        assertThat(result.tag).startsWith(result.language)
    }

    @Test
    fun getAvailableLocales() {
        val result = Platform.AvailableLocales

        assertThat(result).isNotEmpty()
    }

}