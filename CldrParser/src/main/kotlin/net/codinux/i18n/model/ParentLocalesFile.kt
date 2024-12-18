package net.codinux.i18n.model

data class ParentLocalesFile(
    val supplemental: ParentLocalesFileSupplemental
)

data class ParentLocalesFileSupplemental(
    val parentLocales: ParentLocalesParentLocales
)

data class ParentLocalesParentLocales(
    // there are also: _localeRules (1 entry), collations (0), segmentations (0), grammaticalFeatures (0) and plurals (0)
    val parentLocale: Map<String, String>
)