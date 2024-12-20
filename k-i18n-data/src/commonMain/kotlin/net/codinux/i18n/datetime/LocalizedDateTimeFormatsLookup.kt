package net.codinux.i18n.datetime

/**
 * Kotlin Poet doesn't support parameterized types with nullable generic types like Triple<DateOrTimeFormats?, ...>,
 * so i had to create a class that can hold nullable DateOrTimeFormats instances.
 */
class LocalizedDateTimeFormatsLookup(
    var date: String? = null,
    var time: String?,
    var dateTime: String?
)