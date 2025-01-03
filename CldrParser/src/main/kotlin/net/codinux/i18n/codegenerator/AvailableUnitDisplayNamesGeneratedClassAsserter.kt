package net.codinux.i18n.codegenerator

import net.codinux.i18n.LanguageTag
import net.codinux.i18n.model.UnitDisplayName
import net.codinux.i18n.model.UnitPattern
import net.codinux.i18n.model.UnitsDisplayNamesForLocale
import net.codinux.i18n.model.UnitsLocaleDisplayNames
import net.codinux.i18n.parser.CldrJsonParser
import net.codinux.i18n.unit.*

fun main() {
    AvailableUnitDisplayNamesGeneratedClassAsserter().assert()
}

/**
 * It cannot be run directory after [AvailableUnitDisplayNamesClassGenerator.generate] as
 * [net.codinux.i18n.unit.AvailableUnitDisplayNames] has to be compiled first. So i extracted this class, which
 * has to be run manually after [AvailableUnitDisplayNamesClassGenerator.generate].
 */
class AvailableUnitDisplayNamesGeneratedClassAsserter(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser()
) {

    fun assert() {
        val locales = cldrJsonParser.getLocalesWithLocalizedUnits().map { LanguageTag.ofAvailable(it) }

        val allByLocale = locales.associateWith { cldrJsonParser.parseUnitNamesForLocale(it) }

        assertFormatsHaveBeenWrittenCorrectly(allByLocale)
    }

    private fun assertFormatsHaveBeenWrittenCorrectly(allByLocale: Map<LanguageTag, UnitsDisplayNamesForLocale>) {
        val resolver = UnitDisplayNamesResolver()

        allByLocale.forEach { (locale, displayNames) ->
            val resolvedDisplayNames = resolver.getDisplayNamesForLocale(locale)

            assertDisplayNamesEqual(locale, displayNames, resolvedDisplayNames)
        }
    }

    private fun assertDisplayNamesEqual(locale: LanguageTag, expected: UnitsDisplayNamesForLocale, resolved: UnitDisplayNames) {
        assertDisplayNamesEqual(locale, expected.long, resolved.long)

        assertDisplayNamesEqual(locale, expected.short, resolved.short)

        assertDisplayNamesEqual(locale, expected.narrow, resolved.narrow)
    }

    private fun assertDisplayNamesEqual(locale: LanguageTag, expected: UnitsLocaleDisplayNames, resolved: UnitDisplayFormatNames) {
        assertUnits(locale, expected.units, resolved.units)

        assertPrefixes(locale, expected.prefixPatterns, resolved.prefixPatterns)

        val expectedSquarePattern = expected.powerPatterns.firstOrNull { it.unit == "power2" }?.unitPattern
        require(expectedSquarePattern == resolved.squarePattern) {
            "Square pattern of locale $locale does not match. CLDR: '$expectedSquarePattern', resolved: '${resolved.squarePattern}'"
        }
        val expectedCubicPattern = expected.powerPatterns.firstOrNull { it.unit == "power3" }?.unitPattern
        require(expectedCubicPattern == resolved.cubicPattern) {
            "Cubic pattern of locale $locale does not match. CLDR: '$expectedCubicPattern', resolved: '${resolved.cubicPattern}'"
        }

        val expectedTimesPattern = expected.compoundPatterns.firstOrNull { it.unit == UnitDisplayNamesResolver.TimesKey }?.unitPattern
        require(expectedTimesPattern == resolved.timesPattern) {
            "Times pattern of locale $locale does not match. CLDR: '$expectedTimesPattern', resolved: '${resolved.timesPattern}'"
        }
        val expectedPerPattern = expected.compoundPatterns.firstOrNull { it.unit == UnitDisplayNamesResolver.PerKey }?.unitPattern
        require(expectedPerPattern == resolved.perPattern) {
            "Per pattern of locale $locale does not match. CLDR: '$expectedPerPattern', resolved: '${resolved.perPattern}'"
        }
    }

    private fun assertUnits(locale: LanguageTag, expected: List<UnitDisplayName>, resolved: Map<UnitDisplayNameKey, net.codinux.i18n.unit.UnitDisplayName>) {
        val expectedUnits = expected.associateBy({ it.unit })
        // ensure that all keys match
        require(expectedUnits.size == resolved.size && expectedUnits.keys.containsAll(resolved.keys.map { it.key })) {
            "Units of locale $locale do not match. CLDR: '$expected', resolved: '$resolved'"
        }

        expectedUnits.forEach { (key, displayName) ->
            val resolvedUnit = resolved[UnitDisplayNameKey.forKey(key)]
            require(fixKotlinPoetBugs(displayName.displayName) == resolvedUnit?.displayName) {
                "Display name for '$key' of locale $locale does not match. CLDR: '${displayName.displayName}', resolved: '${resolvedUnit?.displayName}'"
            }
            require(fixKotlinPoetBugs(displayName.perUnitPattern) == resolvedUnit?.perUnitPattern) {
                "Per Unit pattern for '$key' of locale $locale does not match. CLDR: '${displayName.perUnitPattern}', resolved: '${resolvedUnit?.perUnitPattern}'"
            }
            require(fixKotlinPoetBugs(displayName.unitPatternCountOne) == resolvedUnit?.unitPatternCountOne) {
                "Unit pattern count one for '$key' of locale $locale does not match. CLDR: '${displayName.unitPatternCountOne}', resolved: '${resolvedUnit?.unitPatternCountOne}'"
            }
            require(fixKotlinPoetBugs(displayName.unitPatternCountOther) == resolvedUnit?.unitPatternCountOther) {
                "Unit pattern count other for '$key' of locale $locale does not match. CLDR: '${displayName.unitPatternCountOther}', resolved: '${resolvedUnit?.unitPatternCountOther}'"
            }
        }
    }

    private fun assertPrefixes(locale: LanguageTag, expected: List<UnitPattern>, resolved: Map<UnitPrefix, String>) {
        val expectedPrefixes = expected.associateBy({ it.unit }, { it.unitPattern })
        // ensure that all keys match
        require(expectedPrefixes.size == resolved.size && expectedPrefixes.keys.containsAll(resolved.keys.map { it.conversionFactor })) {
            "Prefix pattern of locale $locale do not match. CLDR: '$expected', resolved: '$resolved'"
        }

        expectedPrefixes.forEach { (prefix, unitPattern) ->
            val resolvedPattern = resolved[UnitPrefix.forConversionFactor(prefix)]
            require(fixKotlinPoetBugs(unitPattern) == resolvedPattern) {
                "Prefix pattern for '$prefix' of locale $locale does not match. CLDR: '$unitPattern', resolved: '$resolvedPattern'"
            }
        }
    }

    private fun fixKotlinPoetBugs(pattern: String?) =
        pattern?.replace('·', ' ') // KotlinPoet writes instead of '·' ' ' to output
            ?.replace("\"", "\'\'")

}