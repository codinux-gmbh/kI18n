package net.codinux.i18n.apps

import net.codinux.i18n.codegenerator.LanguageClassGenerator

fun main() {
    ClassesGeneratorApp().generate()
}

class ClassesGeneratorApp {

    fun generate() {
        LanguageClassGenerator().generate()
    }

}