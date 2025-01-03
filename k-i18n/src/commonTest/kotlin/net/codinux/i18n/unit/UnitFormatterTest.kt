package net.codinux.i18n.unit

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEmpty
import assertk.assertions.isNotNull
import net.codinux.i18n.LanguageTag
import kotlin.test.Test

class UnitFormatterTest {

    private val underTest = UnitFormatter()


    @Test
    fun getUnitDisplayName_GForce_German_Narrow() {
        val result = underTest.getUnitDisplayName(UnitDisplayNameKey.GForce, UnitFormatStyle.Narrow, LanguageTag.German)

        assertThat(result).isEqualTo("G")
    }

    @Test
    fun getUnitDisplayName_KilowattHourPer100Kilometer_English_Long() {
        val result = underTest.getUnitDisplayName(UnitDisplayNameKey.KilowattHourPer100Kilometer, UnitFormatStyle.Long, LanguageTag.English)

        assertThat(result).isEqualTo("kilowatt-hours per 100 kilometers")
    }

    @Test
    fun getUnitDisplayName_AllKeys_AllLocales_AllStyles() {
        // filter out Japanese units, dot, food calorie and GasolineEnergyDensity as most locales don't have display names for these
        val unitsAvailableInAllLanguages = UnitDisplayNameKey.entries.filter {
            it.englishName != null && it.key.contains("dot") == false && it.key.contains("food") == false && it.key.contains("gasoline") == false
        }

        LanguageTag.availableLanguageTags.forEach { locale ->
            unitsAvailableInAllLanguages.forEach { unitKey ->
                UnitFormatStyle.entries.forEach { style ->
                    val result = underTest.getUnitDisplayName(unitKey, style, locale)

                    assertThat(result, "$style $unitKey of locale $locale should not be null or empty")
                        .isNotNull().isNotEmpty()
                }
            }
        }
    }


    @Test
    fun getUnitDisplayName_ByUnitEnglishName() {
        val englishNames = UnitDisplayNamesResolver().getDisplayNamesForLocale(LanguageTag.English).long.units
        val supportedFormats = englishNames.values.filterNot { it.displayName.contains(" per ") || it.displayName.contains("-") || it.displayName.contains(" of ") }

        supportedFormats.forEach { englishName ->
            val result = underTest.getUnitDisplayName(englishName.displayName)

            assertThat(result, "Display name of '${englishName.displayName}' should not be null or empty")
                .isNotNull().isNotEmpty()
        }
    }

}