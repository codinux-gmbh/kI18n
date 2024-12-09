package net.codinux.i18n

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class DisplayNamesTest {

    private val underTest = DisplayNames()


    @Test
    fun getRegionDisplayName_ar_BH_ResolvesFromParent() {
        val result = underTest.getRegionDisplayName("YE", LanguageTag.ofAvailable("ar-BH"))

        assertThat(result).isEqualTo("اليمن")
    }

    @Test
    fun getRegionDisplayName_ca_ES_valencia() {
        val result = underTest.getRegionDisplayName("CF", LanguageTag.ofAvailable("ca-ES-valencia"))

        assertThat(result).isEqualTo("República Centreafricana")
    }

}