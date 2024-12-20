package net.codinux.i18n.datetime

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class DateTimeFormatterTest {

    companion object {
        private val Date = LocalDate(2015, 10, 21)

        private val Date1DigitMonthAndDay = LocalDate(2017, 8, 6)
    }


    private val underTest = DateTimeFormatter()


    @Test
    fun date_IsoDate() {
        val result = underTest.formatDate(Date, "yyyy-MM-dd")

        assertThat(result).isEqualTo("2015-10-21")
    }

    @Test
    fun date_MediumGermanDate() {
        val result = underTest.formatDate(Date1DigitMonthAndDay, "dd.MM.yyyy")

        assertThat(result).isEqualTo("06.08.2017")
    }

    @Test
    fun date_TwoDigitYear() {
        val result = underTest.formatDate(Date1DigitMonthAndDay, "yy-M-d")

        assertThat(result).isEqualTo("17-8-6")
    }

}