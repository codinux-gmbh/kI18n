package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeSpec
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.model.Currency
import net.codinux.i18n.model.Iso4217CurrencyEntry
import net.codinux.i18n.parser.CldrJsonParser
import net.codinux.i18n.parser.Iso4217CurrencyFileParser
import kotlin.io.path.Path
import kotlin.io.path.absolute

fun main() {
    CurrencyEnumGenerator().generate()
}

class CurrencyEnumGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val currencyFileParser: Iso4217CurrencyFileParser = Iso4217CurrencyFileParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val currentCurrencies = currencyFileParser.parse(Path("").absolute().resolve("docs/Currencies/ISO 4217 01 Current Currencies.xls"), true)
        val historicDenominations = currencyFileParser.parse(Path("").absolute().resolve("docs/Currencies/ISO 4217 03 Historic Denominations (Currencies and Funds).xls"), false)
        val currenciesFromIsoLists = (currentCurrencies + historicDenominations).groupBy { it.currencyAlpha3Code } // there may are multiple entries per denomination e.g. for Euro one per country

        val englishCurrencyNames = cldrJsonParser.parseCurrenciesForLocale(LanguageTag.English) // for English for all currencies displayName is set
        val englishCurrencyNamesByCode = englishCurrencyNames.associateBy { it.isoCode }

        val constructor = FunSpec.constructorBuilder()
            .addParameter("alpha3Code", String::class, false, "Uppercase alpha-3 three-letter ISO 4217 currency code.")
            .addParameter("numericCode", Int::class, true, "Numeric three-digit ISO 4217 currency code.")
            .addParameter("symbol", String::class, true, "Currency symbol, if available.")
            .addParameter("symbolVariant", String::class, true, "Variant of currency symbol, if available.")
            .addParameter("englishName", String::class, false, "English name of the currency.")
            .addParameter("isCurrentCurrency", Boolean::class, false, "If the currency is a current or historic denomination.")
            .addParameter("minorUnit", Int::class, true, "Currency's minor unit (e.g. for Euro and Dollar '2' for 100 Cent, for Yen 0 as there is no minor unit).")
            .addParameter("withdrawalDate", String::class, true, "For historic denominations the date of withdrawal.")
            .addParameter("countries", List::class.parameterizedBy(String::class))
            .build()


        val enumConstants = currenciesFromIsoLists.toSortedMap().map { (alpha3Code, currencyEntries) ->
            createEnumConstant(alpha3Code, currencyEntries, englishCurrencyNamesByCode)
        }

        util.writeEnumClass("Currency", enumConstants, constructor)
    }

    private fun createEnumConstant(alpha3Code: String, currencyEntries: List<Iso4217CurrencyEntry>, englishNames: Map<String, Currency>): Pair<String, TypeSpec> {
        val currency = currencyEntries.first()
        val englishName = englishNames[alpha3Code]
        val symbolVariant = englishName?.symbolVariant ?: englishName?.narrowSymbol ?: englishName?.formalSymbol

        return (currency.currencyName) to TypeSpec.anonymousClassBuilder()
            .addSuperclassConstructorParameter("%S", alpha3Code)
            .addNullableSuperclassConstructorParameter(currency.currencyNumericCode)
            .addSuperclassConstructorParameter("%L", englishName?.symbol?.let { "\"$it\"" } ?: "null") // %S would write "$" as "${'$'}"
            .addSuperclassConstructorParameter("%L", symbolVariant?.let { "\"$it\"" } ?: "null") // %S would write "$" as "${'$'}"
            .addSuperclassConstructorParameter("%S", currency.currencyName)
            .addSuperclassConstructorParameter("%L", currency.isCurrentCurrency)
            .addNullableSuperclassConstructorParameter(currency.minorUnit)
            .addNullableSuperclassConstructorParameter(currency.withdrawalDate)
            .addNullableSuperclassConstructorParameter(currencyEntries.map { it.country.replace('"', '\'') }.toSet().sorted())
            .build()
    }

}