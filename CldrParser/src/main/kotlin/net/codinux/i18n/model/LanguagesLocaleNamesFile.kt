package net.codinux.i18n.model

class LanguagesLocaleNamesFile : LocaleSpecificFileHeader<LanguagesLocaleNamesFileContent>()

data class LanguagesLocaleNamesFileContent(
    val localeDisplayNames: LanguageLocaleDisplayNames
)

data class LanguageLocaleDisplayNames(
    val languages: Map<String, String>
)