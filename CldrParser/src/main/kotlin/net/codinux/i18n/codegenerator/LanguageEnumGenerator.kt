package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.model.LanguageDisplayNames
import net.codinux.i18n.parser.CldrJsonParser

class LanguageEnumGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val englishLanguageNames = cldrJsonParser.parseLanguageNamesForLocale(LanguageTag.parse("en")).toMutableList()

        // there are some languages for that no English name has been specified, also add these:
        englishLanguageNames.addAll(getLanguageCodesForWhichNoEnglishNameHasBeenSet(englishLanguageNames))

        val constructor = FunSpec.constructorBuilder()
            .addParameter("isoCode", String::class, false, "Lowercase alpha-2 two-letter or alpha-3 three-letter ISO 639 language code.")
            .build()


        val enumConstants = englishLanguageNames.sortedBy { it.languageIsoCode }.map { language ->
            language.displayName to TypeSpec.anonymousClassBuilder()
                    .addSuperclassConstructorParameter("%S", language.languageIsoCode).build()
        }

        util.writeEnumClass("Language", enumConstants, constructor)
    }

    private fun getLanguageCodesForWhichNoEnglishNameHasBeenSet(englishLanguageNames: List<LanguageDisplayNames>): List<LanguageDisplayNames> {
        val allLanguageTags = cldrJsonParser.parseAvailableLocalesAsString()
        val allLanguages = allLanguageTags.map { it.split('-').first() }.toSet()

        val englishLanguageNamesCodes = englishLanguageNames.map { it.languageIsoCode }.toSet()
        val notInLanguageNames = allLanguages.toMutableSet().also { it.removeAll(englishLanguageNamesCodes) }

        return notInLanguageNames.map { LanguageDisplayNames(it, getEnglishDisplayNameForLanguageCode(it)) }
    }

    private fun getEnglishDisplayNameForLanguageCode(languageCode: String): String = when (languageCode) {
        "apc" -> "Levantine Arabic"
        "lld" -> "Ladin"
        "mhn" -> "Mòcheno"
        "skr" -> "Saraiki"
        else -> languageCode
    }

}