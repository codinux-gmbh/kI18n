package net.codinux.i18n.formatter

import assertk.assertThat
import assertk.assertions.isEqualTo
import java.text.DecimalFormat
import java.util.Locale
import kotlin.random.Random
import kotlin.test.Test

class CompareNumberFormatterWithJvmNumberFormatterTest {

    private val underTest = NumberFormatter()


    @Test
    fun integer() {
        val numberFormat = NumberFormats.Germany
        val jvmNumberFormat = DecimalFormat.getIntegerInstance(Locale.GERMANY)

        repeat((0..1_000_000).count()) {
            val number = Random.nextInt(1_000_000_000)

            assertThat(underTest.formatNumber(number, numberFormat)).isEqualTo(jvmNumberFormat.format(number))
        }
    }

    @Test
    fun decimal() {
        val numberFormat = NumberFormats.Germany
        val jvmNumberFormat = DecimalFormat.getNumberInstance(Locale.GERMANY)

        repeat((0..1_000_000).count()) {
            val number = Random.nextDouble(10_000_000.9999)

            assertThat(underTest.formatNumber(number, numberFormat), "$number").isEqualTo(jvmNumberFormat.format(number))
        }
    }

}