package net.codinux.i18n.datetime

data class LocalDate(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int
) {
    init {
        require(month in 1..12) { "Invalid month, value must be in bounds [1-12]: $month" }
        require(dayOfMonth in 1..31) { "Invalid day, value must be in bounds [1-31]: $dayOfMonth" }
    }

    override fun toString() = "$year-$month-$dayOfMonth"
}