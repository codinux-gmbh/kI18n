package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import net.codinux.collections.ImmutableMap
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.parser.CldrJsonParser

class AvailableLanguageTagsClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val availableLocales = cldrJsonParser.parseAvailableLocales()

        val immutableMapOfReference = MemberName("net.codinux.collections", "immutableMapOf")

        val availableLanguageTagsCodeBlock = CodeBlock.builder().apply {
            addStatement("%M(", immutableMapOfReference)

            availableLocales.forEach { locale ->
                addStatement("  %S to %T.parse(%S),", locale.tag, LanguageTag::class, locale.tag)
            }

            add(")")
        }

        val parameterizedType = ImmutableMap::class.parameterizedBy(String::class, LanguageTag::class)
        val availableLanguageTagsProperty = PropertySpec.builder("availableLanguageTags", parameterizedType)
            .initializer(availableLanguageTagsCodeBlock.build())
            .build()


        util.writeClass("AvailableLanguageTags", availableLanguageTagsProperty)
    }

}