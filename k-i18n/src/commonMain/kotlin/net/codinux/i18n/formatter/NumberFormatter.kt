package net.codinux.i18n.formatter

import net.codinux.i18n.LanguageTag
import net.codinux.i18n.lastIndexOfOrNull
import kotlin.math.pow
import kotlin.math.round

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

    open fun formatNumber(number: Number, locale: LanguageTag = LanguageTag.current) =
        formatNumber(number, getNumberFormat(locale))

    open fun formatNumber(number: Number, format: NumberFormat) =
        formatNumber(number, format.decimalFormats[format.defaultNumberingSystem]!!, format.symbols[format.defaultNumberingSystem]!!)

    open fun formatNumber(number: Number, format: DecimalFormat, symbols: Symbols): String =
        formatNumber(number, format.standard, symbols)

    // @VisibleForTesting
    internal open fun formatNumber(number: Number, formatPattern: String, symbols: Symbols): String {
        if (number is Double) {
            if (number.isNaN()) return symbols.nan
            if (number.isInfinite()) {
                return if (number > 0) return symbols.infinity
                        else "${symbols.minusSign}${symbols.infinity}"
            }
        } else if (number is Float) {
            if (number.isNaN()) return symbols.nan
            if (number.isInfinite()) {
                return if (number > 0) return symbols.infinity
                else "${symbols.minusSign}${symbols.infinity}"
            }
        }

        val pattern = parsePattern(formatPattern)

        val numberAsString = roundAndConvertToString(number, pattern)

        val integerPart = formatIntegerPart(numberAsString, pattern, symbols)
        val fractionPart = formatFractionPart(numberAsString, pattern, symbols)

        return if (fractionPart.isBlank()) {
            integerPart
        } else {
            "$integerPart${symbols.decimal}$fractionPart"
        }
    }

    protected open fun formatIntegerPart(numberAsString: String, pattern: NumberFormatPattern, symbols: Symbols): String {
        var integerPart = numberAsString.substringBefore('.')

        if (pattern.minimumIntegerDigits > 0) {
            integerPart = integerPart.padStart(pattern.minimumIntegerDigits, '0')
        }

        if (pattern.groupSize > 0) {
            // TODO: this is not very efficient
            integerPart = integerPart.reversed().chunked(pattern.groupSize).reversed().joinToString(symbols.group) { it.reversed() }
        }

        return integerPart
    }

    protected open fun formatFractionPart(numberAsString: String, pattern: NumberFormatPattern, symbols: Symbols): String {
        var fractionPart = numberAsString.substringAfter('.', "")

        if (pattern.minimumFractionDigits > 0) {
            fractionPart = fractionPart.padEnd(pattern.minimumFractionDigits, '0')
        }
        if (pattern.maximumFractionDigits > 0 && fractionPart.length > pattern.maximumFractionDigits) {
            fractionPart = fractionPart.substring(0, pattern.maximumFractionDigits)
        }

        // cut-off zeros at the end (as long as fraction part remains longer than minimumFractionDigits)
        while (fractionPart.endsWith('0') && fractionPart.length > pattern.minimumFractionDigits) {
            fractionPart = fractionPart.substring(0, fractionPart.length - 1)
        }

        return fractionPart
    }


    protected open fun roundAndConvertToString(number: Number, pattern: NumberFormatPattern): String =
        if (number is Float || number is Double) {
            // TODO: get rid of scientific notation like 1.000000066826725E7
            // TODO: convert to BigDecimal and use .toPlainString() for better formatting and to avoid that .toString() may returns scientific notation
            val factor = 10.0.pow(pattern.maximumFractionDigits)
            // seems to be a bug in Java, e.g. 3608856.7365 does not get rounded correctly to 3608856.737, but 3608856.73651 does
            val rounded = round(number.toDouble() * factor) / factor
            rounded.toString()
        } else {
            number.toString()
        }

    protected open fun parsePattern(formatPattern: String): NumberFormatPattern {
        val patternIntegerPart = formatPattern.substringBefore('.')
        val minimumIntegerDigits = patternIntegerPart.count { it == '0' }

        val patternFractionPart = formatPattern.substringAfter('.', "")
        val minimumFractionDigits = patternFractionPart.count { it == '0' }
        val maximumFractionDigits = patternFractionPart.count { it == '0' || it == '#' }

        val indexOfGroupingSeparator = patternIntegerPart.lastIndexOfOrNull(',')
        val groupSize = if (indexOfGroupingSeparator != null) {
            patternIntegerPart.drop(indexOfGroupingSeparator).count { it == '0' || it == '#' }
        } else {
            0
        }

        return NumberFormatPattern(formatPattern, minimumIntegerDigits, minimumFractionDigits, maximumFractionDigits, groupSize)
    }

    protected open fun getNumberFormat(locale: LanguageTag): NumberFormat = when (locale) { // TODO: implement
        LanguageTag.German -> NumberFormats.Germany
        else -> NumberFormats.USA
    }

}