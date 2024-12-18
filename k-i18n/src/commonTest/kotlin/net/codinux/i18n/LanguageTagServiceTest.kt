package net.codinux.i18n

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import assertk.assertions.isTrue
import kotlin.test.Test

class LanguageTagServiceTest {

    private val underTest = LanguageTagService()


    @Test
    fun languageTagsWithoutParent() {
        val withoutParent = LanguageTag.availableLanguageTags.filter { underTest.tryFindParent(it) == null }
            // language only, for these it's obvious that there's no parent (or to be more precise: the root would be their parent)
            .filterNot { it.hasOnlyLanguageCode }

        assertThat(withoutParent).hasSize(31)
    }

    @Test
    fun parentLocalIsRoot_tryFindParentShallReturnNull() {
        val parentLocaleIsRoot = ParentLocales.parentLocales.filter { it.value == LanguageTag.Root }

        val parentLocaleReturnedFromTryFindParent = parentLocaleIsRoot.map { underTest.tryFindParent(LanguageTag.parse(it.key)) }

        assertThat(parentLocaleReturnedFromTryFindParent.all { it == null }).isTrue()
    }


    @Test
    fun findParent_as_Cyrl() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("az-Cyrl"))

        assertThat(result).isNull() // it may not return Language.Azerbaijani as according to ParentLocales az-Cyrl has no parent
    }

    @Test
    fun findParent_bm_Nkoo() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("bm-Nkoo"))

        assertThat(result).isNull() // it may not return Language.Bambara as according to ParentLocales bm-Nkoo has no parent
    }

    @Test
    fun findParent_en_Shaw() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("en-Shaw"))

        assertThat(result).isNull() // it may not return Language.English as according to ParentLocales en-Shaw has no parent
    }

    @Test
    fun findParent_ff_Adlm() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("ff-Adlm"))

        assertThat(result).isNull() // it may not return Language.Fula as according to ParentLocales ff-Adlm has no parent
    }

    @Test
    fun findParent_kxv_Telu() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("kxv-Telu"))

        assertThat(result).isNull() // it may not return Language.Kuvi as according to ParentLocales kxv-Telu has no parent
    }

    @Test
    fun findParent_mni_Mtei() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("mni-Mtei"))

        assertThat(result).isNull() // it may not return Language.Manipuri as according to ParentLocales mni-Mtei has no parent
    }


    // script code equals language's default script

    @Test
    fun findParent_hnj_Hmnp() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("hnj-Hmnp"))

        assertThat(result).isEqualTo(LanguageTag.of(Language.HmongNjua))
    }

    @Test
    fun findParent_rhg_Rohg() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("rhg-Rohg"))

        assertThat(result).isEqualTo(LanguageTag.of(Language.Rohingya))
    }

    @Test
    fun findParent_vai_Vaii() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("vai-Vaii"))

        assertThat(result).isEqualTo(LanguageTag.of(Language.Vai))
    }


    // parent local has a different language:

    @Test
    fun findParent_hi_Latn() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("hi-Latn"))

        assertThat(result).isEqualTo(LanguageTag.ofAvailable("en-IN"))
    }

    @Test
    fun findParent_ht() {
        val result = underTest.tryFindParent(LanguageTag.parse("ht"))

        assertThat(result).isEqualTo(LanguageTag.parse("fr-HT"))
    }

    @Test
    fun findParent_nb() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("nb"))

        assertThat(result).isEqualTo(LanguageTag.ofAvailable("no"))
    }

    @Test
    fun findParent_nn() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("nn"))

        assertThat(result).isEqualTo(LanguageTag.ofAvailable("no"))
    }


    // parent has a different region

    @Test
    fun findParent_en_150() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("en-150"))

        assertThat(result).isEqualTo(LanguageTag.parse("en-001"))
    }

    @Test
    fun findParent_en_SE() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("en-SE"))

        assertThat(result).isEqualTo(LanguageTag.parse("en-150"))
    }

    @Test
    fun findParent_es_UY() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("es-UY"))

        assertThat(result).isEqualTo(LanguageTag.parse("es-419"))
    }

}