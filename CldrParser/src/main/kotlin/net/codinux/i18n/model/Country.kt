package net.codinux.i18n.model

/**
 * In ISO 3166-1 there are three different codes for country names:
 * - alpha-2
 * - alpha-3
 * - numeric
 *
 * `alpha-2` two-letter country codes are "most prominently for the Internet's country code top-level
 * domains (with a few exceptions). They are also used as country identifiers extending the postal
 * code when appropriate within the international postal system for paper mail."
 *
 * `alpha-3` three-letter country codes "allow a better visual association between the codes and the
 * country names than the alpha-2 codes. They represent countries, dependent territories, and special
 * areas of geographical interest. (...) They are used most prominently in ISO/IEC 7501-1 for
 * machine-readable passports."
 *
 * ISO 3166-1 `numeric` codes are three-digit country codes that originate from
 * [UN M.49](https://en.wikipedia.org/wiki/UN_M.49) standard, with the advantage of script (writing system)
 * independence, and hence useful for people or systems using non-Latin scripts such as Arabic or Chinese.
 *
 * The UN M.49 contains also codes for geographical and political regions like a continent and therefore
 * allow for hierarchical mapping of regions.
 */
data class Country(
    /**
     * alpha-2 two-letter country codes are "most prominently for the Internet's country code top-level
     * domains (with a few exceptions). They are also used as country identifiers extending the postal
     * code when appropriate within the international postal system for paper mail."
     */
    val alpha2Code: String?,

    /**
     * alpha-3 three-letter country codes "allow a better visual association between the codes and the
     * country names than the alpha-2 codes. They represent countries, dependent territories, and special
     * areas of geographical interest. (...) They are used most prominently in ISO/IEC 7501-1 for
     * machine-readable passports."
     */
    val alpha3Code: String?,

    /**
     * ISO 3166-1 `numeric` codes are three-digit country codes that originate from
     * [UN M.49](https://en.wikipedia.org/wiki/UN_M.49) standard, with the advantage of script (writing system)
     * independence, and hence useful for people or systems using non-Latin scripts such as Arabic or Chinese.
     *
     * The UN M.49 contains also codes for geographical and political regions like a continent and therefore
     * allow for hierarchical mapping of regions.
     */
    val numeric: Int?
) {
    override fun toString() = "${alpha3Code ?: alpha2Code}${numeric?.let { " ($it)" } ?: ""}"
}