package net.codinux.i18n.model

data class LanguageDisplayNamesForLocale(
    val languages: Map<String, LanguageDisplayNames>
)

data class LanguageDisplayNames(
    val languageIsoCode: String,
    val displayName: String
)