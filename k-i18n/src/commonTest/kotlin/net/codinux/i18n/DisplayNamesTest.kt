package net.codinux.i18n

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import kotlin.test.Test

class DisplayNamesTest {

    private val underTest = DisplayNames()


    @Test
    fun getLanguageDisplayName_ar_BH_ResolvesFromParent() {
        val result = underTest.getLanguageDisplayName("yue", LanguageTag.ofAvailable("ar-BH"))

        assertThat(result).isEqualTo("الكَنْتُونية")
    }

    @Test
    fun getLanguageDisplayName_ca_ES_valencia() {
        val result = underTest.getLanguageDisplayName("crk", LanguageTag.ofAvailable("ca-ES-valencia"))

        assertThat(result).isEqualTo("cree de la plana")
    }

    @Test
    fun getAllLanguageDisplayNamesForLanguage() {
        val result = underTest.getAllLanguageDisplayNamesForLanguage(LanguageTag.ofAvailable("os"))

        assertThat(result).isNotNull()
        assertThat(result!!).hasSize(76)
    }

    @Test
    fun getAllLanguageDisplayNamesForLanguage_ResolveParent() {
        val result = underTest.getAllLanguageDisplayNamesForLanguage(LanguageTag.parse("bgn-IQ"))

        assertThat(result).isNotNull()
        assertThat(result!!).hasSize(399)
    }

    @Test
    fun getAllLanguageDisplayNamesForLanguage_MapIsEmpty_ResolveParent() {
        val result = underTest.getAllLanguageDisplayNamesForLanguage(LanguageTag.parse("bgn-AE"))

        assertThat(result).isNotNull()
        assertThat(result!!).hasSize(399)
    }


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

    @Test
    fun getAllRegionDisplayNamesForLanguage() {
        val result = underTest.getAllRegionDisplayNamesForLanguage(LanguageTag.ofAvailable("dsb"))

        assertThat(result).isNotNull()
        assertThat(result!!).hasSize(294)
    }

    @Test
    fun getAllRegionDisplayNamesForLanguage_ResolveParent() {
        val result = underTest.getAllRegionDisplayNamesForLanguage(LanguageTag.parse("ru-tarask"))

        assertThat(result).isNotNull()
        assertThat(result!!).hasSize(294)
    }


    @Test
    fun getCurrencyDisplayName_ms() {
        val result = underTest.getCurrencyDisplayName("JOD", LanguageTag.ofAvailable("ms"))

        assertThat(result).isEqualTo("Dinar Jordan")
    }

    @Test
    fun getAllCurrencyDisplayNamesForLanguage() {
        val result = underTest.getAllCurrencyDisplayNamesForLanguage(LanguageTag.ofAvailable("is"))

        assertThat(result).isNotNull()
        assertThat(result!!).hasSize(228)
    }

    @Test
    fun getAllCurrencyDisplayNamesForLanguage_ResolveParent() {
        val result = underTest.getAllCurrencyDisplayNamesForLanguage(LanguageTag.parse("ha-HA"))

        assertThat(result).isNotNull()
        assertThat(result!!).hasSize(165)
    }

}