package net.codinux.i18n

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
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


    @Test
    fun parent_OnlyLanguageIsSet() {
        val languageTag = LanguageTag.ofAvailable("bal")

        val result = languageTag.parent

        assertThat(result).isNull() // we cannot determine parent LanguageTag then
    }

    @Test
    fun parent_LanguageAndRegionAreSet() {
        val languageTag = LanguageTag.ofAvailable("yrl-CO")

        val result = languageTag.parent

        assertThat(result).isNotNull()
        assertThat(result!!.tag).isEqualTo("yrl")
        assertThat(result.language).isEqualTo("yrl")
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

    @Test
    fun parent_LanguageScriptAndRegionAreSet() {
        val languageTag = LanguageTag.ofAvailable("sr-Cyrl-BA")

        val result = languageTag.parent

        assertThat(result).isNotNull()
        assertThat(result!!.tag).isEqualTo("sr-Cyrl")
        assertThat(result.language).isEqualTo("sr")
        assertThat(result.region).isNull()
        assertThat(result.script).isEqualTo("Cyrl")
        assertThat(result.variant).isNull()
    }

    @Test
    fun parent_LanguageAndVariantAreSet() {
        val languageTag = LanguageTag.ofAvailable("be-tarask")

        val result = languageTag.parent

        assertThat(result).isNotNull()
        assertThat(result!!.tag).isEqualTo("be")
        assertThat(result.language).isEqualTo("be")
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

    @Test
    fun parent_LanguageRegionAndVariantAreSet() {
        val languageTag = LanguageTag.ofAvailable("ca-ES-valencia")

        val result = languageTag.parent

        assertThat(result).isNotNull()
        assertThat(result!!.tag).isEqualTo("ca-ES")
        assertThat(result.language).isEqualTo("ca")
        assertThat(result.region).isEqualTo("ES")
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }


    @Test
    fun english() {
        val result = LanguageTag.English

        assertThat(result.tag).isEqualTo(Language.English)
        assertThat(result.language).isEqualTo(Language.English)
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

    @Test
    fun french() {
        val result = LanguageTag.French

        assertThat(result.tag).isEqualTo(Language.French)
        assertThat(result.language).isEqualTo(Language.French)
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

    @Test
    fun german() {
        val result = LanguageTag.German

        assertThat(result.tag).isEqualTo(Language.German)
        assertThat(result.language).isEqualTo(Language.German)
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

    @Test
    fun italian() {
        val result = LanguageTag.Italian

        assertThat(result.tag).isEqualTo(Language.Italian)
        assertThat(result.language).isEqualTo(Language.Italian)
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

    @Test
    fun japanese() {
        val result = LanguageTag.Japanese

        assertThat(result.tag).isEqualTo(Language.Japanese)
        assertThat(result.language).isEqualTo(Language.Japanese)
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

    @Test
    fun korean() {
        val result = LanguageTag.Korean

        assertThat(result.tag).isEqualTo(Language.Korean)
        assertThat(result.language).isEqualTo(Language.Korean)
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

    @Test
    fun chinese() {
        val result = LanguageTag.Chinese

        assertThat(result.tag).isEqualTo(Language.Chinese)
        assertThat(result.language).isEqualTo(Language.Chinese)
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

    @Test
    fun arabic() {
        val result = LanguageTag.Arabic

        assertThat(result.tag).isEqualTo(Language.Arabic)
        assertThat(result.language).isEqualTo(Language.Arabic)
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

    @Test
    fun russian() {
        val result = LanguageTag.Russian

        assertThat(result.tag).isEqualTo(Language.Russian)
        assertThat(result.language).isEqualTo(Language.Russian)
        assertThat(result.region).isNull()
        assertThat(result.script).isNull()
        assertThat(result.variant).isNull()
    }

}