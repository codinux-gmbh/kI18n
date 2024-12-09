package net.codinux.i18n.apps

import net.codinux.i18n.codegenerator.*

fun main() {
    ClassesGeneratorApp().generate()
}

class ClassesGeneratorApp {

    fun generate() {
        LanguageClassGenerator().generate()

        CountryClassGenerator().generate()

        RegionClassGenerator().generate()

        AvailableLanguageTagsClassGenerator().generate()

        RegionDisplayNamesClassGenerator().generate()
    }

}