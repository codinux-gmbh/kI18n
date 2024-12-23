package net.codinux.i18n.formatter

import net.codinux.i18n.Currency
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.lastIndexOfOrNull
import kotlin.math.abs
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
        format(number, format.standard, symbols)


    open fun formatPercent(number: Number, locale: LanguageTag = LanguageTag.current) =
        formatPercent(number, getNumberFormat(locale))

    open fun formatPercent(number: Number, format: NumberFormat) =
        formatPercent(number, format.percentFormats[format.defaultNumberingSystem]!!, format.symbols[format.defaultNumberingSystem]!!)

    open fun formatPercent(number: Number, format: DecimalFormat, symbols: Symbols): String =
        format(number, format.standard, symbols, null, 100)


    open fun formatCurrency(number: Number, currency: Currency, locale: LanguageTag = LanguageTag.current) =
        formatCurrency(number, currency, getNumberFormat(locale))

    open fun formatCurrency(number: Number, currency: Currency, format: NumberFormat) =
        formatCurrency(number, currency, format.currencyFormats[format.defaultNumberingSystem]!!, format.symbols[format.defaultNumberingSystem]!!)

    open fun formatCurrency(number: Number, currency: Currency, format: CurrencyFormat, symbols: Symbols): String {
        // The following additional elements were intended to allow proper placement of the currency symbol relative to the numeric quantity. These are specified in the root locale and typically not overridden in any other locale. However, as of CLDR 42, the preferred approach to controlling placement of the currency symbol is use of the alt="alphaNextToNumber" variant for currencyFormat patterns. See below and - Currencies for additional information on the use of these options.

        // The alt="alphaNextToNumber" pattern, if available, should be used instead of the standard pattern when the currency symbol character closest to the numeric value has Unicode General Category L (letter). The alt="alphaNextToNumber" pattern is typically provided when the standard currency pattern does not have a space between currency symbol and numeric value; the alphaNextToNumber variant adds a non-breaking space if appropriate for the locale.
        //
        // The alt="noCurrency" pattern can be used when a currency-style format is desired but without the currency symbol. This sort of display may be used when formatting a large column of values all in the same currency, for example. For compact currency formats (<currencyFormatLength type="short">), the compact decimal format (<decimalFormatLength type="short">) should be used if no alt="noCurrency" pattern is present (so the alt="noCurrency" pattern is typically not needed for compact currency formats).
        //
        // The currencyPatternAppendISO element provides a pattern that can be used to combine currency format that uses a currency symbol (¤ or ¤¤¤¤¤) with the ISO 4217 3-letter code for the same currency (¤¤), to produce a result such as “$1,432.00 USD”. Using such a format is only recommended to resolve ambiguity when:
        //
        // - The currency symbol being used is the narrow symbol (¤¤¤¤¤) or has the same value as the narrow symbol, and
        // - The currency symbol does not have the same value as the ISO 4217 3-letter code. Most locales will not need to override the pattern provided in root, shown in the xml sample above.

        // In currency formats, the number of digits after the decimal also does not matter, since the information in the supplemental data (see Supplemental Currency Data) is used to override the number of decimal places — and the rounding — according to the currency that is being formatted.
        val formattedNumber = format(number, format.standard, symbols, currency.defaultFractionDigits) // TODO: or use format.accounting ?

        // No.	Replacement / Example
        // ¤	Standard currency symbol
        // C$12.00
        // ¤¤	ISO currency symbol (constant)
        // CAD 12.00
        // ¤¤¤	Appropriate currency display name for the currency, based on the plural rules in effect for the locale
        // 5.00 Canadian dollars
        // ¤¤¤¤¤	Narrow currency symbol. The same symbols may be used for multiple currencies. Thus the symbol may be ambiguous, and should only be where the context is clear.
        // $12.00
        // others	Invalid in current CLDR. Reserved for future specification

        // If data is unavailable for a given sequence in a given locale, the display may fall back to ¤ or ¤¤.
        return if (formattedNumber.contains("¤¤¤¤¤")) {
            formattedNumber.replace("¤¤¤¤¤", currency.symbolVariant ?: currency.symbol ?: currency.alpha3Code)
        }
        // TODO: ¤¤¤	Appropriate currency display name for the currency, based on the plural rules in effect for the locale
        else if (formattedNumber.contains("¤¤")) {
            formattedNumber.replace("¤¤", currency.alpha3Code)
        } else {
            formattedNumber.replaceFirst("¤", currency.symbol ?: currency.symbolVariant ?: currency.alpha3Code).replace("¤", "")
        }
    }


    /**
     * For percent and per mill we have to multiply the number:
     * %: "Multiply by 100 and show as percentage"
     * ‰: "Multiply by 1000 and show as per mille (aka “basis points”)"
     */
    // @VisibleForTesting
    internal open fun format(number: Number, formatPattern: String, symbols: Symbols, countFractionalDigits: Int? = null, multiplyNumberWith: Int? = null): String {
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

        val pattern = parsePattern(formatPattern, countFractionalDigits)

        val numberAsString = roundAndConvertToString(number, pattern, multiplyNumberWith)

        val integerPart = formatIntegerPart(number, numberAsString, pattern, symbols)
        val fractionPart = formatFractionPart(numberAsString, pattern, symbols)

        return if (fractionPart.isBlank()) {
            integerPart
        } else if (fractionPart.none { it.isDigit() }) { // e.g. only contains currency symbol or percent sign but no digits
            "$integerPart$fractionPart"
        } else {
            "$integerPart${symbols.decimal}$fractionPart"
        }
    }

    protected open fun formatIntegerPart(number: Number, numberAsString: String, pattern: NumberFormatPattern, symbols: Symbols): String {
        var integerPart = numberAsString.substringBefore('.')

        if (pattern.minimumIntegerDigits > 0) {
            integerPart = integerPart.padStart(pattern.minimumIntegerDigits, '0')
        }

        if (pattern.groupSize > 0) {
            // TODO: this is not very efficient
            integerPart = integerPart.reversed().chunked(pattern.groupSize).reversed().joinToString(symbols.group) { it.reversed() }
        }

        // TODO: this is not fully correct, there may be a negative pattern in pattern.pattern
        if (number.toLong() < 0) {
            /**
             * A pattern contains a positive subpattern and may contain a negative subpattern, for example, "#,##0.00;(#,##0.00)". Each subpattern has a prefix, a numeric part, and a suffix. If there is no explicit negative subpattern, the implicit negative subpattern is the ASCII minus sign (-) prefixed to the positive subpattern. That is, "0.00" alone is equivalent to "0.00;-0.00". (The data in CLDR is normalized to remove an explicit negative subpattern where it would be identical to the implicit form.)
             *
             * Note that if a negative subpattern is used as-is: a minus sign is not added, eg "0.00;0.00" ≠ "0.00;-0.00". Trailing semicolons are ignored, eg "0.00;" = "0.00". Whitespace is not ignored, including those around semicolons, so "0.00 ; -0.00" ≠ "0.00;-0.00".
             *
             * If there is an explicit negative subpattern, it serves only to specify the negative prefix and suffix; the number of digits, minimal digits, and other characteristics are ignored in the negative subpattern. That means that "#,##0.0#;(#)" has precisely the same result as "#,##0.0#;(#,##0.0#)". However in the CLDR data, the format is normalized so that the other characteristics are preserved, just for readability.
             */
            integerPart = "-$integerPart"
        }

        return "${pattern.stringBeforeIntegerPart}$integerPart${pattern.stringAfterIntegerPart}"
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

        return "${pattern.stringBeforeFractionPart}$fractionPart${pattern.stringAfterFractionPart}"
    }


    protected open fun roundAndConvertToString(number: Number, pattern: NumberFormatPattern, multiplyNumberWith: Int?): String =
        if (number is Float || number is Double) {
            // TODO: get rid of scientific notation like 1.000000066826725E7
            // TODO: convert to BigDecimal and use .toPlainString() for better formatting and to avoid that .toString() may returns scientific notation
            val factor = 10.0.pow(pattern.maximumFractionDigits)
            // seems to be a bug in Java, e.g. 3608856.7365 does not get rounded correctly to 3608856.737, but 3608856.73651 does
            val rounded = round(number.toDouble() * (multiplyNumberWith ?: 1) * factor) / factor
            abs(rounded).toString()
        } else {
            abs(number.toLong() * (multiplyNumberWith ?: 1)).toString()
        }

    protected open fun parsePattern(formatPattern: String, countFractionalDigits: Int?): NumberFormatPattern {
        val patternIntegerPart = formatPattern.substringBefore('.')
        val minimumIntegerDigits = patternIntegerPart.count { it == '0' }
        val integerNumbersStartIndex = patternIntegerPart.indexOfAny(charArrayOf('0', '#'))
        val integerNumberEndIndex = patternIntegerPart.lastIndexOfAny(charArrayOf('0', '#'))
        val stringBeforeIntegerPart = patternIntegerPart.substring(0, integerNumbersStartIndex)
        val stringAfterIntegerPart = patternIntegerPart.substring(integerNumberEndIndex + 1)

        val patternFractionPart = formatPattern.substringAfter('.', "")
        val minimumFractionDigits = countFractionalDigits ?: patternFractionPart.count { it == '0' }
        val maximumFractionDigits = countFractionalDigits ?: patternFractionPart.count { it == '0' || it == '#' }

        val fractionNumbersStartIndex = patternFractionPart.indexOfAny(charArrayOf('0', '#'))
        val fractionNumberEndIndex = patternFractionPart.lastIndexOfAny(charArrayOf('0', '#'))
        val stringBeforeFractionPart = if (fractionNumbersStartIndex == -1) "" else patternFractionPart.substring(0, fractionNumbersStartIndex)
        val stringAfterFractionPart = if (fractionNumberEndIndex == -1) "" else patternFractionPart.substring(fractionNumberEndIndex + 1)

        val indexOfGroupingSeparator = patternIntegerPart.lastIndexOfOrNull(',')
        val groupSize = if (indexOfGroupingSeparator != null) {
            patternIntegerPart.drop(indexOfGroupingSeparator).count { it == '0' || it == '#' }
        } else {
            0
        }

        return NumberFormatPattern(formatPattern, minimumIntegerDigits, minimumFractionDigits, maximumFractionDigits, groupSize,
            stringBeforeIntegerPart, stringAfterIntegerPart, stringBeforeFractionPart, stringAfterFractionPart)
    }

    protected open fun getNumberFormat(locale: LanguageTag): NumberFormat {
        val numberFormat = AvailableNumberFormats.getNumberFormat(locale.tag)
        if (numberFormat != null) {
            return numberFormat
        }

        locale.parent?.let { parent ->
            return getNumberFormat(parent)
        }

        throw IllegalArgumentException("Number format not found for locale '$locale' or its parents. Are you sure this locale exists?")
    }

}