package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode

data class DateFormatsFile(
    val main: Map<String, DateFormatsFileMain>
)

data class DateFormatsFileMain(
    val dates: DateFormatsDates
)

data class DateFormatsDates(
    val calendars: Map<String, DateFormatsForCalendar>
)

data class DateFormatsForCalendar(
    val dateFormats: DateOrTimeFormatsSerialModel,
    val dateSkeletons: DateOrTimeFormatsSerialModel,
    val timeFormats: DateOrTimeFormatsSerialModel,
    val timeSkeletons: DateOrTimeFormatsSerialModel,
    val dateTimeFormats: DateTimeFormats
)

data class DateOrTimeFormatsSerialModel(
    val full: String,
    val long: String,
    val medium: String,

    // hilarious, there's one ca-gregorian.json file (locale: haw), that does not set short to a string but to an object -> map manually
//    val short: String,
    val short: JsonNode,

    @JsonProperty("full-alt-ascii")
    val fullAscii: String? = null,
    @JsonProperty("long-alt-ascii")
    val longAscii: String? = null,
    @JsonProperty("medium-alt-ascii")
    val mediumAscii: String? = null,
    @JsonProperty("short-alt-ascii")
    val shortAscii: String? = null,

    @JsonProperty("full-alt-variant")
    val fullVariant: String? = null,
    @JsonProperty("long-alt-variant")
    val longVariant: String? = null,
    @JsonProperty("medium-alt-variant")
    val mediumVariant: String? = null,
    @JsonProperty("short-alt-variant")
    val shortVariant: String? = null
)