package net.codinux.i18n.model

class VariantLocaleNamesFile : LocaleSpecificFileHeader<VariantLocaleDisplayNamesFileContent>()

class VariantLocaleDisplayNamesFileContent(
    val localeDisplayNames: VariantLocaleDisplayNames
)

class VariantLocaleDisplayNames(
    val variants: Map<String, String>
)