package net.codinux.i18n.codegenerator

import net.codinux.i18n.LanguageTag
import net.codinux.i18n.NumberingSystem
import net.codinux.i18n.formatter.AvailableNumberFormats
import net.codinux.i18n.formatter.NumberFormat
import net.codinux.i18n.model.CurrencyFormat
import net.codinux.i18n.model.DecimalFormat
import net.codinux.i18n.model.NumberFormats
import net.codinux.i18n.model.Symbols
import net.codinux.i18n.parser.CldrJsonParser

fun main() {
    AvailableNumberFormatsGeneratedClassAsserter().assert()
}

/**
 * It cannot be run directory after [AllLocalizedDateTimeFormatsClassGenerator.generate] as
 * [net.codinux.i18n.datetime.AllLocalizedDateTimeFormats] has to be compiled first. So i extracted this class, which
 * has to be run manually after [AllLocalizedDateTimeFormatsClassGenerator.generate].
 */
class AvailableNumberFormatsGeneratedClassAsserter(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser()
) {

    fun assert() {
        val locales = cldrJsonParser.getLocalesWithLocalizedNumberFormats().map { LanguageTag.ofAvailable(it) }

        val formatsByLocale = locales.associateWith { cldrJsonParser.parseNumberFormatsForLocale(it) }

        assertFormatsHaveBeenWrittenCorrectly(formatsByLocale)

        println("Great work, all number formats have been resolved correctly!")
    }

    private fun assertFormatsHaveBeenWrittenCorrectly(formatsByLocale: Map<LanguageTag, NumberFormats>) {
        formatsByLocale.forEach { (locale, format) ->
            val resolvedFormat = AvailableNumberFormats.getNumberFormat(locale.tag)

            assertFormatsEqual(locale, format, resolvedFormat)
        }
    }

    private fun assertFormatsEqual(locale: LanguageTag, expectedFormat: NumberFormats, resolvedFormat: NumberFormat?) {
        requireNotNull(resolvedFormat) {
            "Could not resolve NumberFormats for locale $locale"
        }

        require(expectedFormat.defaultNumberingSystem == resolvedFormat.defaultNumberingSystem.code) {
            "$locale: Expected NumberingSystem ${expectedFormat.defaultNumberingSystem} does not match actual NumberingSystem ${resolvedFormat.defaultNumberingSystem.code}"
        }
        require(expectedFormat.minimumGroupingDigits == resolvedFormat.minimumGroupingDigits) {
            "$locale: Expected minimumGroupingDigits ${expectedFormat.minimumGroupingDigits} does not match actual minimumGroupingDigits ${resolvedFormat.minimumGroupingDigits}"
        }

        assertSymbols(locale, expectedFormat.symbols, resolvedFormat.symbols)

        assertNumberFormats(locale, expectedFormat.decimalFormats, resolvedFormat.decimalFormats, "decimalFormats")
        assertNumberFormats(locale, expectedFormat.percentFormats, resolvedFormat.percentFormats, "percentFormats")
        assertNumberFormats(locale, expectedFormat.scientificFormats, resolvedFormat.scientificFormats, "scientificFormats")
        assertNumberFormats(locale, expectedFormat.currencyFormats, resolvedFormat.currencyFormats)
    }

    private fun assertNumberFormats(locale: LanguageTag, expectedFormats: Map<NumberingSystem, DecimalFormat>, actualFormats: Map<NumberingSystem, net.codinux.i18n.formatter.DecimalFormat>, type: String) {
        require(expectedFormats.size == actualFormats.size && actualFormats.keys.all { expectedFormats.containsKey(it) }) {
            "$type of $locale do not match: Expected has formats for NumberingSystems ${expectedFormats.keys}, actual for ${actualFormats.keys}"
        }

        expectedFormats.forEach { (numberingSystem, expectedFormat) ->
            val actualFormat = actualFormats[numberingSystem]!!

            require(expectedFormat.standard == actualFormat.standard) {
                "$type pattern for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.standard}', actual format is '${actualFormat.standard}'"
            }
        }
    }

    private fun assertNumberFormats(locale: LanguageTag, expectedFormats: Map<NumberingSystem, CurrencyFormat>, actualFormats: Map<NumberingSystem, net.codinux.i18n.formatter.CurrencyFormat>) {
        require(expectedFormats.size == actualFormats.size && actualFormats.keys.all { expectedFormats.containsKey(it) }) {
            "currencyFormats of $locale do not match: Expected has formats for NumberingSystems ${expectedFormats.keys}, actual for ${actualFormats.keys}"
        }

        expectedFormats.forEach { (numberingSystem, expectedFormat) ->
            val actualFormat = actualFormats[numberingSystem]!!

            require(expectedFormat.standard == actualFormat.standard) {
                "currencyFormat pattern for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.standard}', actual format is '${actualFormat.standard}'"
            }
            require(expectedFormat.standardNoCurrency == actualFormat.standardNoCurrency) {
                "currencyFormat standardNoCurrency for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.standardNoCurrency}', actual format is '${actualFormat.standardNoCurrency}'"
            }
            require(expectedFormat.standardAlphaNextToNumber == actualFormat.standardAlphaNextToNumber) {
                "currencyFormat standardAlphaNextToNumber for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.standardAlphaNextToNumber}', actual format is '${actualFormat.standardAlphaNextToNumber}'"
            }

            require(expectedFormat.accounting == actualFormat.accounting) {
                "currencyFormat accounting for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.accounting}', actual format is '${actualFormat.accounting}'"
            }
            require(expectedFormat.accountingNoCurrency == actualFormat.accountingNoCurrency) {
                "currencyFormat accountingNoCurrency for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.accountingNoCurrency}', actual format is '${actualFormat.accountingNoCurrency}'"
            }
            require(expectedFormat.accountingAlphaNextToNumber == actualFormat.accountingAlphaNextToNumber) {
                "currencyFormat accountingAlphaNextToNumber for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.accountingAlphaNextToNumber}', actual format is '${actualFormat.accountingAlphaNextToNumber}'"
            }

            require(expectedFormat.currencyPatternAppendISO == actualFormat.currencyPatternAppendISO) {
                "currencyFormat currencyPatternAppendISO for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.currencyPatternAppendISO}', actual format is '${actualFormat.currencyPatternAppendISO}'"
            }

//            require(expectedFormat.unitPatternCountZero == actualFormat.unitPatternCountZero) {
//                "currencyFormat unitPatternCountZero for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.unitPatternCountZero}', actual format is '${actualFormat.unitPatternCountZero}'"
//            }
//            require(expectedFormat.unitPatternCountOne == actualFormat.unitPatternCountOne) {
//                "currencyFormat unitPatternCountOne for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.unitPatternCountOne}', actual format is '${actualFormat.unitPatternCountOne}'"
//            }
//            require(expectedFormat.unitPatternCountTwo == actualFormat.unitPatternCountTwo) {
//                "currencyFormat unitPatternCountTwo for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.unitPatternCountTwo}', actual format is '${actualFormat.unitPatternCountTwo}'"
//            }
//            require(expectedFormat.unitPatternCountFew == actualFormat.unitPatternCountFew) {
//                "currencyFormat unitPatternCountFew for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.unitPatternCountFew}', actual format is '${actualFormat.unitPatternCountFew}'"
//            }
//            require(expectedFormat.unitPatternCountMany == actualFormat.unitPatternCountMany) {
//                "currencyFormat unitPatternCountMany for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.unitPatternCountMany}', actual format is '${actualFormat.unitPatternCountMany}'"
//            }
//            require(expectedFormat.unitPatternCountOther == actualFormat.unitPatternCountOther) {
//                "currencyFormat unitPatternCountOther for NumberingSystem $numberingSystem of $locale does not match: Expected format is '${expectedFormat.unitPatternCountOther}', actual format is '${actualFormat.unitPatternCountOther}'"
//            }
        }
    }

    private fun assertSymbols(locale: LanguageTag, expectedSymbols: Map<NumberingSystem, Symbols>, actualSymbols: Map<NumberingSystem, net.codinux.i18n.formatter.Symbols>) {
        require(expectedSymbols.size == actualSymbols.size && actualSymbols.keys.all { expectedSymbols.containsKey(it) }) {
            "Symbols of $locale do not match: Expected has symbols for NumberingSystems ${expectedSymbols.keys}, actual for ${actualSymbols.keys}"
        }

        expectedSymbols.forEach { (numberingSystem, expectedSymbols) ->
            val actualSymbols = actualSymbols[numberingSystem]!!

            require(expectedSymbols.decimal == actualSymbols.decimal) {
                "Symbols.decimal for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.decimal}', actual is '${actualSymbols.decimal}'"
            }
            require(expectedSymbols.group == actualSymbols.group) {
                "Symbols.group for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.group}', actual is '${actualSymbols.group}'"
            }

            require(expectedSymbols.plusSign == actualSymbols.plusSign) {
                "Symbols.plusSign for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.plusSign}', actual is '${actualSymbols.plusSign}'"
            }
            require(expectedSymbols.minusSign == actualSymbols.minusSign) {
                "Symbols.minusSign for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.minusSign}', actual is '${actualSymbols.minusSign}'"
            }

            require(expectedSymbols.infinity == actualSymbols.infinity) {
                "Symbols.infinity for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.infinity}', actual is '${actualSymbols.infinity}'"
            }
            require(expectedSymbols.nan == actualSymbols.nan) {
                "Symbols.nan for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.nan}', actual is '${actualSymbols.nan}'"
            }

            require(expectedSymbols.percentSign == actualSymbols.percentSign) {
                "Symbols.percentSign for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.percentSign}', actual is '${actualSymbols.percentSign}'"
            }
            require(expectedSymbols.perMille == actualSymbols.perMille) {
                "Symbols.perMille for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.perMille}', actual is '${actualSymbols.perMille}'"
            }

            require(expectedSymbols.approximatelySign == actualSymbols.approximatelySign) {
                "Symbols.approximatelySign for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.approximatelySign}', actual is '${actualSymbols.approximatelySign}'"
            }
            require(expectedSymbols.exponential == actualSymbols.exponential) {
                "Symbols.exponential for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.exponential}', actual is '${actualSymbols.exponential}'"
            }
            require(expectedSymbols.superscriptingExponent == actualSymbols.superscriptingExponent) {
                "Symbols.superscriptingExponent for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.superscriptingExponent}', actual is '${actualSymbols.superscriptingExponent}'"
            }
            require(expectedSymbols.list == actualSymbols.list) {
                "Symbols.list for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.list}', actual is '${actualSymbols.list}'"
            }

            require(expectedSymbols.timeSeparator == actualSymbols.timeSeparator) {
                "Symbols.timeSeparator for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.timeSeparator}', actual is '${actualSymbols.timeSeparator}'"
            }
            require(expectedSymbols.timeSeparatorAltVariant == actualSymbols.timeSeparatorVariant) {
                "Symbols.timeSeparatorAltVariant for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.timeSeparatorAltVariant}', actual is '${actualSymbols.timeSeparatorVariant}'"
            }

            require(expectedSymbols.currencyGroup == actualSymbols.currencyGroup) {
                "Symbols.currencyGroup for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.currencyGroup}', actual is '${actualSymbols.currencyGroup}'"
            }
            require(expectedSymbols.currencyDecimal == actualSymbols.currencyDecimal) {
                "Symbols.currencyDecimal for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.currencyDecimal}', actual is '${actualSymbols.currencyDecimal}'"
            }

            require(expectedSymbols.decimalAltUs == actualSymbols.decimalAltUs) {
                "Symbols.decimalAltUs for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.decimalAltUs}', actual is '${actualSymbols.decimalAltUs}'"
            }
            require(expectedSymbols.groupAltUs == actualSymbols.groupAltUs) {
                "Symbols.groupAltUs for NumberingSystem $numberingSystem of $locale does not match: Expected value is '${expectedSymbols.groupAltUs}', actual is '${actualSymbols.groupAltUs}'"
            }
        }
    }
}