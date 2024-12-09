package net.codinux.i18n

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import kotlin.test.Test

class LanguageTagTest {

    @Test
    fun fromTag_TwoLetterLanguageCode() {
        val result = LanguageTag.fromTag("sw")

        assertThat(result.tag).isEqualTo("sw")
        assertThat(result.language).isEqualTo("sw")
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

    @Test
    fun fromTag_ThreeLetterLanguageCode() {
        val result = LanguageTag.fromTag("arn")

        assertThat(result.tag).isEqualTo("arn")
        assertThat(result.language).isEqualTo("arn")
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }


    @Test
    fun fromTag_LanguageAndRegion() {
        val result = LanguageTag.fromTag("ar-AE")

        assertThat(result.tag).isEqualTo("ar-AE")
        assertThat(result.language).isEqualTo("ar")
        assertThat(result.region).isEqualTo("AE")
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }


    @Test
    fun fromTag_LanguageAndScript() {
        val result = LanguageTag.fromTag("ff-Adlm")

        assertThat(result.tag).isEqualTo("ff-Adlm")
        assertThat(result.language).isEqualTo("ff")
        assertThat(result.region).isNull()
        assertThat(result.script).isEqualTo("Adlm")
        assertThat(result.variant).isNull()
    }

    @Test
    fun fromTag_LanguageScriptAndRegion() {
        val result = LanguageTag.fromTag("ha-Arab-SD")

        assertThat(result.tag).isEqualTo("ha-Arab-SD")
        assertThat(result.language).isEqualTo("ha")
        assertThat(result.region).isEqualTo("SD")
        assertThat(result.script).isEqualTo("Arab")
        assertThat(result.variant).isNull()
    }


    @Test
    fun fromTag_LanguageAndVariant() {
        val result = LanguageTag.fromTag("be-tarask")

        assertThat(result.tag).isEqualTo("be-tarask")
        assertThat(result.language).isEqualTo("be")
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isEqualTo("tarask")
    }

    @Test
    fun fromTag_LanguageRegionAndVariant() {
        val result = LanguageTag.fromTag("ca-ES-valencia")

        assertThat(result.tag).isEqualTo("ca-ES-valencia")
        assertThat(result.language).isEqualTo("ca")
        assertThat(result.region).isEqualTo("ES")
        assertThat(result.script).isNull()
        assertThat(result.variant).isEqualTo("valencia")
    }

}