package net.codinux.i18n.datetime

import net.codinux.i18n.LanguageTag

/**
 * An evaluation of all gregorian default date time formats in CLDR (not regarding dateTimeFormats.availableFormats and .intervalFormats):
 * - Only a few contain G, none, GG, GGG, GGGG or GGGGG (era)
 * - None contained u (Extended year (numeric))
 * - None contained U (cyclic year name)
 * - None contained r (Related Gregorian year (numeric))
 * - None contained Q+ (Quarter)
 * - None contained q+ (Quarter Stand-alone)
 * - None contained MMMMM (month narrow)
 * - None contained L+ (month Stand-alone)
 * - None contained w (Week of year)
 * - None contained W (Week of month)
 * - None contained D+ (day of year)
 * - None contained F (day of week in month)
 * - None contained g+ (Modified Julian day (numeric))
 * - None contained EEEEE+ (Day of week name narrow and short)
 * - None contained e (local day of week)
 * - Only three contained cccc, none c, cc, ccc, ccccc or cccccc (local day of week Stand-alone)
 * - None contained aa+, only a (AM, PM)
 * - None contained b (am, pm, noon, midnight)
 * - 8 contained B, none BB+ (flexible day periods; but it's up to application if these are supported or not)
 * - None contained k, K, j, J, C (obvious by definition / regarded formats)
 * - None contained A (Milliseconds in a day (numeric))
 * - None contained Z, O, v, V, X, x (zone information)
 */
