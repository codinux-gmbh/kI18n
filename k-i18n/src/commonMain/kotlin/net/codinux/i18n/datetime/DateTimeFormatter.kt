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
        val minDayLength = dayLength.takeIf { it in 1..2 }

        // TODO: also handle quarter (Q, q) and week (w, W), and week day (E, e, c

        return DateTimeFormatPattern(
            formatPattern,
            yearMinLength, yearMaxLength, monthStyle, minDayLength
        )
    }

}