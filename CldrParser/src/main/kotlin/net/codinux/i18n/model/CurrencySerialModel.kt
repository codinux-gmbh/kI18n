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

    @JsonProperty("displayName-count-one")
    val displayNameCountOne: String? = null,
    @JsonProperty("displayName-count-other")
    val displayNameCountOther: String? = null,

    val symbol: String? = null,
    @JsonProperty("symbol-alt-narrow")
    val symbolAltNarrow: String? = null
) {
    @JsonAnySetter
    val anyOtherProperties = mutableMapOf<String, Any>()
}