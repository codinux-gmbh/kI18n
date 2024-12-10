package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.Region
import net.codinux.i18n.model.ScriptDisplayName
import net.codinux.i18n.model.ScriptMetadata
import net.codinux.i18n.parser.CldrJsonParser

class ScriptEnumGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val englishScriptNames = cldrJsonParser.parseScriptDisplayNamesForLocale(LanguageTag.English)

        val scriptMetadata = cldrJsonParser.parseScriptsMetadata()

        val constructor = FunSpec.constructorBuilder()
            .addParameter("code", String::class, false, IsoCodeKdoc)
            .addParameter("englishName", String::class, false, "English name of the script.")
            .addParameter("variantName", String::class, true, "Optional a variant of the English name of the script (if available).")
            .addParameter("originCountry", Region::class, true, "The origin region of the script, if available.")
            .build()


        val enumConstants = englishScriptNames.map { scriptName ->
            createEnumConstant(scriptName, scriptMetadata[scriptName.code])
        }

        util.writeEnumClass("Script", enumConstants, constructor, "Defines all Scripts (writing systems) known to CLDR.")
    }

    private fun createEnumConstant(scriptName: ScriptDisplayName, scriptMetadata: ScriptMetadata?): Pair<String, TypeSpec> {
        val code = scriptName.code

        return scriptName.displayName to TypeSpec.anonymousClassBuilder()
            .addSuperclassConstructorParameter("%S", code)
            .addNullableSuperclassConstructorParameter(scriptName.displayName)
            .addNullableSuperclassConstructorParameter(scriptName.shortDisplayName ?: scriptName.variantDisplayName)
            .addNullableSuperclassConstructorParameter(scriptMetadata?.originCountry)
            // TODO: may also add numeric ISO code from ISO 15924.csv
            .build()
    }


    companion object {

        private val IsoCodeKdoc = """
            Four-letter ISO 15924 code in title case.
            
             The codes 900–999 are special codes, aliases or for private use.
            
             Special codes:
             - Qaaa–Qabx (900–949): 50 Codes reserved for private use (for example, Qaag is used to mark Burmese text encoded for the Zawgyi font)
             - Zsye 993: Emoji
             - Zinh 994: Code for inherited script
             - Zmth 995: Mathematical notation
             - Zsym 996: Symbols
             - Zxxx 997: Code for unwritten documents
             - Zyyy 998: Code for undetermined script
             - Zzzz 999: Code for uncoded script
            
             Two four-letter codes are reserved at the request of the Common Locale Data Repository (CLDR) project:
             - Root: Reserved for the language-neutral base of the CLDR locale tree
             - True: Reserved for the Boolean value "true")
        """.trimIndent()

    }

}