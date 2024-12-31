package net.codinux.i18n

fun RegionDisplayNames.getDisplayName(regionCode: String, language: LanguageTag) =
    RegionDisplayNames.getDisplayName(regionCode, language.tag)

fun RegionDisplayNames.getDisplayNamesForLocale(language: LanguageTag) =
    RegionDisplayNames.getDisplayNamesForLocale(language.tag)


fun CurrencyDisplayNames.getDisplayName(currencyIsoCode: String, language: LanguageTag) =
    CurrencyDisplayNames.getDisplayName(currencyIsoCode, language.tag)

fun CurrencyDisplayNames.getDisplayNamesForLocale(language: LanguageTag) =
    CurrencyDisplayNames.getDisplayNamesForLocale(language.tag)