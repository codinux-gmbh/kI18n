package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeSpec
import net.codinux.i18n.Language
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.Script
import net.codinux.i18n.model.Region
import net.codinux.i18n.model.TerritoryDisplayNames
import net.codinux.i18n.parser.CldrJsonParser
import net.codinux.i18n.service.LikelySubtagsCategorizer

class RegionEnumGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val regionCodeMappings = cldrJsonParser.parseRegionCodeMappings()
        val allRegionsByCode = regionCodeMappings.associateBy { it.code }

        val territorialContainment = cldrJsonParser.parseTerritoryContainment()
        val territorialContainmentByCode = territorialContainment.mapValues { it.value.contains }

        val englishRegionNames = cldrJsonParser.parseRegionNamesForLocale(LanguageTag.English)

        val defaultLanguagesAndScripts = LikelySubtagsCategorizer(cldrJsonParser).getDefaultLanguageAndScriptForAllRegions()
            .mapKeys { it.key.code }

        val constructor = FunSpec.constructorBuilder()
            .addParameter("code", String::class, false, "Either alpha-2 tor alpha-3 ISO code or numeric UN M.49 code.")
            .addParameter("alpha2Code", String::class, true, Alpha2CodeKdoc)
            .addParameter("alpha3Code", String::class, true, Alpha3CodeKdoc)
            .addParameter("numericCode", Int::class, true, NumericCodeKdoc)
            .addParameter("numericCodeAsString", String::class, true, "The value of [numericCode] as String, padded with zero to three digits.")
            .addParameter("englishName", String::class, false, "English name of the country or region.")
            .addParameter("variantName", String::class, true, "Optional a variant of the English name of the country or region (if available).")
            .addParameter("defaultLanguage", Language::class, true, "Region's default language.")
            .addParameter("defaultScript", Script::class, true, "Region's default script (writing system).")
            .addParameter("isContainedIn", List::class.parameterizedBy(String::class), false, "A list of regions this region is contained in.")
            .addParameter("contains", List::class.parameterizedBy(String::class), false, "A list of region this region contains.")
            .build()


        val enumConstants = englishRegionNames.map { regionName ->
            createEnumConstant(regionName, allRegionsByCode[regionName.territoryCode], territorialContainmentByCode, defaultLanguagesAndScripts[regionName.territoryCode])
        }

        util.writeEnumClass("Region", enumConstants, constructor, EnumKdoc)
    }

    private fun createEnumConstant(regionName: TerritoryDisplayNames, region: Region?, territorialContainment: Map<String, List<String>>,
                                   defaultLanguageAndScript: Pair<Language, Script>?): Pair<String, TypeSpec> {
        val code = regionName.territoryCode
        val alpha2Code = region?.alpha2Code ?: if (code.length == 2) code else null
        val alpha3Code = region?.alpha3Code ?: if (code.length == 3 && code.all { it.isLetter() }) code else null
        val numeric = region?.numeric ?: if (code.length == 3 && code.all { it.isDigit() }) code.toInt() else null

        val isContainedIn = territorialContainment.filter { it.value.contains(code) }.map { it.key }.sorted()

        return fixEnumConstantName(regionName) to TypeSpec.anonymousClassBuilder()
            .addSuperclassConstructorParameter("%S", code)
            .addNullableSuperclassConstructorParameter(alpha2Code)
            .addNullableSuperclassConstructorParameter(alpha3Code)
            .addNullableSuperclassConstructorParameter(numeric)
            .addNullableSuperclassConstructorParameter(numeric?.toString()?.padStart(3, '0'))
            .addNullableSuperclassConstructorParameter(regionName.displayName)
            .addNullableSuperclassConstructorParameter(regionName.shortDisplayName ?: regionName.variantDisplayName)
            .addNullableSuperclassConstructorParameter(defaultLanguageAndScript?.first)
            .addNullableSuperclassConstructorParameter(defaultLanguageAndScript?.second)
            .addNullableSuperclassConstructorParameter(isContainedIn)
            .addNullableSuperclassConstructorParameter(territorialContainment[code] ?: emptyList<String>())
            .build()
    }

    private fun fixEnumConstantName(regionName: TerritoryDisplayNames): String =
        when (regionName.territoryCode) {
            "HK", "MO", "PS" -> regionName.shortDisplayName!!

            else -> when (regionName.displayName) {
                "world" -> "World"
                "Congo - Kinshasa" -> "Congo_DemocraticRepublic"
                "Congo - Brazzaville" -> "Congo"
                // "CotedIvoire" -> "CoteDIvoire"
                "Isle of Man" -> "IsleOfMan"
                "Tristan da Cunha" -> "TristanDaCunha"
                else -> {
                    regionName.displayName.replace("&", "And").replace("St. ", "Saint")
                }
            }
        }


    companion object {
        
        private val EnumKdoc = """
             Please note, the list includes not only countries but also:
             - Geographical regions such as [World], [EasternAfrica] or [Antarctica],
             - Supranational unions (alliances) such as the [UnitedNations], [EuropeanUnion] or [Eurozone],
             - Sub-national territories of countries such as [SaintHelena] or [SouthGeorgiaAndSouthSandwichIslands].
        """.trimIndent()

        private val Alpha2CodeKdoc = """
            alpha-2 two-letter country codes are "most prominently for the Internet's country code top-level
            domains (with a few exceptions). They are also used as country identifiers extending the postal
            code when appropriate within the international postal system for paper mail."
     
            User-assigned codes are: AA, QM to QZ, XA to XZ, and ZZ.
            These can be freely used and will never be part of the standard.
        """.trimIndent()

        private val Alpha3CodeKdoc = """
             alpha-3 three-letter country codes "allow a better visual association between the codes and the
             country names than the alpha-2 codes. They represent countries, dependent territories, and special
             areas of geographical interest. (...) They are used most prominently in ISO/IEC 7501-1 for
             machine-readable passports."
            
             User-assigned codes are: AAA to AAZ, QMA to QZZ, XAA to XZZ, and ZZA to ZZZ.
             These can be freely used and will never be part of the standard.
        """.trimIndent()

        private val NumericCodeKdoc = """
             ISO 3166-1 `numeric` codes are three-digit country codes that originate from
             [UN M.49](https://en.wikipedia.org/wiki/UN_M.49) standard, with the advantage of script (writing system)
             independence, and hence useful for people or systems using non-Latin scripts such as Arabic or Chinese.
            
             The UN M.49 contains also codes for geographical and political regions like a continent and therefore
             allow for hierarchical mapping of regions.
            
             User-assigned codes range from 900 to 999. These are reserved for users to add custom geographical names 
             in their applications and will never be used by the ISO 3166 standard.
        """.trimIndent()

    }

}