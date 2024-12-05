package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty

data class AvailableCurrenciesSerialModel(
    val keyword: AvailableCurrenciesKeyword
)

data class AvailableCurrenciesKeyword(
    val u: AvailableCurrenciesU
)

data class AvailableCurrenciesU(
    val cu: Currencies
)

class Currencies {
    var _description: String? = null // we ignore these
    var _alias: String? = null

    val currencyInfos = mutableMapOf<String, CurrencyInformation>()

    @JsonAnySetter
    fun addCurrency(key: String, info: CurrencyInformation) {
        currencyInfos[key] = info
    }
}

data class CurrencyInformation(
    @JsonProperty("_description")
    val description: String,
)
