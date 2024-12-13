package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.*
import net.codinux.i18n.Region
import java.nio.file.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.writeText
import kotlin.reflect.KClass

// partially copied from FileSpec.writeTo(Path)
internal fun FileSpec.removePublicModifiersAndWriteTo(baseDirectory: Path, adjustGeneratedCode: ((String) -> String)? = null): Path {
    val stringBuilder = StringBuilder()
    this.writeTo(stringBuilder)

    val outputPath = baseDirectory.resolve(this.relativePath)
    outputPath.parent.createDirectories()

    val fileContentWithoutPublicModifier = stringBuilder.replace(Regex("public "), "")

    if (adjustGeneratedCode != null) {
        outputPath.writeText(adjustGeneratedCode(fileContentWithoutPublicModifier))
    } else {
        outputPath.writeText(fileContentWithoutPublicModifier)
    }

    return outputPath
}

internal fun FunSpec.Builder.addParameter(parameterName: String, type: KClass<*>, nullable: Boolean = false, kdoc: String? = null) =
    this.addParameter(parameterName, type.asTypeName(), nullable, kdoc)

internal fun FunSpec.Builder.addParameter(parameterName: String, type: TypeName, nullable: Boolean = false, kdoc: String? = null) =
    this.addParameter(
        ParameterSpec.builder(parameterName, type.copy(nullable = nullable)).apply {
            if (kdoc != null) {
                addKdoc(kdoc)
            }
        }.build()
    )

internal fun TypeSpec.Builder.addNullableSuperclassConstructorParameter(value: Any?) =
    if (value is String) this.addSuperclassConstructorParameter("%S", value)
    else if (value is Number) this.addSuperclassConstructorParameter("%L", value)
    else if (value is Region) this.addSuperclassConstructorParameter("Region.%L", value)
    else if (value is List<*>) this.addSuperclassConstructorParameter("%L", "listOf(${value.joinToString(", ") { "\"$it\"" } })")
    else this.addSuperclassConstructorParameter("%L", "null")

// other way: suppress warnings (but i think we can omit that)

internal fun FileSpec.Builder.suppressWarningTypes(vararg types: String): FileSpec.Builder {
    if (types.isNotEmpty()) {
        val format = "%S,".repeat(types.count()).trimEnd(',')
        addAnnotation(
            AnnotationSpec.builder(ClassName("", "Suppress"))
                .addMember(format, *types)
                .build()
        )
    }

    return this
}