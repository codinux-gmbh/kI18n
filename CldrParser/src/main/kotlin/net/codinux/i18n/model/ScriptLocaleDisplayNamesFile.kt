package net.codinux.i18n.model

class ScriptLocaleNamesFile : LocaleSpecificFileHeader<ScriptLocaleDisplayNamesFileContent>()

class ScriptLocaleDisplayNamesFileContent(
    val localeDisplayNames: ScriptLocaleDisplayNames
)

class ScriptLocaleDisplayNames(
    val scripts: Map<String, String>
)