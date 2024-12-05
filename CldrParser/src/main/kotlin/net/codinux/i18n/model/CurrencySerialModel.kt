package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty

class LanguageCurrenciesSerialModel(
    val main: LanguageCurrenciesInnerSerialModel
)

class LanguageCurrenciesInnerSerialModel {
    val inner = mutableMapOf<String, LanguageCurrenciesInnerInnerSerialModel>()

    @JsonAnySetter
    fun add(key: String, value: LanguageCurrenciesInnerInnerSerialModel) {
        inner[key] = value
    }
}

class LanguageCurrenciesInnerInnerSerialModel(
    val numbers: CurrencyNumbersSerialModel
)

class CurrencyNumbersSerialModel(
    val currencies: CurrenciesSerialModel
) {

}

class CurrenciesSerialModel {
    val currencies = mutableMapOf<String, CurrencySerialModel>()

    @JsonAnySetter
    fun add(key: String, value: CurrencySerialModel) {
        currencies[key] = value
    }
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
    val anyOtherProperties = mutableMapOf<String, Any>()

    @JsonAnySetter
    fun add(key: String, value: Any) {
        anyOtherProperties[key] = value
    }
}