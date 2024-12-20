package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty

data class DateAndTimeFormats(
    val months: AllDisplayNames<MonthDisplayNames>,
    val days: AllDisplayNames<DayDisplayNames>,
    val quarters: AllDisplayNames<QuarterDisplayNames>,
    val dayPeriods: AllDisplayNames<DayPeriodDisplayNames>,
    val eras: AllEraDisplayNames,

    val dateFormats: DateOrTimeFormats,
    /**
     * The datetimeSkeleton element contains a skeleton (see availableFormats) derived from the pattern. In the future
     * the intent is to be able to generate the standard patterns from these datetimeSkeleton elements. However, in
     * CLDR 40, the mechanisms associated with the availableFormats elements are not quite powerful enough to generate
     * patterns that exactly match all of the ones provided in the pattern elements.
     *
     * The id attribute is a so-called "skeleton", containing only field information, and in a canonical order.
     * Examples are "yMMMM" for year + full month, or "MMMd" for abbreviated month + day.
     * Only one field of each type is allowed; that is, "Hh" is not valid.
     */
    val dateSkeletons: DateOrTimeFormats,
    val timeFormats: DateOrTimeFormats,
    val timeSkeletons: DateOrTimeFormats,
    val dateTimeFormats: DateTimeFormats,
    val dateTimeFormatsAtTime: DateTimeFormatsAtTime
)

data class MonthDisplayNames(
    // this name mappings are only valid for gregorian calendar. Other calendars also may have more months
    @JsonProperty("1")
    val january: String,
    @JsonProperty("2")
    val february: String,
    @JsonProperty("3")
    val march: String,
    @JsonProperty("4")
    val april: String,
    @JsonProperty("5")
    val may: String,
    @JsonProperty("6")
    val june: String,
    @JsonProperty("7")
    val july: String,
    @JsonProperty("8")
    val august: String,
    @JsonProperty("9")
    val september: String,
    @JsonProperty("10")
    val october: String,
    @JsonProperty("11")
    val november: String,
    @JsonProperty("12")
    val december: String
)

data class DayDisplayNames(
    // this name mappings are only valid for gregorian calendar. Other calendars may also have more or less days
    @JsonProperty("sun")
    val sunday: String,
    @JsonProperty("mon")
    val monday: String,
    @JsonProperty("tue")
    val tuesday: String,
    @JsonProperty("wed")
    val wednesday: String,
    @JsonProperty("thu")
    val thursday: String,
    @JsonProperty("fri")
    val friday: String,
    @JsonProperty("sat")
    val saturday: String
)

data class QuarterDisplayNames(
    @JsonProperty("1")
    val first: String,
    @JsonProperty("2")
    val second: String,
    @JsonProperty("3")
    val third: String,
    @JsonProperty("4")
    val fourth: String
)

data class DayPeriodDisplayNames(
    val am: String,
    val pm: String,
    @JsonProperty("am-alt-variant")
    val amVariant: String? = null,
    @JsonProperty("pm-alt-variant")
    val pmVariant: String? = null,
    val midnight: String? = null,
    val noon: String? = null,
    val morning1: String? = null,
    val morning2: String? = null,
    val afternoon1: String? = null,
    val afternoon2: String? = null,
    val evening1: String? = null,
    val evening2: String? = null,
    val night1: String? = null,
    val night2: String? = null
)

data class AllDisplayNames<T>(
    val format: DisplayNameSet<T>,
    @JsonProperty("stand-alone")
    val standAlone: DisplayNameSet<T>
)

data class DisplayNameSet<T>(
    val wide: T,
    val abbreviated: T,
    val narrow: T,

    val short: T? = null, // only set for days
)

data class AllEraDisplayNames(
    @JsonProperty("eraNames")
    val names: EraDisplayNames,
    @JsonProperty("eraAbbr")
    val abbreviated: EraDisplayNames,
    @JsonProperty("eraNarrow")
    val narrow: EraDisplayNames
)

data class EraDisplayNames(
    // for definition of codes see cldr-core/supplemental/calendarData.json key "gregorian"
    // -> so this codes ("0", "1") with this meaning are only valid for gregorian calendar!
    @JsonProperty("0")
    val gregoryInverse: String,
    /**
     * For era elements, an additional alt="variant" form may be supplied. This is primarily intended for use in the
     * "gregorian" calendar, with which two parallel sets of era designations are used in some locales: one set with a
     * religious reference (e.g. English BC/AD), and one set without (e.g. English BCE/CE). The most commonly-used set
     * for the locale should be provided as the default, and the other set may be provided as the alt="variant" forms.
     */
    @JsonProperty("0-alt-variant")
    val gregoryInverseVariant: String,
    @JsonProperty("1")
    val gregory: String,
    /**
     * For era elements, an additional alt="variant" form may be supplied. This is primarily intended for use in the
     * "gregorian" calendar, with which two parallel sets of era designations are used in some locales: one set with a
     * religious reference (e.g. English BC/AD), and one set without (e.g. English BCE/CE). The most commonly-used set
     * for the locale should be provided as the default, and the other set may be provided as the alt="variant" forms.
     */
    @JsonProperty("1-alt-variant")
    val gregoryVariant: String,
)

data class DateTimeFormatsAtTime(
    val standard: DateOrTimeFormats
)

class DateOrTimeFormats(
    full: String,
    long: String,
    medium: String,
    short: String,

    /**
     * For day periods, ASCII variants for AM/PM such as “am”, “a.m.”, “am.” (and their case variants) should be
     * accepted, since they are widely used as alternates to native formats.
     */
    val fullAscii: String? = null,
    val longAscii: String? = null,
    val mediumAscii: String? = null,
    val shortAscii: String? = null,

    val fullVariant: String? = null,
    val longVariant: String? = null,
    val mediumVariant: String? = null,
    val shortVariant: String? = null
) : net.codinux.i18n.datetime.DateOrTimeFormats(full, long, medium, short)

class DateTimeFormats(
    full: String,
    long: String,
    medium: String,
    short: String,

    val availableFormats: Map<String, String> = emptyMap(),

    val appendItems: Map<String, String> = emptyMap(),

    val intervalFormats: IntervalFormats
) : net.codinux.i18n.datetime.DateOrTimeFormats(full, long, medium, short)

data class IntervalFormats(
    val intervalFormatFallback: String,

    @JsonAnySetter
    val formats: Map<String, Map<String, String>> = emptyMap(),
)
