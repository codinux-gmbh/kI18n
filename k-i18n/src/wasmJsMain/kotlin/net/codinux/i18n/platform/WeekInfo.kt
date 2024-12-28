package net.codinux.i18n.platform

external class WeekInfo {

    /**
     * An integer indicating the first day of the week for the locale. Can be either 1 (Monday) or 7 (Sunday).
     */
    val firstDay: Int

    /**
     * An array of integers indicating the weekend days for the locale, where 1 is Monday and 7 is Sunday.
     */
    val weekend: Int

    /**
     * An integer between 1 and 7 indicating the minimal days required in the first week of a month or year, for calendar purposes.
     */
    val minimalDays: Int

}