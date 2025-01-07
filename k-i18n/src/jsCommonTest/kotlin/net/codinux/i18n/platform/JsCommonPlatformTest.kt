package net.codinux.i18n.platform

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class JsCommonPlatformTest {

    @Test
    fun acceptLanguageAndLocaleLanguageDiffer() {
        val result = JsCommonPlatform.getLanguageTagForAcceptLanguageAndLocaleString("de", "en-DE")

        assertThat(result).isEqualTo("de-DE")
    }

    @Test
    fun acceptLanguageAlreadyContainsRegion() {
        val result = JsCommonPlatform.getLanguageTagForAcceptLanguageAndLocaleString("es-AR", "es-ES")

        assertThat(result).isEqualTo("es-AR")
    }

}