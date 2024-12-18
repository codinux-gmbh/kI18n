package net.codinux.i18n.apps

import net.codinux.i18n.codegenerator.*

fun main() {
    ClassesGeneratorApp().generate()
}

class ClassesGeneratorApp {

    fun generate() {
        LanguageEnumGenerator().generate()

        RegionEnumGenerator().generate()

        AvailableLanguageTagsClassGenerator().generate()

        ParentLocalesClassGenerator().generate()

        LanguageDisplayNamesClassGenerator().generate()

        RegionDisplayNamesClassGenerator().generate()

        ScriptEnumGenerator().generate()

        VariantEnumGenerator().generate()

        CurrencyDisplayNamesClassGenerator().generate()

        CurrencyEnumGenerator().generate()

        UnitEnumGenerator().generate()
    }

}