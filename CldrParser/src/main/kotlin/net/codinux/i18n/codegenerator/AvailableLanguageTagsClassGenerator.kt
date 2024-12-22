package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import net.codinux.collections.ImmutableMap
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.parser.CldrJsonParser
import net.codinux.i18n.service.FileSystemUtil

class AvailableLanguageTagsClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val availableLanguageTags = cldrJsonParser.parseAvailableLocalesAsString()

        val availableLanguageTagsCodeBlock = CodeBlock.builder().apply {
            addStatement("%M(", ClassGeneratorUtil.immutableMapOfReference)

            availableLanguageTags.forEach { languageTag ->
                addStatement("  %S to %T.parse(%S),", languageTag, LanguageTag::class, languageTag)
            }

            add(")")
        }

        val parameterizedType = ImmutableMap::class.parameterizedBy(String::class, LanguageTag::class)
        val availableLanguageTagsProperty = PropertySpec.builder("availableLanguageTags", parameterizedType)
            .initializer(availableLanguageTagsCodeBlock.build())
            .build()


        util.writeClass("AvailableLanguageTags", availableLanguageTagsProperty, modifiers = listOf(KModifier.INTERNAL), projectFolder = FileSystemUtil.determineKI18nProjectPath())
    }

}