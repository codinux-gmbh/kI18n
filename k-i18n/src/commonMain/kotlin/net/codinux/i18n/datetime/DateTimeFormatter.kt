package net.codinux.i18n.datetime

import net.codinux.i18n.LanguageTag

class DateTimeFormatter {

    fun formatDate(date: LocalDate, locale: LanguageTag = LanguageTag.current): String {
        // TODO: get DateTimeFormat from locale
        throw NotImplementedError("Retrieved DateTimeFormat from locale is not implemented yet.")
    }

    fun formatDate(date: LocalDate, format: DateTimeFormat) =
        formatDate(date, format.dateFormat)

    fun formatDate(date: LocalDate, formatPattern: String): String {
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
            val (month, count) = when (pattern.monthStyle) {
                MonthStyle.NumericMinDigits -> date.month.toString() to 1
                MonthStyle.Numeric2Digits -> date.month.toString().padStart(2, '0') to 2
                else -> "" to 0 // TODO: localized month name are not supported yet
            }

            formatted = formatted.replace("M".repeat(count), month)
        }

        if (pattern.dayMinLength != null) {
            val day = date.dayOfMonth.toString().padStart(pattern.dayMinLength, '0')

            formatted = formatted.replace("d".repeat(pattern.dayMinLength), day)
        }

        return formatted
    }


    fun formatTime(time: LocalTime, locale: LanguageTag = LanguageTag.current): String {
        // TODO: get DateTimeFormat from locale
        throw NotImplementedError("Retrieved DateTimeFormat from locale is not implemented yet.")
    }

    fun formatTime(time: LocalTime, format: DateTimeFormat) =
        formatTime(time, format.dateFormat)

    fun formatTime(time: LocalTime, formatPattern: String): String {
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

        return formatted
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

        // TODO: also handle D, F and g
        val dayLength = formatPattern.count { it == 'd' }
        val dayMinLength = dayLength.takeIf { it in 1..2 }

        // TODO: also handle quarter (Q, q) and week (w, W), and week day (E, e, c)

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
            yearMinLength, yearMaxLength, monthStyle, dayMinLength,
            hourStyle, hourMinLength, minuteMinLength, secondMinLength, fractionalSecondLength
        )
    }

}