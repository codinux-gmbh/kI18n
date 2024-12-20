package net.codinux.i18n.model

data class WeekDataFile(
    val supplemental: WeekDataFileSupplemental
)

data class WeekDataFileSupplemental(
    val weekData: WeekDataFileContent
)

data class WeekDataFileContent(
    val minDays: Map<String, Int>,
    val firstDay: Map<String, String>,
    val weekendStart: Map<String, String>,
    val weekendEnd: Map<String, String>,
    val weekOfPreference: Map<String, List<String>>
)