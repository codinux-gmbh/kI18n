package net.codinux.i18n.codegenerator

import net.codinux.i18n.LanguageTag
import net.codinux.i18n.parser.CldrJsonParser

class LanguageClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val englishLanguageNames = cldrJsonParser.parseLanguageNamesForLocale(LanguageTag.English)

        val languageProperties = englishLanguageNames.map { language ->
            util.createConstant(language.displayName, language.languageIsoCode)
        }

        util.writeClass("Language", languageProperties)
    }

}