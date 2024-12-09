package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import net.codinux.i18n.service.FileSystemUtil
import java.nio.file.Path
import java.text.Normalizer

open class ClassGeneratorUtil {


    open fun createConstant(constantName: String, value: String) =
        PropertySpec.builder(getKotlinFriendlyVariableName(constantName), String::class, KModifier.CONST)
            .initializer("%S", value)
            .build()


    open fun getKotlinFriendlyVariableName(displayName: String): String =
        Normalizer.normalize(displayName, Normalizer.Form.NFD) // Normalizer removes accents
            .filter { it.isLetter() } // filter out characters like whitespaces, -, ', (, ), ...


    open fun writeClass(className: String, vararg companionObjectProperties: PropertySpec, companionObjectMethods: List<FunSpec> = emptyList(), modifiers: Collection<KModifier> = emptyList(), projectFolder: Path = FileSystemUtil.determineKI18nDataProjectPath()) =
        writeClass(className, companionObjectProperties.toList(), companionObjectMethods, modifiers, projectFolder)

    open fun writeClass(className: String, companionObjectProperties: Collection<PropertySpec> = emptyList(), companionObjectMethods: Collection<FunSpec> = emptyList(), modifiers: Collection<KModifier> = emptyList(), projectFolder: Path = FileSystemUtil.determineKI18nDataProjectPath()) {
        val file = FileSpec.builder("net.codinux.i18n", className)
            .addType(
                TypeSpec.objectBuilder(className).apply {
                    addModifiers(*modifiers.toTypedArray())
                    addFunctions(companionObjectMethods)
                    addProperties(companionObjectProperties)
                }.build()
            ).build()

        val baseDirectory = projectFolder.resolve("src/commonMain/kotlin/")
//        file.writeTo(baseDirectory) // writes "public " before each class, method and property
        file.removePublicModifiersAndWriteTo(baseDirectory)
    }

}