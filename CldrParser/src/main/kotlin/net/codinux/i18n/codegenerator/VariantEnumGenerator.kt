package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.model.VariantDisplayName
import net.codinux.i18n.parser.CldrJsonParser

class VariantEnumGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        // TODO: may also parse variant values from IANA-language-subtag-registry.txt and CLDR variant validity.xml, see docs folder

        val locales = cldrJsonParser.getLocalesWithLocalizedVariantDisplayNames().map { LanguageTag.ofAvailable(it) }
        val allVariantDisplayNames = locales.map { it to cldrJsonParser.parseVariantDisplayNamesForLocale(it) }
        val allVariantCodes = allVariantDisplayNames.flatMap { it.second }.map { it.code.lowercase() }.toSet().sorted()


        val englishVariantNames = cldrJsonParser.parseVariantDisplayNamesForLocale(LanguageTag.English)
        val englishVariantNamesByCode = englishVariantNames.associateBy { it.code }

        val constructor = FunSpec.constructorBuilder()
            .addParameter("code", String::class, false, CodeKdoc)
            .addParameter("englishName", String::class, true, "English name of the variant.")
            .build()


        val enumConstants = allVariantCodes.map { variantCode ->
            createEnumConstant(variantCode, englishVariantNamesByCode[variantCode])
        }

        util.writeEnumClass("Variant", enumConstants, constructor, "Defines all Variants known to CLDR.")
    }

    private fun createEnumConstant(variantCode: String, variantEnglishDisplayName: VariantDisplayName?): Pair<String, TypeSpec> {
        return variantCode to TypeSpec.anonymousClassBuilder()
            .addSuperclassConstructorParameter("%S", variantCode)
            .addNullableSuperclassConstructorParameter(variantEnglishDisplayName?.displayName)
            .build()
    }


    companion object {
        private val CodeKdoc = """
            The variant code, five to eight lowercase letters, or four characters starting with a digit.
            
            Or in [BCP 47](https://www.rfc-editor.org/rfc/bcp/bcp47.txt) notation:
             variant       = 5*8alphanum         ; registered variants
               / (DIGIT 3alphanum)
        """.trimIndent()
    }

}