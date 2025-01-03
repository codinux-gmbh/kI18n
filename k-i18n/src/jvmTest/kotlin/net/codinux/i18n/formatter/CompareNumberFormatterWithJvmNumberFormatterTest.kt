package net.codinux.i18n.formatter

import assertk.assertThat
import assertk.assertions.isEqualTo
import net.codinux.i18n.Currency
import net.codinux.i18n.LanguageTag
import java.text.DecimalFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale
import kotlin.random.Random
import kotlin.test.Test

class CompareNumberFormatterWithJvmNumberFormatterTest {

    private val underTest = NumberFormatter()


    @Test
    fun integer() {
        val jvmNumberFormat = DecimalFormat.getIntegerInstance(Locale.GERMANY)

        repeat((0..1_000_000).count()) {
            val number = Random.nextInt(1_000_000_000)

            assertThat(underTest.formatNumber(number, LanguageTag.Germany)).isEqualTo(jvmNumberFormat.format(number))
        }
    }

    @Test
    fun negativeInteger() {
        val jvmNumberFormat = DecimalFormat.getIntegerInstance(Locale.GERMANY)

        repeat((0..1_000_000).count()) {
            val number = Random.nextInt(1_000_000_000)

            assertThat(underTest.formatNumber(number, LanguageTag.Germany)).isEqualTo(jvmNumberFormat.format(number))
        }
    }


    @Test
    fun double() {
        val jvmNumberFormat = DecimalFormat.getNumberInstance(Locale.GERMANY)

        repeat((0..1_000_000).count()) {
            val number = Random.nextDouble(10_000_000.9999)

            assertThat(underTest.formatNumber(number, LanguageTag.Germany), "$number").isEqualTo(jvmNumberFormat.format(number))
        }
    }

    @Test
    fun negativeDouble() {
        val jvmNumberFormat = DecimalFormat.getNumberInstance(Locale.GERMANY)

        repeat((0..1_000_000).count()) {
            val number = Random.nextDouble(-10_000_000.9999, 0.0)

            assertThat(underTest.formatNumber(number, LanguageTag.Germany), "$number").isEqualTo(jvmNumberFormat.format(number))
        }
    }


    @Test
    fun percent() {
        val jvmNumberFormat = DecimalFormat.getPercentInstance(Locale.GERMANY)

        repeat((0..1_000_000).count()) {
            val number = Random.nextDouble(0.9999)

            assertThat(underTest.formatPercent(number, LanguageTag.Germany), "$number").isEqualTo(jvmNumberFormat.format(number))
        }
    }

    @Test
    fun negativePercent() {
        val jvmNumberFormat = DecimalFormat.getPercentInstance(Locale.GERMANY)

        repeat((0..1_000_000).count()) {
            val number = Random.nextDouble(0.0, 0.9999)

            assertThat(underTest.formatPercent(number, LanguageTag.Germany), "$number").isEqualTo(jvmNumberFormat.format(number))
        }
    }


    @Test
    fun currency() {
        val jvmNumberFormat = DecimalFormat.getCurrencyInstance(Locale.GERMANY)

        repeat((0..1_000_000).count()) {
            val number = Random.nextDouble(0.9999)

            assertThat(underTest.formatCurrency(number, Currency.Euro, LanguageTag.Germany), "$number").isEqualTo(jvmNumberFormat.format(number))
        }
    }

    @Test
    fun negativeCurrency() {
        val jvmNumberFormat = DecimalFormat.getCurrencyInstance(Locale.GERMANY)

        repeat((0..1_000_000).count()) {
            val number = Random.nextDouble(0.9999)

            assertThat(underTest.formatCurrency(number, Currency.Euro, LanguageTag.Germany), "$number").isEqualTo(jvmNumberFormat.format(number))
        }
    }


    @Test
    fun notANumber() {
        val jvmNumberFormat = DecimalFormat.getNumberInstance(Locale.ROOT)

        assertThat(underTest.formatNumber(Double.NaN)).isEqualTo(jvmNumberFormat.format(Double.NaN))
    }

    @Test
    fun infinity() {
        val jvmNumberFormat = DecimalFormat.getNumberInstance(Locale.ROOT)

        assertThat(underTest.formatNumber(Double.POSITIVE_INFINITY)).isEqualTo(jvmNumberFormat.format(Double.POSITIVE_INFINITY))
    }

    @Test
    fun negativeInfinity() {
        val jvmNumberFormat = DecimalFormat.getNumberInstance(Locale.ROOT)

        assertThat(underTest.formatNumber(Double.NEGATIVE_INFINITY)).isEqualTo(jvmNumberFormat.format(Double.NEGATIVE_INFINITY))
    }

}