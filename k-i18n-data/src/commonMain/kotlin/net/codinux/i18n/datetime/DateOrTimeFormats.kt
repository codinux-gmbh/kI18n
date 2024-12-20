package net.codinux.i18n.datetime

open class DateOrTimeFormats(
    val full: String,
    val long: String,
    val medium: String,
    val short: String
) {
    override fun toString() = medium
}