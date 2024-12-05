package net.codinux.i18n.parser

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import net.codinux.i18n.model.AvailableLocales
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

open class CldrJsonParser(
    protected open val cldrJsonBaseDir: Path = determineDefaultCldrJsonBasePath(),
    protected open val objectMapper: ObjectMapper = ObjectMapper().apply {
        findAndRegisterModules()
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }
) {

    companion object {

        fun determineDefaultCldrJsonBasePath(): Path {
            val currentDir = Path(".").absolutePathString()
            val index = currentDir.indexOf("/src/main/").takeIf { it > 0 }
                ?: currentDir.indexOf("/build/").takeIf { it > 0 }
                ?: currentDir.indexOf("/CldrParser/.").takeIf { it > 0 }?.plus("/CldrParser/".length)

            if (index ==  null) {
                throw IllegalStateException("Could not find base directory of '<project_root>/cldr-json' submodule, please specify it explicitly")
            }

            return Path(currentDir.substring(0, index)).parent.resolve("cldr-json")
        }

    }


    fun parseAvailableLocales(): AvailableLocales =
        objectMapper.readValue(resolvePath("cldr-core/availableLocales.json"), AvailableLocales::class.java)


    protected open fun resolvePath(subPath: String): File =
        cldrJsonBaseDir.resolve("cldr-json").resolve(subPath).toFile()

}