package net.codinux.i18n.datetime

data class LocalTime(
    val hour: Int,
    val minute: Int,
    val second: Int = 0,
    val nanosecondOfSecond: Int = 0
) {
    companion object {
        val StartOfDay = LocalTime(0, 0)
        val Midnight = StartOfDay
        val Min = StartOfDay

        val Noon = LocalTime(12, 0)

        val EndOfDay = LocalTime(23, 59, 59, 999_999_999)
        val Max = EndOfDay
    }


    override fun toString(): String {
        var string = "${hour.toString().padStart(2, '0')}:${minute.toString().padStart(2, '0')}"

        if (second > 0 || nanosecondOfSecond > 0) {
            string += ":${second.toString().padStart(2, '0')}"
        }
        if (nanosecondOfSecond > 0) {
            string += ".${nanosecondOfSecond.toString().padStart(3, '0')}"
        }

        return string
    }

}