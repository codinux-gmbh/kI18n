package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import net.codinux.i18n.model.LanguageTag
import net.codinux.i18n.parser.CldrJsonParser
import net.codinux.i18n.service.FileSystemUtil
import java.text.Normalizer

class LanguageClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser()
) {

    fun generate() {
        val englishLanguageNames = cldrJsonParser.parseLanguageNamesForLocale(LanguageTag("en"))

        val languageProperties = englishLanguageNames.languages.map { language ->
            PropertySpec.builder(getKotlinFriendlyVariableName(language.value.displayName), String::class, KModifier.CONST)
                .initializer("%S", language.key)
                .build()
        }

        val file = FileSpec.builder("net.codinux.i18n", "Language")
            .addType(
                TypeSpec.classBuilder("Language")
                    .addType(
                        TypeSpec.companionObjectBuilder()
                            .addProperties(languageProperties)
                            .build()
                    ).build()
            ).build()

        val baseDirectory = FileSystemUtil.determineKI18nProjectPath().resolve("src/commonMain/kotlin/")
//        file.writeTo(baseDirectory) // writes "public " before each class, method and property
        file.removePublicModifiersAndWriteTo(baseDirectory)
    }

    private fun getKotlinFriendlyVariableName(displayName: String): String =
        Normalizer.normalize(displayName, Normalizer.Form.NFD) // Normalizer removes accents
            .filter { it.isLetter() } // filter out characters like whitespaces, -, ', (, ), ...
}