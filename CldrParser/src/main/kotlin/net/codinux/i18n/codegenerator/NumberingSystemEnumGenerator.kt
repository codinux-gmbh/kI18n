package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import net.codinux.i18n.NumberingSystemType
import net.codinux.i18n.model.NumberingSystem
import net.codinux.i18n.parser.CldrJsonParser

fun main() {
    NumberingSystemEnumGenerator().generate()
}

class NumberingSystemEnumGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val numberingSystems = cldrJsonParser.parseNumberingSystems()

        val constructor = FunSpec.constructorBuilder()
            .addParameter("code", String::class, false, "The four-letter lowercase code of this numbering system.")
            .addParameter("type", NumberingSystemType::class, false, "The type of this numbering system (numeric or algorithmic).")
            .addParameter("digits", String::class, true, "The digits that this numbering system has.")
            .addParameter("rules", String::class, true)
            .build()


        val enumConstants = numberingSystems.map { numberingSystem ->
            createEnumConstant(numberingSystem)
        }

        util.writeEnumClass("NumberingSystem", enumConstants, constructor, "Defines all Numbering Systems known to CLDR.")
    }

    private fun createEnumConstant(numberingSystem: NumberingSystem): Pair<String, TypeSpec> {
        return numberingSystem.code to TypeSpec.anonymousClassBuilder()
            .addSuperclassConstructorParameter("%S", numberingSystem.code)
            .addNullableSuperclassConstructorParameter(numberingSystem.type)
            .addNullableSuperclassConstructorParameter(numberingSystem.digits)
            .addNullableSuperclassConstructorParameter(numberingSystem.rules)
            .build()
    }

}