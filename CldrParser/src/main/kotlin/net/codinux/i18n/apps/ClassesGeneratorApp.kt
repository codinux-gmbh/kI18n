package net.codinux.i18n.apps

import net.codinux.i18n.codegenerator.CountryClassGenerator
import net.codinux.i18n.codegenerator.LanguageClassGenerator

fun main() {
    ClassesGeneratorApp().generate()
}

class ClassesGeneratorApp {

    fun generate() {
        LanguageClassGenerator().generate()

        CountryClassGenerator().generate()
    }

}