package net.codinux.i18n.datetime

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEmpty
import assertk.assertions.isNotNull
import net.codinux.i18n.LanguageTag
import kotlin.test.Test

class LocalizedDateTimeFormatsResolverTest {

    private val underTest = LocalizedDateTimeFormatsResolver()


    @Test
    fun resolvesFormatsDefinedBySubtagCorrectly() {
        val result = underTest.getDateTimeFormatsForLocale(LanguageTag.parse("af-NA"))

        assertThat(result).isNotNull()

        // there has been a bug that formats of a subtag, here the time, got resolved wrong, so assert this has been fixed
        assertThat(result!!.timeFormats.full).isEqualTo("h:mm:ss a zzzz")
    }

    @Test
    fun resolvesFormatsDefinedByParentCorrectly() {
        val result = underTest.getDateTimeFormatsForLocale(LanguageTag.parse("az-Arab-IQ"))

        assertThat(result).isNotNull()

        // there has been a bug that format of the parent got resolved wrong, so assert this has been fixed
        assertThat(result!!.dateFormats.full).isEqualTo("y MMMM d, EEEE")
    }


    @Test
    fun retrieveAllLocalizedDateTimeFormats() {
        val locales = LanguageTag.availableLanguageTags

        val formatsByLocale = locales.associateWith { underTest.getDateTimeFormatsForLocale(it) }

        for ((locale, formats) in formatsByLocale) {
            assertThat(formats).isNotNull()

            assertFormats(formats?.dateFormats)
            assertFormats(formats?.timeFormats)
            assertFormats(formats?.dateTimeFormats)
        }
    }

    private fun assertFormats(formats: DateOrTimeFormats?) {
        assertThat(formats).isNotNull()

        assertThat(formats!!.full).isNotEmpty()
        assertThat(formats.long).isNotEmpty()
        assertThat(formats.medium).isNotEmpty()
        assertThat(formats.short).isNotEmpty()
    }

}