package net.codinux.i18n.unit

import net.codinux.csv.reader.CsvReader
import net.codinux.i18n.LanguageTag

class UnitDisplayNamesResolver {

    companion object {
        const val CsvFormatsSeparator = ','

        const val SquareKey = "square"
        const val CubicKey = "cubic"

        const val TimesKey = "times"
        const val PerKey = "per"
    }


    private data class DisplayNamesLookup(
        var long: DisplayFormatNamesLookup?,
        var short: DisplayFormatNamesLookup?,
        var narrow: DisplayFormatNamesLookup?
    ) {
        fun allValuesFound() = long?.allValuesFound() == true && short?.allValuesFound() == true &&
                narrow?.allValuesFound() == true
    }

    private data class DisplayFormatNamesLookup(
        val units: MutableMap<UnitDisplayNameKey, UnitDisplayName>,
        val prefixPatterns: MutableMap<UnitPrefix, String>,
        var squarePattern: String?,
        var cubicPattern: String?,
        var timesPattern: String?,
        var perPattern: String?,
    ) {
        companion object {
            fun of(units: Map<UnitDisplayNameKey, Triple<UnitDisplayName?, UnitDisplayName?, UnitDisplayName?>>, prefixes: Map<String, Triple<String?, String?, String?>>, getUnit: (Triple<UnitDisplayName?, UnitDisplayName?, UnitDisplayName?>) -> UnitDisplayName?, getValue: (Triple<String?, String?, String?>?) -> String?) =
                DisplayFormatNamesLookup((units.mapValues { getUnit(it.value) }.filter { it.value != null } as Map<UnitDisplayNameKey, UnitDisplayName>).toMutableMap(),
                    getPrefixed(prefixes) { getValue(it) }.toMutableMap(), getValue(prefixes[SquareKey]), getValue(prefixes[CubicKey]), getValue(prefixes[TimesKey]), getValue(prefixes[PerKey]))


            private fun getPrefixed(prefixes: Map<String, Triple<String?, String?, String?>>, selectValue: (Triple<String?, String?, String?>) -> String?): Map<UnitPrefix, String> =
                prefixes.toMutableMap().apply {
                    remove(SquareKey)
                    remove(CubicKey)
                    remove(TimesKey)
                    remove(PerKey)
                }.mapKeys { UnitPrefix.forConversionFactor(it.key) }
                    .mapValues { selectValue(it.value) }
                    .filter { it.value != null } as Map<UnitPrefix, String>
        }

        fun allValuesFound() = units.size >= 183 && prefixPatterns.size == 32 &&
                squarePattern != null && cubicPattern != null && timesPattern != null && perPattern != null
    }

    private val csvReader = CsvReader(CsvFormatsSeparator)


    fun getDisplayNamesForLocale(locale: LanguageTag): UnitDisplayNames =
        getDisplayNamesForLocaleOrNull(locale)
            ?: throw IllegalArgumentException("Localized unit display names not found for locale '$locale' or its parents. Are you sure this locale exists?")

    fun getDisplayNamesForLocaleOrNull(locale: LanguageTag): UnitDisplayNames? {
        val lookup = mapDisplayNamesForLocale(locale)
        var parent: LanguageTag? = locale.parent ?: LanguageTag.Root

        while ((lookup.allValuesFound() == false) && parent != null) {
            val parentLookup = mapDisplayNamesForLocale(parent)

            merge(lookup, parentLookup)

            parent = if (parent == LanguageTag.Root) null else parent.parent ?: LanguageTag.Root
        }

        return mapDisplayNames(lookup)
    }


