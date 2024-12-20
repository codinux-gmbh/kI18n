package net.codinux.i18n.model

import net.codinux.i18n.LanguageTag
import net.codinux.i18n.datetime.HourStyle

/**
 * This element is for data that indicates, for various regions, the preferred time cycle in the region, as well as all
 * time cycles that are considered acceptable in the region.
 *
 * The defaults are those specified for region 001.
 *
 * The allowed values are in preference order, and are used with the 'C' hour skeleton pattern symbol.
 *
 * The B and b date symbols provide for formats like “3:00 at night”. When the ‘C’ option is used, the values in allowed
 * are traversed from first to last, picking the first available format. For example, in the following a system that
 * supports hB should choose that as the most preferred format for the C (not the preferred value H).
 *
 * Some systems may not want to use B and b, even if preferred for the locale, so for compatibility the preferred value
 * is limited to {H, h, K, k}, and is the option selected by the ‘j’ date symbol. Thus the preferred value may not be
 * the same as the first allowed value.
 *
 * The preferred value for the locale can be overridden by the locale keyword "hc", see Unicode Hour Cycle Identifier .
 */
data class PreferredHourStyle(
    val locale: LanguageTag,
    val preferred: HourStyle,
    val allowed: List<HourStyle>
) {
    override fun toString() = "$locale $preferred (${allowed.joinToString()})"
}