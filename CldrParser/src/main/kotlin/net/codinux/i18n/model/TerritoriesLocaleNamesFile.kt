package net.codinux.i18n.model

class TerritoriesLocaleNamesFile : LocaleSpecificFileHeader<TerritoriesLocaleNamesFileContent>()

class TerritoriesLocaleNamesFileContent(
    val localeDisplayNames: TerritoriesLocaleDisplayNames
)

class TerritoriesLocaleDisplayNames(
    val territories: Map<String, String>
)