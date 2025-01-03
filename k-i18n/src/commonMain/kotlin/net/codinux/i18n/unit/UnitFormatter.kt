package net.codinux.i18n.unit

import net.codinux.i18n.LanguageTag
import net.codinux.log.logger

open class UnitFormatter(
    protected open val resolver: UnitDisplayNamesResolver = UnitDisplayNamesResolver()
) {

    private val log by logger()


    open fun getUnitDisplayName(unit: String, style: UnitFormatStyle = UnitFormatStyle.Long, language: LanguageTag = LanguageTag.current): String? {
        val (remainingString, prefixes) = extractPrefixes(unit)
        val unitKey = findKey(remainingString)
        if (unitKey != null) {
            val unitDisplayName = getUnitDisplayName(unitKey, style, language)
            if (unitDisplayName != null) {
                var formatted: String = unitDisplayName

                if (prefixes.isNotEmpty()) {
                    val displayNames = getStyleDisplayNames(style, language)
                    prefixes.reversed().forEach { prefix ->
                        val displayName = when (prefix) {
                            UnitPrefix.Square -> displayNames.squarePattern
                            UnitPrefix.Cubic -> displayNames.cubicPattern
                            else -> displayNames.prefixPatterns[prefix]
                        }
                        if (displayName != null) {
                            formatted = displayName.replace("{0}", formatted)
                        } else {
                            log.warn { "Could not format prefix $prefix for locale $language in unit string '$unit'" }
                        }
                    }
                }

                return formatted
            }
        }

        return null
    }

    open fun getUnitDisplayName(unit: UnitDisplayNameKey, style: UnitFormatStyle = UnitFormatStyle.Long, language: LanguageTag = LanguageTag.current): String? =
        getStyleDisplayNames(style, language).units[unit]?.displayName


    protected open fun findKey(unit: String): UnitDisplayNameKey? {
        val unitKeyFormat = unit.lowercase().replace(' ', '-')

        return UnitDisplayNameKey.entries.firstOrNull { key ->
            key.key == unitKeyFormat || unit.equals(key.englishName, true)
        }
    }

    protected open fun extractPrefixes(unit: String): Pair<String, List<UnitPrefix>> {
        var remainingString = unit
        val prefixes = mutableListOf<UnitPrefix>()

        if (remainingString.contains("squared")) {
            remainingString = remainingString.replace("squared", "")
            prefixes.add(UnitPrefix.Square)
        }
        if (remainingString.contains("square ")) {
            remainingString = remainingString.replace("square ", "")
            prefixes.add(UnitPrefix.Square)
        }
        if (remainingString.contains("cubic ")) {
            remainingString = remainingString.replace("cubic ", "")
            prefixes.add(UnitPrefix.Cubic)
        }

        UnitPrefix.entries.forEach { unitPrefix ->
            val prefixName = unitPrefix.englishName
            if (remainingString.contains(prefixName)) {
                remainingString = remainingString.replace(prefixName, "")
                prefixes.add(unitPrefix)
            }
        }

        return Pair(remainingString.trim(), prefixes)
    }

    protected open fun getStyleDisplayNames(style: UnitFormatStyle, language: LanguageTag): UnitDisplayFormatNames {
        val displayNames = resolver.getDisplayNamesForLocale(language)

        return when (style) {
            UnitFormatStyle.Long -> displayNames.long
            UnitFormatStyle.Short -> displayNames.short
            UnitFormatStyle.Narrow -> displayNames.narrow
        }
    }

}