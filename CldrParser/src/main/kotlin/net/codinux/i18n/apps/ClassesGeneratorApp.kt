package net.codinux.i18n.apps

import net.codinux.i18n.codegenerator.AvailableLanguageTagsClassGenerator
import net.codinux.i18n.codegenerator.CountryClassGenerator
import net.codinux.i18n.codegenerator.LanguageClassGenerator
import net.codinux.i18n.codegenerator.RegionClassGenerator

fun main() {
    ClassesGeneratorApp().generate()
}

class ClassesGeneratorApp {

    fun generate() {
        LanguageClassGenerator().generate()

        CountryClassGenerator().generate()

        RegionClassGenerator().generate()

        AvailableLanguageTagsClassGenerator().generate()
    }

}