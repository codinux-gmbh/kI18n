package net.codinux.i18n.codegenerator

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import net.codinux.i18n.service.FileSystemUtil
import java.text.Normalizer

open class ClassGeneratorUtil {


    open fun createConstant(constantName: String, value: String) =
        PropertySpec.builder(getKotlinFriendlyVariableName(constantName), String::class, KModifier.CONST)
            .initializer("%S", value)
            .build()



    open fun getKotlinFriendlyVariableName(displayName: String): String =
        Normalizer.normalize(displayName, Normalizer.Form.NFD) // Normalizer removes accents
            .filter { it.isLetter() } // filter out characters like whitespaces, -, ', (, ), ...

    fun writeClass(className: String, companionObjectProperties: Collection<PropertySpec>) {
        val file = FileSpec.builder("net.codinux.i18n", className)
            .addType(
                TypeSpec.objectBuilder(className)
                    .addProperties(companionObjectProperties)
                    .build()
            ).build()

        val baseDirectory = FileSystemUtil.determineKI18nProjectPath().resolve("src/commonMain/kotlin/")
//        file.writeTo(baseDirectory) // writes "public " before each class, method and property
        file.removePublicModifiersAndWriteTo(baseDirectory)
    }

}