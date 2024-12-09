package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty

class LanguageCurrenciesSerialModel : LocaleSpecificFileHeader<LanguageCurrenciesNumbersSerialModel>()

class LanguageCurrenciesNumbersSerialModel(
    val numbers: CurrencyNumbersSerialModel
)

class CurrencyNumbersSerialModel(
    val currencies: CurrenciesSerialModel
)

class CurrenciesSerialModel {
    @JsonAnySetter
    val currencies = mutableMapOf<String, CurrencySerialModel>()
}

class CurrencySerialModel(
    val displayName: String? = null,

    val pattern: String? = null,

    val symbol: String? = null,
    @JsonProperty("symbol-alt-narrow")
    val narrowSymbol: String? = null,
    @JsonProperty("symbol-alt-formal")
    val formalSymbol: String? = null,
    @JsonProperty("symbol-alt-variant")
    val symbolVariant: String? = null,

    val decimal: String? = null,
    val group: String? = null,

    @JsonProperty("displayName-count-zero")
    val displayNameCountZero: String? = null,
    @JsonProperty("displayName-count-one")
    val displayNameCountOne: String? = null,
    @JsonProperty("displayName-count-two")
    val displayNameCountTwo: String? = null,
    @JsonProperty("displayName-count-few")
    val displayNameCountFew: String? = null,
    @JsonProperty("displayName-count-many")
    val displayNameCountMany: String? = null,
    @JsonProperty("displayName-count-other")
    val displayNameCountOther: String? = null,
)