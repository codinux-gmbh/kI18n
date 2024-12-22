package net.codinux.i18n.apps

import net.codinux.i18n.codegenerator.*

fun main() {
    ClassesGeneratorApp().generate()
}

class ClassesGeneratorApp {

    fun generate() {
        AvailableLanguageTagsClassGenerator().generate()

        ParentLocalesClassGenerator().generate()


        LanguageEnumGenerator().generate()

        RegionEnumGenerator().generate()

        ScriptEnumGenerator().generate()

        VariantEnumGenerator().generate()

        CurrencyEnumGenerator().generate()

        UnitEnumGenerator().generate()

        NumberingSystemEnumGenerator().generate()


        LanguageDisplayNamesClassGenerator().generate()

        RegionDisplayNamesClassGenerator().generate()

        CurrencyDisplayNamesClassGenerator().generate()


        AvailableNumberFormatsClassGenerator().generate()

        AllLocalizedDateTimeFormatsClassGenerator().generate()

        AvailableDateTimeDisplayNamesClassGenerator().generate()
    }

}