package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.NumberingSystem
import net.codinux.i18n.NumberingSystemType
import net.codinux.i18n.parser.CldrJsonParser

class NumberingSystemEnumGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val numberingSystems = cldrJsonParser.parseNumberingSystems()

        val englishNames = cldrJsonParser.parseLocaleDisplayNamesForLocale(LanguageTag.English)
        val englishNamesByCode = englishNames.numberingSystems

        val constructor = FunSpec.constructorBuilder()
            .addParameter("code", String::class, false, "The lowercase code of this numbering system.")
            .addParameter("type", NumberingSystemType::class, false, "The type of this numbering system (numeric or algorithmic).")
            .addParameter("digits", String::class, true, "The digits that this numbering system has.")
            .addParameter("rules", String::class, true)
            .addParameter("englishName", String::class, true)
            .build()


        // method to get a NumberingSystem enum value by NumberingSystem code
        val getNumberingSystemForCode = FunSpec.builder("forCode")
            .addParameter("code", String::class)
            .returns(NumberingSystem::class)
            .addStatement("return %T.entries.first { it.code == code }", NumberingSystem::class)
            .build()


        val enumConstants = numberingSystems.map { numberingSystem ->
            createEnumConstant(numberingSystem, englishNamesByCode[numberingSystem.code])
        }.sortedBy { it.first } // sort by display name

        util.writeEnumClass("NumberingSystem", enumConstants, constructor, "Defines all Numbering Systems known to CLDR.", listOf(getNumberingSystemForCode))
    }

    private fun createEnumConstant(numberingSystem: net.codinux.i18n.model.NumberingSystem, displayName: String?): Pair<String, TypeSpec> {
        return (displayName ?: numberingSystem.code) to TypeSpec.anonymousClassBuilder()
            .addSuperclassConstructorParameter("%S", numberingSystem.code)
            .addNullableSuperclassConstructorParameter(numberingSystem.type)
            .addNullableSuperclassConstructorParameter(numberingSystem.digits)
            .addNullableSuperclassConstructorParameter(numberingSystem.rules)
            .addNullableSuperclassConstructorParameter(displayName)
            .build()
    }

}