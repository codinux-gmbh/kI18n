package net.codinux.i18n.datetime

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class DateTimeFormatterTest {

    companion object {
        private val Date = LocalDate(2015, 10, 21)

        private val Date1DigitMonthAndDay = LocalDate(2017, 8, 6)

        private val StartOfDay = LocalTime.StartOfDay
        private val Noon = LocalTime.Noon
        private val EndOfDay = LocalTime.EndOfDay
    }


    private val underTest = DateTimeFormatter()


    @Test
    fun date_IsoDate() {
        val result = underTest.formatDate(Date, DateTimeFormat.IsoDatePattern)

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


    @Test
    fun time_hour_12Hour_OneBased_StartOfDay() {
        val result = underTest.formatTime(StartOfDay, "h")

        assertThat(result).isEqualTo("12")
    }

    @Test
    fun time_hour_12Hour_OneBased_Noon() {
        val result = underTest.formatTime(Noon, "h")

        assertThat(result).isEqualTo("12")
    }

    @Test
    fun time_hour_12Hour_OneBased_EndOfDay() {
        val result = underTest.formatTime(EndOfDay, "h")

        assertThat(result).isEqualTo("11")
    }

    @Test
    fun time_hour_24Hour_ZeroBased_StartOfDay() {
        val result = underTest.formatTime(StartOfDay, "H")

        assertThat(result).isEqualTo("0")
    }

    @Test
    fun time_hour_24Hour_ZeroBased_Noon() {
        val result = underTest.formatTime(Noon, "H")

        assertThat(result).isEqualTo("12")
    }

    @Test
    fun time_hour_24Hour_ZeroBased_EndOfDay() {
        val result = underTest.formatTime(EndOfDay, "H")

        assertThat(result).isEqualTo("23")
    }

    @Test
    fun time_hour_12Hour_ZeroBased_StartOfDay() {
        val result = underTest.formatTime(StartOfDay, "K")

        assertThat(result).isEqualTo("0")
    }

    @Test
    fun time_hour_12Hour_ZeroBased_Noon() {
        val result = underTest.formatTime(Noon, "K")

        assertThat(result).isEqualTo("0")
    }

    @Test
    fun time_hour_12Hour_ZeroBased_EndOfDay() {
        val result = underTest.formatTime(EndOfDay, "K")

        assertThat(result).isEqualTo("11")
    }

    @Test
    fun time_hour_24Hour_OneBased_StartOfDay() {
        val result = underTest.formatTime(StartOfDay, "k")

        assertThat(result).isEqualTo("24")
    }

    @Test
    fun time_hour_24Hour_OneBased_Noon() {
        val result = underTest.formatTime(Noon, "k")

        assertThat(result).isEqualTo("12")
    }

    @Test
    fun time_hour_24Hour_OneBased_EndOfDay() {
        val result = underTest.formatTime(EndOfDay, "k")

        assertThat(result).isEqualTo("23")
    }


    @Test
    fun time_isoLocalTime() {
        val result = underTest.formatTime(EndOfDay, DateTimeFormat.IsoLocalTimePattern)

        assertThat(result).isEqualTo("23:59:59.999999999")
    }

}