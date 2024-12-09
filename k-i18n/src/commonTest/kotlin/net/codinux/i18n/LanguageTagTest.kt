package net.codinux.i18n

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import kotlin.test.Test

class LanguageTagTest {

    @Test
    fun parse_TwoLetterLanguageCode() {
        val result = LanguageTag.parse("sw")

        assertThat(result.tag).isEqualTo("sw")
        assertThat(result.language).isEqualTo("sw")
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

    @Test
    fun parse_ThreeLetterLanguageCode() {
        val result = LanguageTag.parse("arn")

        assertThat(result.tag).isEqualTo("arn")
        assertThat(result.language).isEqualTo("arn")
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }


    @Test
    fun parse_LanguageAndRegion() {
        val result = LanguageTag.parse("ar-AE")

        assertThat(result.tag).isEqualTo("ar-AE")
        assertThat(result.language).isEqualTo("ar")
        assertThat(result.region).isEqualTo("AE")
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }


    @Test
    fun parse_LanguageAndScript() {
        val result = LanguageTag.parse("ff-Adlm")

        assertThat(result.tag).isEqualTo("ff-Adlm")
        assertThat(result.language).isEqualTo("ff")
        assertThat(result.region).isNull()
        assertThat(result.script).isEqualTo("Adlm")
        assertThat(result.variant).isNull()
    }

    @Test
    fun parse_LanguageScriptAndRegion() {
        val result = LanguageTag.parse("ha-Arab-SD")

        assertThat(result.tag).isEqualTo("ha-Arab-SD")
        assertThat(result.language).isEqualTo("ha")
        assertThat(result.region).isEqualTo("SD")
        assertThat(result.script).isEqualTo("Arab")
        assertThat(result.variant).isNull()
    }


    @Test
    fun parse_LanguageAndVariant() {
        val result = LanguageTag.parse("be-tarask")

        assertThat(result.tag).isEqualTo("be-tarask")
        assertThat(result.language).isEqualTo("be")
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isEqualTo("tarask")
    }

    @Test
    fun parse_LanguageRegionAndVariant() {
        val result = LanguageTag.parse("ca-ES-valencia")

        assertThat(result.tag).isEqualTo("ca-ES-valencia")
        assertThat(result.language).isEqualTo("ca")
        assertThat(result.region).isEqualTo("ES")
        assertThat(result.script).isNull()
        assertThat(result.variant).isEqualTo("valencia")
    }

}