class DateTimeFormatter(
    private val formatsResolver: LocalizedDateTimeFormatsResolver = LocalizedDateTimeFormatsResolver(),
    private val displayNamesResolver: DateTimeDisplayNamesResolver = DateTimeDisplayNamesResolver()
) {

    fun formatDate(date: LocalDate, style: FormatStyle, locale: LanguageTag = LanguageTag.current): String {
        val formats = formatsResolver.getDateTimeFormatsForLocale(locale)

        return formatDate(date, selectFormat(formats.dateFormats, style), locale)
    }

    /**
     * Locale is only needed for localized month and day names
     */
    fun formatDate(date: LocalDate, format: DateTimeFormat, locale: LanguageTag = LanguageTag.current) =
        formatDate(date, format.dateFormat, locale)

    /**
     * Locale is only needed for localized month and day names
     */
    fun formatDate(date: LocalDate, formatPattern: String, locale: LanguageTag = LanguageTag.current): String {
        val pattern = parsePattern(formatPattern)

        var formatted = pattern.pattern

        if (pattern.yearMinLength != null) {
            var year = date.year.toString().padStart(pattern.yearMinLength, '0')
            if (pattern.yearMaxLength != null) {
                year = year.substring(year.length - pattern.yearMaxLength)
            }

            formatted = formatted.replace("y".repeat(pattern.yearMinLength), year)
        }

        if (pattern.monthStyle != null) {
            val month = when (pattern.monthStyle) {
                MonthStyle.NumericMinDigits -> date.month.toString()
                MonthStyle.Numeric2Digits -> date.month.toString().padStart(2, '0')
                MonthStyle.Abbreviated -> getMonthNames(locale).abbreviated.getMonth(date)
                MonthStyle.Wide -> getMonthNames(locale).wide.getMonth(date)
                MonthStyle.Narrow -> getMonthNames(locale).narrow.getMonth(date)
            }

            formatted = formatted.replace("M".repeat(pattern.monthFormatFieldsLength), month)
        }

        // cannot support this yet as don't know how to get the week day from date
//        if (pattern.weekDayStyle != null) {
//            val weekDay = when (pattern.weekDayStyle) {
//                WeekDayStyle.Abbreviated -> getDayNames(locale).abbreviated.getDay(date)
//                WeekDayStyle.Wide -> getDayNames(locale).wide.getDay(date)
//                WeekDayStyle.Narrow -> getDayNames(locale).narrow.getDay(date)
//                WeekDayStyle.Short -> getDayNames(locale).short?.getDay(date)
//            }
//
//            formatted = formatted.replace("E".repeat(pattern.weekDayFormatFieldsLength), weekDay)
//        }

        if (pattern.dayMinLength != null) {
            val day = date.dayOfMonth.toString().padStart(pattern.dayMinLength, '0')

            formatted = formatted.replace("d".repeat(pattern.dayMinLength), day)
        }

        return formatted
    }


    fun formatTime(time: LocalTime, style: FormatStyle, locale: LanguageTag = LanguageTag.current): String {
        val formats = formatsResolver.getDateTimeFormatsForLocale(locale)

        return formatTime(time, selectFormat(formats.timeFormats, style), locale)
    }

    /**
     * Locale is only needed for localized period names (AM, PM, Midnight, Noon).
     */
    fun formatTime(time: LocalTime, format: DateTimeFormat, locale: LanguageTag = LanguageTag.current) =
        formatTime(time, format.dateFormat, locale)

    /**
     * Locale is only needed for localized period (AM, PM, Midnight, Noon) and time zone names.
     */
    fun formatTime(time: LocalTime, formatPattern: String, locale: LanguageTag = LanguageTag.current): String {
        val pattern = parsePattern(formatPattern)

        var formatted = pattern.pattern

        if (pattern.hourStyle != null) {
            val (hour, hourPattern) = when (pattern.hourStyle) {
                // TODO: append am, pm
                HourStyle.TwelveHourStart1, HourStyle.TwelveHourStart1_NoonAndMidght, HourStyle.TwelveHourStart1_FlexibleDayPeriods
                    -> (if (time.hour == 0 || time.hour == 12) 12 else time.hour % 12).toString() to "h"
                HourStyle.TwentyFourHourStart0 -> time.hour.toString() to "H"
                HourStyle.TwelveHourStart0 -> (time.hour % 12).toString() to "K"
                HourStyle.TwentyFourHourStart1 -> (if (time.hour == 0) 24 else time.hour).toString() to "k"
            }

            formatted = formatted.replace(hourPattern.repeat(pattern.hourMinLength), hour.padStart(pattern.hourMinLength, '0'))
        }

        if (pattern.minuteMinLength != null) {
            val minute = time.minute.toString().padStart(pattern.minuteMinLength, '0')

            formatted = formatted.replace("m".repeat(pattern.minuteMinLength), minute)
        }

        if (pattern.secondMinLength != null) {
            val second = time.second.toString().padStart(pattern.secondMinLength, '0')

            formatted = formatted.replace("s".repeat(pattern.secondMinLength), second)
        }

        if (pattern.fractionalSecondLength != null) {
            val fractionalSecond = time.nanosecondOfSecond.toString().padStart(pattern.fractionalSecondLength, '0')
                .substring(0, pattern.fractionalSecondLength)

            formatted = formatted.replace("S".repeat(pattern.fractionalSecondLength), fractionalSecond)
        }

        if (pattern.dayPeriodStyle != null) {
            val dayPeriod = when (pattern.dayPeriodStyle) {
                DateFieldWidth.Abbreviated -> getDayPeriodNames(locale).abbreviated.getDayPeriod(time, pattern.alsoFormatNoonAndMidnight)
                DateFieldWidth.Wide -> getDayPeriodNames(locale).wide.getDayPeriod(time, pattern.alsoFormatNoonAndMidnight)
                DateFieldWidth.Narrow -> getDayPeriodNames(locale).narrow.getDayPeriod(time, pattern.alsoFormatNoonAndMidnight)
            }

            formatted = formatted.replace((if (pattern.alsoFormatNoonAndMidnight) "b" else "a").repeat(pattern.dayPeriodFormatFieldsLength), dayPeriod)
        }

        return formatted
    }


    private fun getMonthNames(locale: LanguageTag) =
        getDisplayNames(locale).months

    private fun getDayNames(locale: LanguageTag) =
        getDisplayNames(locale).days

    private fun getQuarterNames(locale: LanguageTag) =
        getDisplayNames(locale).quarters

    private fun getDayPeriodNames(locale: LanguageTag) =
        getDisplayNames(locale).dayPeriods

    private fun getDisplayNames(locale: LanguageTag): DateTimeDisplayNames {
        val displayNames = displayNamesResolver.getLocalizedFormatDisplayNames(locale)
        if (displayNames == null) {
            throw IllegalArgumentException("Localized date time names not found for locale '$locale' or its parents. Are you sure this locale exists?")
        }

        return displayNames
    }


    /**
     * All date time format fields are documented here:
     * [https://www.unicode.org/reports/tr35/tr35-73/tr35-dates.html#date-format-patterns](https://www.unicode.org/reports/tr35/tr35-73/tr35-dates.html#date-format-patterns)
     * The table with the field symbols is a bit below that:
     * [https://www.unicode.org/reports/tr35/tr35-73/tr35-dates.html#table-date-field-symbol-table](https://www.unicode.org/reports/tr35/tr35-73/tr35-dates.html#table-date-field-symbol-table)
     */
    private fun parsePattern(formatPattern: String): DateTimeFormatPattern {
        // TODO: handle masked characters

        // TODO: also handle Y, u, U and r
        val yearLength = formatPattern.count { it == 'y' }
        val yearMinLength = yearLength.takeUnless { it == 0 }
        val yearMaxLength = if (yearLength == 2) 2 else null

        // TODO: also handle L
        val monthLength = formatPattern.count { it == 'M' }
        val monthStyle = when (monthLength) {
            1 -> MonthStyle.NumericMinDigits
            2 -> MonthStyle.Numeric2Digits
            3 -> MonthStyle.Abbreviated
            4 -> MonthStyle.Wide
            5 -> MonthStyle.Narrow
            else -> null // TODO: that's not full correct, only valid for 0 (the only remaining valid value); not specified for count 'M' > 5
        }

        // TODO: also handle e and c
        val weekDayLength = formatPattern.count { it == 'E' }
        val weekDayStyle = when (weekDayLength) {
            1, 2, 3 -> WeekDayStyle.Abbreviated
            4 -> WeekDayStyle.Wide
            5 -> WeekDayStyle.Narrow
            6 -> WeekDayStyle.Short
            else -> null // TODO: that's not full correct, only valid for 0 (the only remaining valid value); not specified for count 'E' > 6
        }

        // TODO: also handle D, F and g
        val dayLength = formatPattern.count { it == 'd' }
        val dayMinLength = dayLength.takeIf { it in 1..2 }

        // there's also B, but it's optional and i decided not to support it
        val dayPeriodNoonMidnightLength = formatPattern.count { it == 'b' } // period including 'Noon' and 'Midnight'
        val dayPeriodLength = dayPeriodNoonMidnightLength.takeUnless { it == 0 } ?: formatPattern.count { it == 'a' } // default period: AM and PM
        val alsoFormatNoonAndMidnight = dayPeriodNoonMidnightLength > 0
        val dayPeriodStyle = when (dayPeriodLength) {
            1, 2, 3 -> DateFieldWidth.Abbreviated
            4 -> DateFieldWidth.Wide
            5 -> DateFieldWidth.Narrow
            else -> null // TODO: that's not full correct, only valid for 0 (the only remaining valid value); not specified for count 'a' and 'b > 5
        }

        // TODO: also handle quarter (Q, q) and week (w, W)

        // TODO: also handle period (a, b, B)

        // TODO: are j, J and C ever used?
        val twelveHoursOneBasedLength = formatPattern.count { it == 'h' }
        val twentyFourHoursZeroBasedLength = formatPattern.count { it == 'H' }
        val twelveHoursZeroBasedLength = formatPattern.count { it == 'K' }
        val twentyFourHoursOneBasedLength = formatPattern.count { it == 'k' }
        val (hourStyle, hourMinLength) = when {
            twelveHoursOneBasedLength != 0 -> HourStyle.TwelveHourStart1 to twelveHoursOneBasedLength
            twentyFourHoursZeroBasedLength != 0 -> HourStyle.TwentyFourHourStart0 to twentyFourHoursZeroBasedLength
            twelveHoursZeroBasedLength != 0 -> HourStyle.TwelveHourStart0 to twelveHoursZeroBasedLength
            twentyFourHoursOneBasedLength != 0 -> HourStyle.TwentyFourHourStart1 to twentyFourHoursOneBasedLength
            else -> null to 0
        }

        val minuteLength = formatPattern.count { it == 'm' }
        val minuteMinLength = minuteLength.takeIf { it in 1..2 }

        val secondLength = formatPattern.count { it == 's' }
        val secondMinLength = secondLength.takeIf { it in 1..2 }

        val fractionalSecondLength = formatPattern.count { it == 'S' }.takeUnless { it == 0 }

        // TODO: there's also A (millisconds in a day), but don't know if i ever will support that

        // TODO: also parse zone (z, Z, O, v, V, X)

        return DateTimeFormatPattern(
            formatPattern,
            yearMinLength, yearMaxLength, monthStyle, monthLength, weekDayStyle, weekDayLength, dayMinLength,
            dayPeriodStyle, dayPeriodLength, alsoFormatNoonAndMidnight,
            hourStyle, hourMinLength, minuteMinLength, secondMinLength, fractionalSecondLength
        )
    }


    private fun selectFormat(formats: DateOrTimeFormats, style: FormatStyle): String = when (style) {
        FormatStyle.Full -> formats.full
        FormatStyle.Long -> formats.long
        FormatStyle.Medium -> formats.medium
        FormatStyle.Short -> formats.short
    }

}