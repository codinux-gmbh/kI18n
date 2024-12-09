package net.codinux.i18n.codegenerator

import net.codinux.i18n.LanguageTag
import net.codinux.i18n.parser.CldrJsonParser

class LanguageClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val englishLanguageNames = cldrJsonParser.parseLanguageNamesForLocale(LanguageTag.ofAvailable("en"))

        val languageProperties = englishLanguageNames.languages.map { language ->
            util.createConstant(language.value.displayName, language.key)
        }

        util.writeClass("Language", languageProperties)
    }

}