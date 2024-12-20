package net.codinux.i18n.datetime

import net.codinux.i18n.LanguageTag
import net.codinux.i18n.Region

data class PreferredWeekData(
    val minDays: Map<Region, Int>,
    val firstDay: Map<Region, DayOfWeek>,
    val weekendStart: Map<Region, DayOfWeek>,
    val weekendEnd: Map<Region, DayOfWeek>,
    // TODO: what to do with this data?
    val weekOfPreference: Map<LanguageTag, List<String>>
)
