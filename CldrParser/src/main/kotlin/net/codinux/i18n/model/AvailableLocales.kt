package net.codinux.i18n.model

data class AvailableLocales(
    val availableLocales: AvailableLocaleNames
) {
    override fun toString() = availableLocales.toString()
}

data class AvailableLocaleNames(
    val full: List<String>,
    val modern: List<String> = emptyList() // seems always to be empty
) {
    override fun toString() = "${full.size + modern.size} locale names: ${full.joinToString()}"
}