package net.codinux.i18n.formatter

import net.codinux.i18n.LanguageTag
import net.codinux.i18n.lastIndexOfOrNull

/**
 * In whole CLDR data i found three decimalFormats:
 * #,##0.###
 * #,##,##0.###
 * #,#0.###
 *
 * Three scientificFormats:
 * #E0
 * [#E0]
 * #
 *
 * 9 percentFormats:
 * #,##0%
 * #,##,##0%
 * #,##0 %
 * % #,#0;% -#,#0
 * #,##,##0 %
 * % #,##0
 * %#,##0
 * #,##0 %
 * %#,#0
 *
 * And 20 currencyFormats, 23 currencyFormat.accounting, ...
 */
open class NumberFormatter {

    fun formatNumber(number: Number, locale: LanguageTag = LanguageTag.current) =
        formatNumber(number, getNumberFormat(locale))

    fun formatNumber(number: Number, format: NumberFormat) =
        formatNumber(number, format.decimalFormats[format.defaultNumberingSystem]!!, format.symbols[format.defaultNumberingSystem]!!)

    fun formatNumber(number: Number, format: DecimalFormat, symbols: Symbols): String =
        formatNumber(number, format.standard, symbols)

    // @VisibleForTesting
    internal fun formatNumber(number: Number, pattern: String, symbols: Symbols): String {
        val numberAsString = number.toString()
        var integerPart = numberAsString.substringBefore('.')
        val fractionPart = numberAsString.substringAfter('.')

        val patternIntegerPart = pattern.substringBefore('.')
        val minimumIntegerDigits = patternIntegerPart.count { it == '0' }
        if (minimumIntegerDigits > 0) {
            integerPart = integerPart.padStart(minimumIntegerDigits, '0')
        }

        val indexOfGroupingSeparator = patternIntegerPart.lastIndexOfOrNull(',')
        if (indexOfGroupingSeparator != null) {
            val groupSize = patternIntegerPart.drop(indexOfGroupingSeparator).count { it == '0' || it == '#' }
            if (groupSize > 0) {
                integerPart = integerPart.reversed().chunked(groupSize).reversed().joinToString(symbols.group) { it.reversed() }
            }
        }

        return integerPart
    }


    protected open fun getNumberFormat(locale: LanguageTag): NumberFormat = when (locale) { // TODO: implement
        LanguageTag.German -> NumberFormats.Germany
        else -> NumberFormats.USA
    }

}