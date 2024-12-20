package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonAnySetter

data class DateAndTimeFormats(
    val dateFormats: DateOrTimeFormats,
    val dateSkeletons: DateOrTimeFormats,
    val timeFormats: DateOrTimeFormats,
    val timeSkeletons: DateOrTimeFormats,
    val dateTimeFormats: DateTimeFormats
)

data class DateOrTimeFormats(
    val full: String,
    val long: String,
    val medium: String,
    val short: String,

    val fullAscii: String? = null,
    val longAscii: String? = null,
    val mediumAscii: String? = null,
    val shortAscii: String? = null,

    val fullVariant: String? = null,
    val longVariant: String? = null,
    val mediumVariant: String? = null,
    val shortVariant: String? = null
)

data class DateTimeFormats(
    val full: String,
    val long: String,
    val medium: String,
    val short: String,

    val availableFormats: Map<String, String> = emptyMap(),

    val appendItems: Map<String, String> = emptyMap(),

    val intervalFormats: IntervalFormats
)

data class IntervalFormats(
    val intervalFormatFallback: String,

    @JsonAnySetter
    val formats: Map<String, Map<String, String>> = emptyMap(),
)
