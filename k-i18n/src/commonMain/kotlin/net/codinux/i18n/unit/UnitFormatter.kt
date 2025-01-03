package net.codinux.i18n.unit

import net.codinux.i18n.LanguageTag
import net.codinux.log.logger

open class UnitFormatter(
    protected open val resolver: UnitDisplayNamesResolver = UnitDisplayNamesResolver()
) {

    private val log by logger()


    open fun getUnitDisplayName(unit: UnitDisplayNameKey, style: UnitFormatStyle = UnitFormatStyle.Long, language: LanguageTag = LanguageTag.current): String? =
        getStyleDisplayNames(style, language).units[unit]?.displayName

    open fun getUnitDisplayName(unit: String, style: UnitFormatStyle = UnitFormatStyle.Long, language: LanguageTag = LanguageTag.current): String? {
        val unitKey = findKey(unit)
        if (unitKey != null) {
            val unitDisplayName = getUnitDisplayName(unitKey, style, language)
            if (unitDisplayName != null) {
                return unitDisplayName
            }
        }

        val perParts = unit.split(" per ")
        if (perParts.size == 1) {
            return formatPart(perParts.first(), style, language)
        } else if (perParts.size == 2) {
            return formatPerUnit(perParts.first(), perParts[1]!!, style, language)
        }

        return null
    }


    protected open fun formatPart(unit: String, style: UnitFormatStyle, language: LanguageTag): String? {
        val (remainingString, prefixes) = extractPrefixes(unit)
        val unitKey = findKey(remainingString)
        if (unitKey != null) {
            val unitDisplayName = getUnitDisplayName(unitKey, style, language)
            if (unitDisplayName != null) {
                return formatPrefixes(unit, unitDisplayName, prefixes, style, language)
            }
        }

        return null
    }

    protected open fun formatPrefixes(unit: String, unitDisplayName: String, prefixes: List<UnitPrefix>, style: UnitFormatStyle, language: LanguageTag): String {
        var formatted = unitDisplayName

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

    protected open fun formatPerUnit(numerator: String, denominator: String, style: UnitFormatStyle, language: LanguageTag): String? {
        val numeratorFormatted = formatPart(numerator, style, language)
        if (numeratorFormatted != null) {
            val (remainingString, prefixes) = extractPrefixes(denominator)
            val unitKey = findKey(remainingString)

            if (unitKey != null) {
                val perUnitPattern = getStyleDisplayNames(style, language).units[unitKey]?.perUnitPattern
                if (perUnitPattern != null) {
                    val denominatorFormatted = formatPrefixes(denominator, perUnitPattern, prefixes, style, language)
                    return denominatorFormatted.replace("{0}", numeratorFormatted)
                }
            } else {
                log.warn { "Could not find UnitKey for '$remainingString' of denominator '$denominator'" }
            }
        }

        return null
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