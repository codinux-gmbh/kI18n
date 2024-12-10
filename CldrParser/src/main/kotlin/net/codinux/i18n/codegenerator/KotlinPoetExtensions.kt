package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import java.nio.file.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.writeText

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