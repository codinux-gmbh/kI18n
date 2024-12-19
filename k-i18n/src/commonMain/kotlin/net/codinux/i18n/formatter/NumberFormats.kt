package net.codinux.i18n.formatter

import net.codinux.i18n.NumberingSystem

object NumberFormats {

    val SymbolsUSA = Symbols(".", ",", ";", "%", "+", "-", "~", "E", "×", "‰", "∞", "NaN", ":")

    val SymbolsGermany = Symbols(",", ".", ";", "%", "+", "-", "≈", "E", "·", "‰", "∞", "NaN", ":")

    val USA = NumberFormat(
        NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to SymbolsUSA),
        mapOf(NumberingSystem.WesternDigits to DecimalFormat("#,##0.###")), mapOf(NumberingSystem.WesternDigits to DecimalFormat("#,##0%")),
        mapOf(NumberingSystem.WesternDigits to DecimalFormat("#E0")),
        mapOf(NumberingSystem.WesternDigits to CurrencyFormat("¤#,##0.00", "#,##0.00", "¤ #,##0.00", "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤", unitPatternCountOne = "{0} {1}", unitPatternCountOther = "{0} {1}")) // TODO: i left away currencySpacing
    )

    val Germany = NumberFormat(
        NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to SymbolsGermany),
        mapOf(NumberingSystem.WesternDigits to DecimalFormat("#,##0.###")), mapOf(NumberingSystem.WesternDigits to DecimalFormat("#,##0 %")),
        mapOf(NumberingSystem.WesternDigits to DecimalFormat("#E0")),
        mapOf(NumberingSystem.WesternDigits to CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤", "#,##0.00", null, "{0} ¤¤", unitPatternCountOther = "{0} {1}")) // TODO: i left away currencySpacing
    )

}