package net.codinux.i18n.datetime

class LocalizedDateTimeFormats(
    val dateFormats: DateOrTimeFormats,
    val timeFormats: DateOrTimeFormats,
    val dateTimeFormats: DateOrTimeFormats
) {
    override fun toString() = "date = $dateFormats, time = $timeFormats, dateTime = $dateTimeFormats"
}