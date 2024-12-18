package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import net.codinux.collections.ImmutableMap
import net.codinux.i18n.LanguageTag
import net.codinux.i18n.parser.CldrJsonParser
import net.codinux.i18n.service.FileSystemUtil

class ParentLocalesClassGenerator(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser(),
    private val util: ClassGeneratorUtil = ClassGeneratorUtil()
) {

    fun generate() {
        val parentLocales = cldrJsonParser.parseParentLocales()

        val immutableMapOfReference = MemberName("net.codinux.collections", "immutableMapOf")

        val parentLocalesCodeBlock = CodeBlock.builder().apply {
            addStatement("%M(", immutableMapOfReference)

            parentLocales.forEach { (parent, child) ->
                addStatement("  %S to %T.parse(%S),", parent, LanguageTag::class, LanguageTag.parse(child))
            }

            add(")")
        }

        val parameterizedType = ImmutableMap::class.parameterizedBy(String::class, LanguageTag::class)
        val parentLocalesProperty = PropertySpec.builder("parentLocales", parameterizedType)
            .initializer(parentLocalesCodeBlock.build())
            .build()


        util.writeClass("ParentLocales", parentLocalesProperty, modifiers = listOf(KModifier.INTERNAL), projectFolder = FileSystemUtil.determineKI18nProjectPath())
    }

}