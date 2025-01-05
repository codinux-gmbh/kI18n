package net.codinux.i18n.unit

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEmpty
import assertk.assertions.isNotNull
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.UnitAll
import net.codinux.i18n.UnitAnnex
import net.codinux.log.Log
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.fail

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
    fun getUnitDisplayName_ByUnitEnglishName_JoulePerSquareMeter() {
        val result = underTest.getUnitDisplayName("Joule per square meters", UnitFormatStyle.Narrow, LanguageTag.German)

        assertThat(result).isEqualTo("J/m²")
    }

    @Test
    fun getUnitDisplayName_ByUnitEnglishName_WattHour() {
        val result = underTest.getUnitDisplayName("watt hour", UnitFormatStyle.Narrow, LanguageTag.German)

        assertThat(result).isEqualTo("W⋅Std.") // not that nice
    }

    @Test
    fun getUnitDisplayName_ByUnitEnglishName_GigawattHour() {
        val result = underTest.getUnitDisplayName("gigawatt hour", UnitFormatStyle.Narrow, LanguageTag.German)

        assertThat(result).isEqualTo("GW⋅Std.")
    }

    @Test
    fun getUnitDisplayName_ByUnitEnglishName_GigawattHour_KeepSpaceSeparatorForFormatStyleLong() {
        val result = underTest.getUnitDisplayName("gigawatt hour", UnitFormatStyle.Long, LanguageTag.German)

        assertThat(result).isEqualTo("GigaWatt Stunden")
    }


    @Test
    fun cleanAndGetUnitDisplayName_MicrometerMicron() {
        val result = underTest.cleanAndGetUnitDisplayName("micrometre (micron)", UnitFormatStyle.Narrow, LanguageTag.English)

        assertThat(result).isEqualTo("μm")
    }

    @Test
    fun cleanAndGetUnitDisplayName_MinuteUnitOfTime() {
        val result = underTest.cleanAndGetUnitDisplayName("minute [unit of time]", UnitFormatStyle.Narrow, LanguageTag.English)

        assertThat(result).isEqualTo("min")
    }

    @Test
    fun cleanAndGetUnitDisplayName_OfUnit_Tonne() {
        val result = underTest.cleanAndGetUnitDisplayName(UnitAll.TNE.englishName, UnitFormatStyle.Narrow, LanguageTag.English)

        assertThat(result).isEqualTo("t")
    }


    @Ignore
    @Test
    fun getUnitDisplayName_ByUnitEnglishName() {
        val englishNames = UnitDisplayNamesResolver().getDisplayNamesForLocale(LanguageTag.English).long.units
        val supportedFormats = englishNames.values.filterNot { it.displayName.contains("-") || it.displayName.contains(" of ") }

        supportedFormats.forEach { englishName ->
            val result = underTest.getUnitDisplayName(englishName.displayName)

            assertThat(result, "Display name of '${englishName.displayName}' should not be null or empty")
                .isNotNull().isNotEmpty()
        }
    }

    @Ignore
    @Test
    fun getUnitDisplayName_ByUnitEnglishName_OfUnit() {
        val failed = UnitAll.entries.filter { it.annex == UnitAnnex.Annex1 }.filter { unit ->
            underTest.cleanAndGetUnitDisplayName(unit.englishName) == null
        }

        Log.info { "${failed.size} units failed:" }
        failed.forEach { unit -> println(unit) }

        if (failed.isNotEmpty()) {
            fail("UnitFormatter should be able to format all Units, but it failed for ${failed.size} units")
        }
    }

}