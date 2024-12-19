package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonProperty

data class NumberFormats(
    val defaultNumberingSystem: String,
    val defaultNumberingSystemAltLatn: String? = null,
    val otherNumberingSystems: Map<String, String> = emptyMap(),

    val minimumGroupingDigits: Int,

    val symbols: Map<String, Symbols>,

    val decimalFormats: Map<String, DecimalFormats>,
    val scientificFormats: Map<String, DecimalFormats>,
    val percentFormats: Map<String, DecimalFormats>,
    val currencyFormats: Map<String, DecimalFormats>,

    val miscPatterns: Map<String, MiscPatterns>,
    val minimalPairs: MinimalPairs,
)

data class Symbols(
    val decimal: String,
    val group: String,
    val list: String,
    val percentSign: String,
    val plusSign: String,
    val minusSign: String,
    val approximatelySign: String,
    val exponential: String,
    val superscriptingExponent: String,
    val perMille: String,
    val infinity: String,
    val nan: String,

    val timeSeparator: String,
    @JsonProperty("timeSeparator-alt-variant")
    val timeSeparatorAltVariant: String? = null,

    val currencyGroup: String? = null,
    val currencyDecimal: String? = null,

    @JsonProperty("decimal-alt-us")
    val decimalAltUs: String? = null,
    @JsonProperty("group-alt-us")
    val groupAltUs: String? = null
)

data class DecimalFormats(
    val standard: String,

    // TODO: there are also long and short formats

    @JsonProperty("standard-noCurrency")
    val standardNoCurrency: String? = null,
    val accounting: String? = null,
    @JsonProperty("accounting-noCurrency")
    val accountingNoCurrency: String? = null,

    val currencyPatternAppendISO: String? = null,

    val currencySpacing: CurrencySpacing? = null,

    @JsonProperty("standard-alphaNextToNumber")
    val standardAlphaNextToNumber: String? = null,
    @JsonProperty("accounting-alphaNextToNumber")
    val accountingAlphaNextToNumber: String? = null,

    @JsonProperty("unitPattern-count-zero")
    val unitPatternCountZero: String? = null,
    @JsonProperty("unitPattern-count-one")
    val unitPatternCountOne: String? = null,
    @JsonProperty("unitPattern-count-two")
    val unitPatternCountTwo: String? = null,
    @JsonProperty("unitPattern-count-few")
    val unitPatternCountFew: String? = null,
    @JsonProperty("unitPattern-count-many")
    val unitPatternCountMany: String? = null,
    @JsonProperty("unitPattern-count-other")
    val unitPatternCountOther: String? = null
)

data class CurrencySpacing(
    val beforeCurrency: CurrencySpacingValues? = null,
    val afterCurrency: CurrencySpacingValues? = null
)

data class CurrencySpacingValues(
    val currencyMatch: String,
    val surroundingMatch: String,
    val insertBetween: String
)

data class MinimalPairs(
    val other: String,
    val zero: String? = null,
    val one: String? = null,
    val two: String? = null,
    val few: String? = null,
    val many: String? = null,

    @JsonProperty("pluralMinimalPairs-count-zero")
    val pluralMinimalPairsCountZero: String? = null,
    @JsonProperty("pluralMinimalPairs-count-one")
    val pluralMinimalPairsCountOne: String? = null,
    @JsonProperty("pluralMinimalPairs-count-two")
    val pluralMinimalPairsCountTwo: String? = null,
    @JsonProperty("pluralMinimalPairs-count-few")
    val pluralMinimalPairsCountFew: String? = null,
    @JsonProperty("pluralMinimalPairs-count-many")
    val pluralMinimalPairsCountMany: String? = null,
    @JsonProperty("pluralMinimalPairs-count-other")
    val pluralMinimalPairsCountOther: String? = null,

    val feminine: String? = null,
    val masculine: String? = null,
    val neuter: String? = null,

    val accusative: String? = null,
    val dative: String? = null,
    val genitive: String? = null,
    val nominative: String? = null,
    val vocative: String? = null,
    val locative: String? = null,

    val common: String? = null,
    val inanimate: String? = null,
    val instrumental: String? = null,

    val partitive: String? = null,
    val elative: String? = null,
    val illative: String? = null,

    val oblique: String? = null,
    val terminative: String? = null,
    val translative: String? = null,
    val ablative: String? = null,
    val sociative: String? = null,
    val ergative: String? = null,
    val prepositional: String? = null
)

data class MiscPatterns(
    val approximately: String,
    val atLeast: String,
    val atMost: String,
    val range: String
)