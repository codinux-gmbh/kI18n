package net.codinux.i18n.format

import assertk.assertThat
import assertk.assertions.isEqualTo
import net.codinux.i18n.Currency
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.formatter.NumberFormats
import net.codinux.i18n.formatter.NumberFormatter
import kotlin.test.Test

class NumberFormatterTest {

    private val underTest = NumberFormatter()


    @Test
    fun roundCorrectlyUp() {
        val result = underTest.formatNumber(8856.7365, NumberFormats.USA)

        assertThat(result).isEqualTo("8,856.737")
    }

    @Test
    fun currency_SymbolNotSet_FallsBackToSymbolVariant() {
        // IcelandKrona is no symbol but symbolVariant set
        val result = underTest.formatCurrency(5.0, Currency.IcelandKrona, LanguageTag.ofAvailable("is"))

        assertThat(result).isEqualTo("5, kr") // TODO: , without fraction is wrong
    }

}