package net.codinux.i18n.model

class TerritoriesLocaleNamesFile : LocalSpecificFileHeader<TerritoriesLocaleNamesFileContent>()

class TerritoriesLocaleNamesFileContent(
    val localeDisplayNames: TerritoriesLocaleDisplayNames
)

class TerritoriesLocaleDisplayNames(
    val territories: Map<String, String>
)