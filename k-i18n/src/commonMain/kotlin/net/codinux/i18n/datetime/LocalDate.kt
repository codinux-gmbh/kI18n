package net.codinux.i18n.datetime

data class LocalDate(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int
) {
    override fun toString() = "$year-$month-$dayOfMonth"
}