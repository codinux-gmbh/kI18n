package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.parser.CldrJsonParser

class LanguageEnumGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val englishLanguageNames = cldrJsonParser.parseLanguageNamesForLocale(LanguageTag.English)

        val constructor = FunSpec.constructorBuilder()
            .addParameter("isoCode", String::class, false, "Lowercase alpha-2 two-letter or alpha-3 three-letter ISO 639 language code.")
            .build()


        val enumConstants = englishLanguageNames.map { language ->
            language.displayName to TypeSpec.anonymousClassBuilder()
                    .addSuperclassConstructorParameter("%S", language.languageIsoCode).build()
        }

        util.writeEnumClass("Language", enumConstants, constructor)
    }

}