package net.codinux.i18n

fun CurrencyDisplayNames.getDisplayName(currencyIsoCode: String, language: LanguageTag) =
    CurrencyDisplayNames.getDisplayName(currencyIsoCode, language.tag)

fun CurrencyDisplayNames.getDisplayNamesForLocale(language: LanguageTag) =
    CurrencyDisplayNames.getDisplayNamesForLocale(language.tag)