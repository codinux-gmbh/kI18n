package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import net.codinux.i18n.model.UnEceUnitCodesRecommendation
import net.codinux.i18n.model.UnEceUnitCodesRecommendationStatus
import net.codinux.i18n.parser.CldrJsonParser
import net.codinux.i18n.parser.UnEceUnitCodesRecommendationListParser

class UnitEnumGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val unitFileParser: UnEceUnitCodesRecommendationListParser = UnEceUnitCodesRecommendationListParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        // ok, we cannot use all values, the enum then hits JVM's max method size limit of 64 KB:
        // org.jetbrains.org.objectweb.asm.MethodTooLargeException: Method too large: net/codinux/i18n/UnitAll.<clinit> ()V
        // -> filter out deprecated and deleted units and reduce properties size

        val recommendation20Units = unitFileParser.parseRecommendation20UnitCodesList()

        val recommendation21Units = unitFileParser.parseRecommendation21UnitCodesList()

        val all = recommendation20Units + recommendation21Units

        val unitsToUse = all.filter { it.status != UnEceUnitCodesRecommendationStatus.Deprecated && it.status != UnEceUnitCodesRecommendationStatus.MarkedAsDeleted }

        val grouped = unitsToUse.groupBy { it.code }

        // had to reduce the column size as otherwise enum hits JVM's max 64 KB per method limit
        val constructor = FunSpec.constructorBuilder()
            .addParameter("code", String::class, false, "The UN/ECE code of this unit from UN/ECE Recommendation Nº20 and Nº21 [https://unece.org/trade/uncefact/cl-recommendations](https://unece.org/trade/uncefact/cl-recommendations).")
            .addParameter("englishName", String::class, false, "English name of this unit.")
            .addParameter("symbol", String::class, true, "The symbol used to represent the unit of measure as in ISO 31 / 80000.")
//            .addParameter("conversionFactor", String::class, true, "The value used to convert units to the equivalent SI unit when applicable.")
            .addParameter("groupOrCategory", String::class, true)
//            .addParameter("status", String::class, true, "Status of this unit, e.g. 'Deprecated' or 'MarkedAsDeleted' (in most cases null otherwise).")
//            .addParameter("description", String::class, true, "English description of this unit.")
            .build()


        val enumConstants = grouped.toSortedMap().map { (code, unitsWithThisCode) ->
            createEnumConstant(code, unitsWithThisCode)
        }

        util.writeEnumClass("UnitAll", enumConstants, constructor)
    }

    private fun createEnumConstant(code: String, unitsWithThisCode: List<UnEceUnitCodesRecommendation>): Pair<String, TypeSpec> {
        val name = if (code.equals("NIL", true)) code + "_" else code // cannot use "NIL" as it's a key word on apple systems

        // there are 190 codes which's entries have different names and 143 with different descriptions. It's really hard to judge which one to pick
        val unit = unitsWithThisCode.firstOrNull { it.status != UnEceUnitCodesRecommendationStatus.Deprecated && it.status != UnEceUnitCodesRecommendationStatus.MarkedAsDeleted }
            ?: unitsWithThisCode.first()

        return name to TypeSpec.anonymousClassBuilder()
            .addSuperclassConstructorParameter("%S", unit.code)
            .addSuperclassConstructorParameter("%S", unit.name)
            .addNullableSuperclassConstructorParameter(unit.symbol)
//            .addNullableSuperclassConstructorParameter(unit.conversionFactor)
            .addNullableSuperclassConstructorParameter(unit.groupNumber ?: unit.levelOrCategory ?: unit.quantity ?: unit.sector)
//            .addNullableSuperclassConstructorParameter(unit.status)
//            .addNullableSuperclassConstructorParame./ter(unit.description)
            .build()
    }

}