package net.codinux.i18n.platform

external class IntlLocale {

    /**
     * Returns the language associated with the locale.
     */
    val language: String

    /**
     * Returns the region of the world (usually a country) associated with the locale.
     */
    val region: String?

    /**
     * Returns the script used for writing the particular language used in the locale.
     */
    val script: String?

    /**
     * Returns basic, core information about the Locale in the form of a substring of the complete data string.
     */
    val baseName: String

    /**
     * Returns the numeral system used by the locale.
     *
     * In most cases null, use [numberingSystems] on system supporting it.
     */
    val numberingSystem: String?

    /**
     * Returns whether the locale has special collation handling for numeric characters.
     */
    val numeric: Boolean

    /**
     * Returns the part of the Locale that indicates the Locale's calendar era.
     *
     * In most cases null, use [calendars] on system supporting it.
     */
    val calendar: String?

    /**
     * Returns the time keeping format convention used by the locale.
     *
     * In most cases null, use [hourCycles] on system supporting it.
     *
     * Returns the hour cycle identifier, indicating either the 12-hour clock ("h12"),
     * the Japanese 12-hour clock ("h11"), the 24-hour clock ("h23"), or the unused format "h24".
     */
    val hourCycle: String?

    /**
     * Returns the collation type for the Locale, which is used to order strings according to the locale's rules.
     *
     * In most cases null, use [collations] on system supporting it.
     */
    val collation: String?

    /**
     * Returns whether case is taken into account for the locale's collation rules.
     *
     * Returns either "upper", "lower", or false (= No special case ordering)
     */
    val caseFirst: String?

//    /**
//     * Returns the part indicating the ordering of characters ltr (left-to-right) or rtl (right-to-left).
//     *
//     * Not available on Firefox and Safari.
//     */
//    val textInfos: Array<String>?
//
//    /**
//     * Returns an Array of numbering system identifiers available according to the locale's rules.
//     *
//     * Not available on Firefox and Safari.
//     */
//    val numberingSystems: Array<String>?
//
//    /**
//     * Returns an Array of available calendar identifiers, according to the locale's rules.
//     *
//     * Not available on Firefox and Safari.
//     */
//    val calendars: Array<String>?
//
//    /**
//     * Returns UTS 35's Week Elements according to the locale rules.
//     *
//     * Not available on Firefox and Safari.
//     */
//    val weekInfo: WeekInfo?
//
//    /**
//     * Returns UTS 35's Week Elements according to the locale rules.
//     *
//     * Not available on Firefox and Safari.
//     */
//    fun getWeekInfo(): WeekInfo?

//    /**
//     * Returns an Array of time zone identifiers, associated with the Locale.
//     *
//     * Not available on Firefox and Safari.
//     */
//    val timeZones: Array<String>?
//
//    /**
//     * Returns an Array of hour cycle identifiers, indicating either the 12-hour format ("h11", "h12") or the 24-hour format ("h23", "h24").
//     *
//     * Not available on Firefox and Safari.
//     */
//    val hourCycles: Array<String>?
//
//    /**
//     * Returns an Array of the collation types for the Locale.
//     *
//     * Not available on Firefox and Safari.
//     */
//    val collations: Array<String>?

    /**
     * Gets the most likely values for the language, script, and region of the locale based on existing values.
     *
     * Not available on Firefox and Safari.
     */
    fun maximize(): String?

    /**
     * Attempts to remove information about the locale that would be added by calling maximize().
     *
     * Not available on Firefox and Safari.
     */
    fun minimize(): String?

    override fun toString(): String

}