package net.codinux.i18n.model

data class LocaleDisplayNames(

    val numberingSystems: Map<String, String>,
    val currencyFormatStyle: Map<String, String>,

    val calendar: Map<String, String>,

    val localeDisplayPattern: Map<String, String> = emptyMap(),
    val subdivisions: Map<String, String> = emptyMap(),
    val keys: Map<String, String> = emptyMap(),
    val codePatterns: Map<String, String> = emptyMap(),

    val measurementSystem: Map<String, String> = emptyMap(),
    val measurementUnitOverride: Map<String, String> = emptyMap(),
)