    private fun mapDisplayNamesForLocale(locale: LanguageTag): DisplayNamesLookup {
        val (unitsCsv, prefixesCsv) = AvailableUnitDisplayNames.getDisplayNamesForLocale(locale.tag)

        val units = if (unitsCsv.isBlank()) emptyMap() else {
            csvReader.read(unitsCsv).associateBy({ UnitDisplayNameKey.forKey(it.getString(0).trim()) }) { row ->
                val narrowValues = listOf(row.getStringOrNull(1), row.getStringOrNull(2), row.getStringOrNull(3), row.getStringOrNull(4))
                val shortValues = listOf(row.getStringOrNull(5), row.getStringOrNull(6), row.getStringOrNull(7), row.getStringOrNull(8))
                val longValues = listOf(row.getStringOrNull(9), row.getStringOrNull(10), row.getStringOrNull(11), row.getStringOrNull(12))
                Triple(
                    if (narrowValues.any { it != null }) UnitDisplayName(narrowValues[0]!!, narrowValues[1], narrowValues[2], narrowValues[3]) else null,
                    if (shortValues.any { it != null }) UnitDisplayName(shortValues[0]!!, shortValues[1], shortValues[2], shortValues[3]) else null,
                    if (longValues.any { it != null }) UnitDisplayName(longValues[0]!!, longValues[1], longValues[2], longValues[3]) else null
                )
            }
        }

        val prefixes = if (prefixesCsv.isBlank()) emptyMap() else {
            csvReader.read(prefixesCsv).associateBy({ it.getString(0).trim() }) { row ->
                Triple(row.getStringOrNull(1), row.getStringOrNull(2), row.getStringOrNull(3))
            }
        }

        return DisplayNamesLookup(
            DisplayFormatNamesLookup.of(units, prefixes, { it.third }, { it?.third }),
            DisplayFormatNamesLookup.of(units, prefixes, { it.second }, { it?.second }),
            DisplayFormatNamesLookup.of(units, prefixes, { it.first }, { it?.first })
        )
    }


    private fun merge(lookup: DisplayNamesLookup, parentLookup: DisplayNamesLookup) {
        lookup.long = merge(lookup.long, parentLookup.long)
        lookup.short = merge(lookup.short, parentLookup.short)
        lookup.narrow = merge(lookup.narrow, parentLookup.narrow)
    }

    private fun merge(lookup: DisplayFormatNamesLookup?, parentLookup: DisplayFormatNamesLookup?): DisplayFormatNamesLookup? =
        if (lookup == null) {
            parentLookup
        } else {
            parentLookup?.let { parentLong ->
                parentLong.units.forEach { (name, displayName) ->
                    if (lookup.units.containsKey(name) == false) {
                        lookup.units[name] = displayName
                    }
                }
                parentLong.prefixPatterns.forEach { (name, displayName) ->
                    if (lookup.prefixPatterns.containsKey(name) == false) {
                        lookup.prefixPatterns[name] = displayName
                    }
                }
            }

            if (lookup.squarePattern == null) {
                lookup.squarePattern = parentLookup?.squarePattern
            }
            if (lookup.cubicPattern == null) {
                lookup.cubicPattern = parentLookup?.cubicPattern
            }
            if (lookup.timesPattern == null) {
                lookup.timesPattern = parentLookup?.timesPattern
            }
            if (lookup.perPattern == null) {
                lookup.perPattern = parentLookup?.perPattern
            }

            lookup
        }

    private fun mapDisplayNames(lookup: DisplayNamesLookup): UnitDisplayNames? {
        if (lookup.long == null || lookup.short == null || lookup.narrow == null) {
            return null // should only happen for custom language tags, not for language tags defined in CLDR
        }

        return UnitDisplayNames(
            mapDisplayFormatNames(lookup.long!!), mapDisplayFormatNames(lookup.short!!), mapDisplayFormatNames(lookup.narrow!!)
        )
    }

    private fun mapDisplayFormatNames(lookup: DisplayFormatNamesLookup) = UnitDisplayFormatNames(
        lookup.units, lookup.prefixPatterns, lookup.squarePattern, lookup.cubicPattern, lookup.timesPattern, lookup.perPattern
    )

}