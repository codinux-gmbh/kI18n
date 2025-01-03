package net.codinux.i18n.unit

import net.codinux.i18n.LanguageTag

open class UnitFormatter(
    protected open val resolver: UnitDisplayNamesResolver = UnitDisplayNamesResolver()
) {

    open fun getUnitDisplayName(unit: String, style: UnitFormatStyle = UnitFormatStyle.Long, language: LanguageTag = LanguageTag.current): String? {
        val unitKey = findKey(unit)
        if (unitKey != null) {
            return getUnitDisplayName(unitKey, style, language)
        }

        return null
    }

    open fun getUnitDisplayName(unit: UnitDisplayNameKey, style: UnitFormatStyle = UnitFormatStyle.Long, language: LanguageTag = LanguageTag.current): String? {
        val displayNames = resolver.getDisplayNamesForLocale(language)
        val styleDisplayNames = when (style) {
            UnitFormatStyle.Long -> displayNames.long
            UnitFormatStyle.Short -> displayNames.short
            UnitFormatStyle.Narrow -> displayNames.narrow
        }

        return styleDisplayNames.units[unit]?.displayName
    }


    private fun findKey(unit: String): UnitDisplayNameKey? {
        val unitKeyFormat = unit.lowercase().replace(' ', '-')

        return UnitDisplayNameKey.entries.firstOrNull { key ->
            key.key == unitKeyFormat || unit.equals(key.englishName, true)
        }
    }

}