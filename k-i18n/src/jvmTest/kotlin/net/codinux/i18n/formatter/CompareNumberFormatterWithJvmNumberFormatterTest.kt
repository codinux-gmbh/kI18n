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

        (0..1_000_000).forEach {
            val number = Random.nextInt(10_000_000)

            assertThat(underTest.formatNumber(number, numberFormat)).isEqualTo(jvmNumberFormat.format(number))
        }
    }

}