package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import net.codinux.collections.ImmutableMap
import net.codinux.i18n.service.FileSystemUtil
import java.nio.file.Path
import java.text.Normalizer

open class ClassGeneratorUtil {

    companion object {
        val immutableMapParameterizedType = ImmutableMap::class.parameterizedBy(String::class, String::class)

        val immutableMapOfReference = MemberName("net.codinux.collections", "immutableMapOf")
    }


    open fun createConstant(constantName: String, value: String) =
        PropertySpec.builder(getKotlinFriendlyVariableName(constantName), String::class, KModifier.CONST)
            .initializer("%S", value)
            .build()


    open fun getKotlinFriendlyVariableName(displayName: String): String =
        Normalizer.normalize(displayName, Normalizer.Form.NFD) // Normalizer removes accents
            .toTitleCase()
            .filter { (it.isLetterOrDigit() && it != 'ʼ') || it == '_' } // filter out characters like whitespaces, -, ', (, ), ...; don't know why 'ʼ' gets treated as letter
            .let {
                if (it[0].isDigit()) "_$it" // variable names may not start with a digit
                else it
            }

    // it's not a real to title case converter but one adjusted for the specific needs of creating Kotlin property names
    private fun String.toTitleCase(): String =
        this.split(' ', '-', '.', '(')
            .joinToString("") { it.replaceFirstChar { char -> char.uppercase() } }
// actually:
//    this.split(' ')
//        .joinToString(" ") { it.lowercase().replaceFirstChar { char -> char.uppercase() } }


    open fun writeClass(className: String, vararg companionObjectProperties: PropertySpec, companionObjectMethods: List<FunSpec> = emptyList(), modifiers: Collection<KModifier> = emptyList(), kdoc: String? = null, subPackage: String? = null, projectFolder: Path = FileSystemUtil.determineKI18nDataProjectPath()) =
        writeClass(className, companionObjectProperties.toList(), companionObjectMethods, modifiers, kdoc, subPackage, projectFolder)

    open fun writeClass(className: String, companionObjectProperties: Collection<PropertySpec> = emptyList(), companionObjectMethods: Collection<FunSpec> = emptyList(), modifiers: Collection<KModifier> = emptyList(), kdoc: String? = null, subPackage: String? = null, projectFolder: Path = FileSystemUtil.determineKI18nDataProjectPath()) {
        val type = TypeSpec.objectBuilder(className).apply {
            addModifiers(*modifiers.toTypedArray())
            addFunctions(companionObjectMethods)
            addProperties(companionObjectProperties)

            if (kdoc != null) {
                addKdoc(kdoc)
            }
        }.build()

        writeToFile(className, type, projectFolder, subPackage)
    }


    open fun writeEnumClass(enumName: String, enumConstants: List<Pair<String, TypeSpec>>, constructor: FunSpec? = null, kdoc: String? = null, companionObjectMethods: Collection<FunSpec> = emptyList(), properties: Collection<PropertySpec> = emptyList(), subPackage: String? = null, projectFolder: Path = FileSystemUtil.determineKI18nDataProjectPath()) {
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

            addProperties(properties)

            if (companionObjectMethods.isNotEmpty()) {
                addType(TypeSpec.companionObjectBuilder().addFunctions(companionObjectMethods).build())
            }
        }.build()

        writeToFile(enumName, type, projectFolder, subPackage) { code ->
            var result = code

            if (constructor != null) {
                constructor.parameters.forEach { parameter ->
                    // don't know why but Kotlin Poet leaves away the 'val' specifier of Enum class constructor parameter, so add it manually
                    // only replace first appearance to not also add 'val' to fun forCode(code: String)
                    result = result.replaceFirst("${parameter.name}: ", "val ${parameter.name}: ")
                }
            }

            result
        }
    }


    open fun writeToFile(fileName: String, type: TypeSpec, projectFolder: Path = FileSystemUtil.determineKI18nDataProjectPath(), subPackage: String? = null, adjustGeneratedCode: ((String) -> String)? = null) {
        val file = FileSpec.builder("net.codinux.i18n${subPackage?.let { ".$it" } ?: ""}", fileName)
            .addType(type)
            .build()

        val baseDirectory = projectFolder.resolve("src/commonMain/kotlin/")
//        file.writeTo(baseDirectory) // writes "public " before each class, method and property
        file.removePublicModifiersAndWriteTo(baseDirectory, adjustGeneratedCode)
    }

}