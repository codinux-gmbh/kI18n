package net.codinux.i18n.datetime

data class DateTimeFormat(
    val dateFormat: String,
    val timeFormat: String,
    val dateTimeFormat: String,
) {

    companion object {
        val IsoDatePattern = "yyyy-MM-dd"
        val IsoLocalTimePattern = "HH:mm:ss.SSSSSSSSS"
        val IsoTimePattern = "$IsoLocalTimePattern'Z'"
        val IsoDateTimePattern = "$IsoDatePattern'T'$IsoLocalTimePattern"
    }

}