package net.codinux.i18n.codegenerator

import net.codinux.i18n.LanguageTag
import net.codinux.i18n.parser.CldrJsonParser

class RegionClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val englishRegionNames = cldrJsonParser.parseCountryNamesForLocale(LanguageTag.English)

        val regionProperties = englishRegionNames
            .map { region ->
                util.createConstant(region.displayName, region.territoryCode)
            }

        util.writeClass("Region", regionProperties)
    }

}