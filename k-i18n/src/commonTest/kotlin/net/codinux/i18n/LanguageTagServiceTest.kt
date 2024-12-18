package net.codinux.i18n

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import kotlin.test.Test

class LanguageTagServiceTest {

    private val underTest = LanguageTagService()


    @Test
    fun languageTagsWithoutParent() {
        val withoutParent = LanguageTag.availableLanguageTags.filter { underTest.tryFindParent(it) == null }
            // language only, for these it's obvious that there's no parent (or to be more precise: the root would be their parent)
            .filterNot { it.hasOnlyLanguageCode }

        assertThat(withoutParent).hasSize(32) // TODO: reduce to 0
    }

    @Test
    fun findParent_as_Cyrl() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("az-Cyrl"))

        assertThat(result).isNull() // TODO: find parent
    }

    @Test
    fun findParent_bm_Nkoo() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("bm-Nkoo"))

        assertThat(result).isNull() // TODO: find parent
    }

    @Test
    fun findParent_en_Shaw() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("en-Shaw"))

        assertThat(result).isNull() // TODO: find parent
    }

    @Test
    fun findParent_ff_Adlm() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("ff-Adlm"))

        assertThat(result).isNull() // TODO: find parent
    }

    @Test
    fun findParent_hi_Latn() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("hi-Latn"))

        assertThat(result).isNull() // TODO: find parent
    }

    @Test
    fun findParent_hnj_Hmnp() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("hnj-Hmnp"))

        assertThat(result).isEqualTo(LanguageTag.of(Language.HmongNjua))
    }

    @Test
    fun findParent_kxv_Telu() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("kxv-Telu"))

        assertThat(result).isNull() // TODO: find parent
    }

    @Test
    fun findParent_mni_Mtei() {
        val result = underTest.tryFindParent(LanguageTag.ofAvailable("mni-Mtei"))

        assertThat(result).isNull() // TODO: find parent
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

}