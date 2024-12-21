package net.codinux.i18n.datetime

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEmpty
import assertk.assertions.isNotNull
import net.codinux.i18n.LanguageTag
import kotlin.test.Test

class DateTimeDisplayNamesResolverTest {

    private val underTest = DateTimeDisplayNamesResolver()


    @Test
    fun ast_Standalone_Months() {
        val result = underTest.getLocalizedStandaloneDisplayNames(LanguageTag.ofAvailable("ast"))

        assertThat(result).isNotNull()
        assertThat(result!!.months.wide.january).isEqualTo("xineru")
    }


    @Test
    fun retrieveAllDateTimeFormatDisplayNames() {
        val locales = LanguageTag.availableLanguageTags

        val displayNamesByLocale = locales.associateWith { underTest.getLocalizedFormatDisplayNames(it) }

        for ((locale, displayNames) in displayNamesByLocale) {
            assertThat(displayNames).isNotNull()

            assertThat(displayNames!!.months.wide.january).isNotEmpty()
            assertThat(displayNames.days.wide.sunday).isNotEmpty()
            assertThat(displayNames.quarters.wide.third).isNotEmpty()
            assertThat(displayNames.dayPeriods.wide.am).isNotEmpty()
            assertThat(displayNames.dayPeriods.wide.pm).isNotEmpty()
        }
    }

    @Test
    fun retrieveAllDateTimeStandaloneDisplayNames() {
        val locales = LanguageTag.availableLanguageTags

        val displayNamesByLocale = locales.associateWith { underTest.getLocalizedStandaloneDisplayNames(it) }

        for ((locale, displayNames) in displayNamesByLocale) {
            assertThat(displayNames).isNotNull()

            assertThat(displayNames!!.months.narrow.january).isNotEmpty()
            assertThat(displayNames.days.narrow.sunday).isNotEmpty()
            assertThat(displayNames.quarters.narrow.third).isNotEmpty()
            assertThat(displayNames.dayPeriods.narrow.am).isNotEmpty()
            assertThat(displayNames.dayPeriods.narrow.pm).isNotEmpty()
        }
    }

}