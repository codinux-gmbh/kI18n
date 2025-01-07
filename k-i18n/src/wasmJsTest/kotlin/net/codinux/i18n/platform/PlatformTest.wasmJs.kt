package net.codinux.i18n.platform

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class PlatformTestWasmJs {

    @Test
    fun acceptLanguageAndLocaleLanguageDiffer() {
        val result = Platform.getLanguageTagForAcceptLanguageAndLocaleString("de", "en-DE")

        assertThat(result).isEqualTo("de-DE")
    }

    @Test
    fun acceptLanguageAlreadyContainsRegion() {
        val result = Platform.getLanguageTagForAcceptLanguageAndLocaleString("es-AR", "es-ES")

        assertThat(result).isEqualTo("es-AR")
    }

}