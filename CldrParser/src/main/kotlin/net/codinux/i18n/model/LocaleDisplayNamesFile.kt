package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty

data class LocaleDisplayNamesFile(
    val main: Map<String, LocaleDisplayNamesFileMain>
)

data class LocaleDisplayNamesFileMain(
    val localeDisplayNames: LocaleDisplayNamesFileContent
)

data class LocaleDisplayNamesFileContent(
    val localeDisplayPattern: Map<String, String> = emptyMap(),
    val subdivisions: Map<String, String> = emptyMap(),
    val keys: Map<String, String> = emptyMap(),
    val codePatterns: Map<String, String> = emptyMap(),

    val types: LocaleDisplayNamesTypes = LocaleDisplayNamesTypes()
)

data class LocaleDisplayNamesTypes(
    val calendar: Map<String, String> = emptyMap(),
    @JsonProperty("cf")
    val currencyFormatStyle: Map<String, String> = emptyMap(),

    val collation: Map<String, String> = emptyMap(),
    val colAlternate: Map<String, String> = emptyMap(),
    val colBackwards: Map<String, String> = emptyMap(),
    val colCaseFirst: Map<String, String> = emptyMap(),
    val colCaseLevel: Map<String, String> = emptyMap(),
    val colNormalization: Map<String, String> = emptyMap(),
    val colNumeric: Map<String, String> = emptyMap(),
    val colReorder: Map<String, String> = emptyMap(),
    val colStrength: Map<String, String> = emptyMap(),

    val d0: Map<String, String> = emptyMap(),
    @JsonProperty("em")
    val emojiPresentationStyle: Map<String, String> = emptyMap(),
    @JsonProperty("fw")
    val firstDayOfWeek: Map<String, String> = emptyMap(),
    val h0: Map<String, String> = emptyMap(),
    @JsonProperty("hc")
    val hourCycle: Map<String, String> = emptyMap(),
    val i0: Map<String, String> = emptyMap(),
    val k0: Map<String, String> = emptyMap(),
    val kv: Map<String, String> = emptyMap(),
    @JsonProperty("lb")
    val lineBreakStyle: Map<String, String> = emptyMap(),
    @JsonProperty("lw")
    val lineBreakWordHandling: Map<String, String> = emptyMap(),
    val m0: Map<String, String> = emptyMap(),
    @JsonProperty("ms")
    val measurementSystem: Map<String, String> = emptyMap(),
    @JsonProperty("mu")
    val measurementUnitOverride: Map<String, String> = emptyMap(),

    val numbers: Map<String, String> = emptyMap(),

    val s0: Map<String, String> = emptyMap(),
    @JsonProperty("ss")
    val sentenceBreakSuppressions: Map<String, String> = emptyMap(),
    val t0: Map<String, String> = emptyMap(),
    val va: Map<String, String> = emptyMap()
)