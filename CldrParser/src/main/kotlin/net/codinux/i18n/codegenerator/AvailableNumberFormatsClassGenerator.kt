package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import net.codinux.collections.ImmutableMap
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.NumberingSystem
import net.codinux.i18n.formatter.NumberFormat
import net.codinux.i18n.model.*
import net.codinux.i18n.parser.CldrJsonParser

class AvailableNumberFormatsClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    companion object {
        private val currencyFormatType = net.codinux.i18n.formatter.CurrencyFormat::class

        private val symbolsType = net.codinux.i18n.formatter.Symbols::class

        private val numberFormatType = NumberFormat::class
    }


    data class NumberSystemDependentValue<T>(
        val locale: LanguageTag,
        val numberingSystem: NumberingSystem,
        val value: T,
        var assignedId: String = ""
    )


    fun generate() {
        val locales = cldrJsonParser.getLocalesWithLocalizedNumberFormats().map { LanguageTag.ofAvailable(it) }

        val formatsByLocale = locales.associateWith { cldrJsonParser.parseNumberFormatsForLocale(it) }

        val uniqueDecimalFormats = formatsByLocale.entries.flatMap { (locale, format) -> format.decimalFormats.map { NumberSystemDependentValue(locale, it.key, it.value.standard) } }
            .groupBy { it.value }
        val uniquePercentFormats = formatsByLocale.entries.flatMap { (locale, format) -> format.percentFormats.map { NumberSystemDependentValue(locale, it.key, it.value.standard) } }
            .groupBy { it.value }
        val uniqueScientificFormats = formatsByLocale.entries.flatMap { (locale, format) -> format.scientificFormats.map { NumberSystemDependentValue(locale, it.key, it.value.standard) } }
            .groupBy { it.value }
        val uniqueCurrencyFormats = formatsByLocale.entries.flatMap { (locale, format) -> format.currencyFormats.map { NumberSystemDependentValue(locale, it.key, it.value) } }
            .groupBy { it.value }

        val uniqueSymbols = formatsByLocale.entries.flatMap { (locale, format) -> format.symbols.map { NumberSystemDependentValue(locale, it.key, it.value) } }
            .groupBy { it.value }

        val properties = generateFormatProperties(uniqueDecimalFormats, "decimal") + generateFormatProperties(uniquePercentFormats, "percent") +
                generateFormatProperties(uniqueScientificFormats, "scientific") + generateCurrencyFormatProperties(uniqueCurrencyFormats) +
                generateSymbolsProperties(uniqueSymbols) +
                generateNumberFormatsProperties(formatsByLocale, uniqueDecimalFormats, uniquePercentFormats, uniqueScientificFormats, uniqueCurrencyFormats, uniqueSymbols)


        // method to find all date time display names of a LanguageTag
        val getNumberFormatMethods = listOf(generateGetNumberFormatMethod(formatsByLocale, uniqueDecimalFormats,
            uniquePercentFormats, uniqueScientificFormats, uniqueCurrencyFormats, uniqueSymbols))

        util.writeClass("AvailableNumberFormats", properties, subPackage = "formatter", companionObjectMethods = getNumberFormatMethods)
    }


    private fun generateFormatProperties(formats: Map<String, List<NumberSystemDependentValue<String>>>, type: String): List<PropertySpec> = formats.entries.mapIndexed { index, entry ->
        val id = "${type}Format_${(index + 1).toString().padStart(2, '0')}"
        entry.value.onEach { it.assignedId = id }

        PropertySpec.builder(id, currencyFormatType)
            .addModifiers(KModifier.PRIVATE)
            .delegate("lazy { %T(%S) }", currencyFormatType, entry.key)
            .build()
    } + PropertySpec.builder("${type}Formats", ImmutableMap::class.parameterizedBy(String::class, String::class))
        .addModifiers(KModifier.PRIVATE)
        .delegate(CodeBlock.builder().apply {
            addStatement("lazy { %M(", ClassGeneratorUtil.immutableMapOfReference)

            formats.forEach { (_, format) ->
                addStatement("  %S to %S,", format.first().assignedId, format.first().value)
            }

            add(") }")
        }.build())
        .build()

    private fun generateCurrencyFormatProperties(formats: Map<CurrencyFormat, List<NumberSystemDependentValue<CurrencyFormat>>>): List<PropertySpec> = formats.entries.mapIndexed { index, entry ->
        val id = "currencyFormat_${(index + 1).toString().padStart(2, '0')}"
        entry.value.onEach { it.assignedId = id }
        val format = entry.key

        PropertySpec.builder(id, currencyFormatType)
            .addModifiers(KModifier.PRIVATE)
            .delegate("lazy { %T(%S, %S, %S, %S, %S, %S, %S) }", currencyFormatType, format.standard, format.standardNoCurrency, format.standardAlphaNextToNumber,
                format.accounting, format.accountingNoCurrency, format.accountingAlphaNextToNumber, format.currencyPatternAppendISO)
            .build()
    }

    private fun generateSymbolsProperties(symbols: Map<Symbols, List<NumberSystemDependentValue<Symbols>>>): List<PropertySpec> = symbols.entries.mapIndexed { index, entry ->
        val id = "symbols_${(index + 1).toString().padStart(2, '0')}"
        entry.value.onEach { it.assignedId = id }
        val symbols = entry.key

        PropertySpec.builder(id, symbolsType)
            .addModifiers(KModifier.PRIVATE)
            .delegate("lazy { %T(%S, %S, %S, %S, %S, %S, %S, %S, %S, %S, %S, %S, %S, %S, %S, %S, %S, %S) }", symbolsType,
                symbols.decimal, symbols.group, symbols.plusSign, symbols.minusSign,
                symbols.infinity, symbols.nan, symbols.percentSign, symbols.perMille, symbols.approximatelySign,
                symbols.exponential, symbols.superscriptingExponent, symbols.list,
                symbols.timeSeparator, symbols.timeSeparatorAltVariant, symbols.currencyGroup, symbols.currencyDecimal,
                symbols.decimalAltUs, symbols.groupAltUs)
            .build()
    }

    private fun generateNumberFormatsProperties(
        formatsByLocale: Map<LanguageTag, NumberFormats>,
        decimalFormats: Map<String, List<NumberSystemDependentValue<String>>>,
        percentFormats: Map<String, List<NumberSystemDependentValue<String>>>,
        scientificFormats: Map<String, List<NumberSystemDependentValue<String>>>,
        currencyFormats: Map<CurrencyFormat, List<NumberSystemDependentValue<CurrencyFormat>>>,
        symbols: Map<Symbols, List<NumberSystemDependentValue<Symbols>>>
    ): List<PropertySpec> = formatsByLocale.map { (locale, formats) ->
        PropertySpec.builder(locale.tag.replace('-', '_'), numberFormatType)
            .addModifiers(KModifier.PRIVATE)
            .delegate("lazy { %T(%T.%L, %L, mapOf(${valuesForLocale(locale, symbols)}), " +
                    "mapOf(${valuesForLocale(locale, decimalFormats)}), mapOf(${valuesForLocale(locale, percentFormats)}), " +
                    "mapOf(${valuesForLocale(locale, scientificFormats)}), mapOf(${valuesForLocale(locale, currencyFormats)})) }",
                numberFormatType, NumberingSystem::class, NumberingSystem.forCode(formats.defaultNumberingSystem),
                formats.minimumGroupingDigits)
            .build()
    }


    private fun generateGetNumberFormatMethod(
        formatsByLocale: Map<LanguageTag, NumberFormats>,
        decimalFormats: Map<String, List<NumberSystemDependentValue<String>>>,
        percentFormats: Map<String, List<NumberSystemDependentValue<String>>>,
        scientificFormats: Map<String, List<NumberSystemDependentValue<String>>>,
        currencyFormats: Map<CurrencyFormat, List<NumberSystemDependentValue<CurrencyFormat>>>,
        symbols: Map<Symbols, List<NumberSystemDependentValue<Symbols>>>
    ): FunSpec  =
        FunSpec.builder("getNumberFormat")
            .addParameter("languageTag", String::class)
            .returns(numberFormatType.asTypeName().copy(nullable = true))
            .apply {
                beginControlFlow("return when(languageTag) {")
                formatsByLocale.forEach { (locale, formats) ->
                    addStatement("%S -> %N", locale.tag, locale.tag.replace('-', '_'))
                }
                addStatement("else -> null")
                endControlFlow()
            }.build()

    private fun <T> valuesForLocale(locale: LanguageTag, uniqueValues: Map<T, List<NumberSystemDependentValue<T>>>): String {
        val allValues = uniqueValues.values.flatten()
        val valuesForLocale = allValues.filter { it.locale == locale }.associate { it.numberingSystem to it.assignedId }

        return valuesForLocale.entries.joinToString { "NumberingSystem.${it.key.name} to ${it.value}" }
    }

}