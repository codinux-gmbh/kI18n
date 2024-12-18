package net.codinux.i18n

import assertk.assertThat
import assertk.assertions.hasSize
import kotlin.test.Test

class ParentLocalesTest {

    @Test
    fun getParentLocales() {
        val result = ParentLocales.parentLocales

        assertThat(result).hasSize(182) // tests asserts that all language tags are parsed correctly by LangaugeTag.parse()
    }

}