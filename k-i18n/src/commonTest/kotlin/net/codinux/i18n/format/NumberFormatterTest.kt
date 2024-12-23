package net.codinux.i18n.format

import assertk.assertThat
import assertk.assertions.isEqualTo
import net.codinux.i18n.Currency
import net.codinux.i18n.Language
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.formatter.NumberFormats
import net.codinux.i18n.formatter.NumberFormatter
import kotlin.test.Ignore
import kotlin.test.Test

class NumberFormatterTest {

    private val underTest = NumberFormatter()


    @Ignore // fails currently, we have to fix it
    @Test
    fun roundCorrectlyUp() {
        val result = underTest.formatNumber(8856.7365, NumberFormats.USA)

        assertThat(result).isEqualTo("8,856.737")
    }

    @Test
    fun currency_NoFractionalDigits() {
        // IcelandKrona is no symbol but symbolVariant set
        val result = underTest.formatCurrency(100, Currency.Yen, LanguageTag.German) // us a locale that puts currency symbol after fractional digits

        assertThat(result).isEqualTo("100 ¥")
    }

    @Test
    fun currency_SymbolNotSet_FallsBackToSymbolVariant() {
        // IcelandKrona is no symbol but symbolVariant set
        val result = underTest.formatCurrency(5.0, Currency.IcelandKrona, LanguageTag.of(Language.Icelandic))

        assertThat(result).isEqualTo("5 kr")
    }

    @Test
    fun currency_DecimalSeparatorDiffersForCurrency() {
        // decimal separator for currencies ('.') differs from default locale's decimal separator (',')
        val result = underTest.formatCurrency(12_345.67, Currency.SwissFranc, LanguageTag.parse("fr-CH"))

        assertThat(result).isEqualTo("12 345.67 CHF")
    }

    @Test
    fun currency_GroupSeparatorDiffersForCurrency() {
        // group separator for currencies ('.') differs from default locale's decimal separator (' ')
        val result = underTest.formatCurrency(12_345.67, Currency.Euro, LanguageTag.parse("de-AT"))

        assertThat(result).isEqualTo("€ 12.345,67")
    }

}