package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeSpec
import net.codinux.i18n.model.UnitsMetadata
import net.codinux.i18n.parser.CldrJsonParser

class AvailableUnitDisplayNamesClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val metadata = cldrJsonParser.parseUnitsMetadata()
        // TODO: also parse unitPrefixes (atto, centi, kilo, ...)?
        // TODO: also parse unitConstants (some contain conversion factors e.g. from feet to meter)?
        generateUnitTypesEnum(metadata)
    }


    private fun generateUnitTypesEnum(metadata: UnitsMetadata) {
        val baseUnits = metadata.unitQuantities
        val unitTypes = baseUnits.map { it.unitType }.toSet().sorted()
        val convertUnitsByBaseUnit = metadata.convertUnits.groupBy({ it.baseUnit }, { it.name })

        val unitsByType = unitTypes.associateWith { type -> baseUnits.filter { it.unitType == type }.map { it.name }.let {
            (it + it.flatMap { convertUnitsByBaseUnit[it] ?: emptyList() }).toSet().sorted()
        } }


        val constructor = FunSpec.constructorBuilder()
            .addParameter("type", String::class, false)
            .addParameter("units", List::class.parameterizedBy(String::class), false)
            .build()

        val enumConstants = unitsByType.toSortedMap().mapNotNull { (type, unitsWithOfThisType) ->
            type to TypeSpec.anonymousClassBuilder()
                .addSuperclassConstructorParameter("%S", type)
                .addNullableSuperclassConstructorParameter(unitsWithOfThisType)
                .build()
        }


        util.writeEnumClass("UnitType", enumConstants, constructor, subPackage = "units")
    }

}