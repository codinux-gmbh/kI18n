package net.codinux.i18n.unit

import assertk.assertThat
import assertk.assertions.isEqualTo
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

}