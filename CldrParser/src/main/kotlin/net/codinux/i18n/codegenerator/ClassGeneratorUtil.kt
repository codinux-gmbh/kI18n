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
            .toTitleCase()
            .filter { it.isLetter() && it != 'ʼ' } // filter out characters like whitespaces, -, ', (, ), ...; don't know why 'ʼ' gets treated as letter

    // it's not a real to title case converter but one adjusted for the specific needs of creating Kotlin property names
    private fun String.toTitleCase(): String =
        this.split(' ', '-', '_', '.', '(')
            .joinToString("") { it.replaceFirstChar { char -> char.uppercase() } }
// actually:
//    this.split(' ')
//        .joinToString(" ") { it.lowercase().replaceFirstChar { char -> char.uppercase() } }


    open fun writeClass(className: String, vararg companionObjectProperties: PropertySpec, companionObjectMethods: List<FunSpec> = emptyList(), modifiers: Collection<KModifier> = emptyList(), projectFolder: Path = FileSystemUtil.determineKI18nDataProjectPath()) =
        writeClass(className, companionObjectProperties.toList(), companionObjectMethods, modifiers, projectFolder)

    open fun writeClass(className: String, companionObjectProperties: Collection<PropertySpec> = emptyList(), companionObjectMethods: Collection<FunSpec> = emptyList(), modifiers: Collection<KModifier> = emptyList(), projectFolder: Path = FileSystemUtil.determineKI18nDataProjectPath()) {
        val type = TypeSpec.objectBuilder(className).apply {
            addModifiers(*modifiers.toTypedArray())
            addFunctions(companionObjectMethods)
            addProperties(companionObjectProperties)
        }.build()

        writeToFile(className, type, projectFolder)
    }


    open fun writeEnumClass(enumName: String, enumConstants: List<String>, kdoc: String? = null, projectFolder: Path = FileSystemUtil.determineKI18nDataProjectPath()) =
        writeEnumClass(enumName, enumConstants.map { Pair(it, TypeSpec.Companion.anonymousClassBuilder().build()) }, null, kdoc, projectFolder)

    open fun writeEnumClass(enumName: String, enumConstants: List<Pair<String, TypeSpec>>, constructor: FunSpec? = null, kdoc: String? = null, projectFolder: Path = FileSystemUtil.determineKI18nDataProjectPath()) {
        val type = TypeSpec.enumBuilder(enumName).apply {
            if (kdoc != null) {
                addKdoc(kdoc)
            }

            if (constructor != null) {
                primaryConstructor(constructor)
            }

            enumConstants.forEach { constant ->
                addEnumConstant(getKotlinFriendlyVariableName(constant.first), constant.second)
            }
        }.build()

        writeToFile(enumName, type, projectFolder) { code ->
            var result = code

            if (constructor != null) {
                constructor.parameters.forEach { parameter ->
                    // don't know why but Kotlin Poet leaves away the 'val' specifier of Enum class constructor parameter, so add it manually
                    result = result.replace("${parameter.name}: ", "val ${parameter.name}: ")
                }
            }

            result
        }
    }


    open fun writeToFile(fileName: String, type: TypeSpec, projectFolder: Path = FileSystemUtil.determineKI18nDataProjectPath(), adjustGeneratedCode: ((String) -> String)? = null) {
        val file = FileSpec.builder("net.codinux.i18n", fileName)
            .addType(type)
            .build()

        val baseDirectory = projectFolder.resolve("src/commonMain/kotlin/")
//        file.writeTo(baseDirectory) // writes "public " before each class, method and property
        file.removePublicModifiersAndWriteTo(baseDirectory, adjustGeneratedCode)
    }

}