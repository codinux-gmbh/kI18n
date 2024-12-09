package net.codinux.i18n.codegenerator

import net.codinux.i18n.LanguageTag
import net.codinux.i18n.parser.CldrJsonParser

class CountryClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val englishCountryNames = cldrJsonParser.parseCountryNamesForLocale(LanguageTag.parse("en"))

        val countryProperties = englishCountryNames.territories
            .filter { it.key.all { it.isLetter() } } // filter out territories like 'World', 'Europe', ... which can be identified by that they have numeric codes
            .map { country ->
                util.createConstant(country.value.displayName, country.key)
            }

        util.writeClass("Country", countryProperties)
    }

}