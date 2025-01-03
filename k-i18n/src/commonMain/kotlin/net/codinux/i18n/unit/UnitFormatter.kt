package net.codinux.i18n.unit

import net.codinux.i18n.LanguageTag

open class UnitFormatter(
    protected open val resolver: UnitDisplayNamesResolver = UnitDisplayNamesResolver()
) {

    open fun getUnitDisplayName(unit: UnitDisplayNameKey, style: UnitFormatStyle = UnitFormatStyle.Long, language: LanguageTag = LanguageTag.current): String? {
        val displayNames = resolver.getDisplayNamesForLocale(language)
        val styleDisplayNames = when (style) {
            UnitFormatStyle.Long -> displayNames.long
            UnitFormatStyle.Short -> displayNames.short
            UnitFormatStyle.Narrow -> displayNames.narrow
        }

        return styleDisplayNames.units[unit]?.displayName
    }

}