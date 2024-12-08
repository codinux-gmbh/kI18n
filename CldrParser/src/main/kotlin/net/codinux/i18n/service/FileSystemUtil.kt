package net.codinux.i18n.service

import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString
import kotlin.io.path.exists

object FileSystemUtil {

    fun determineCldrJsonBasePath(): Path {
        val currentDir = Path(".").absolutePathString()
        val index = currentDir.indexOf("/src/main/").takeIf { it > 0 }
            ?: currentDir.indexOf("/build/").takeIf { it > 0 }
            ?: currentDir.indexOf("/CldrParser/.").takeIf { it > 0 }?.plus("/CldrParser/".length)

        if (index != null) {
            val cldrJsonPath = Path(currentDir.substring(0, index)).parent.resolve("cldr-json")
            if (cldrJsonPath.exists()) {
                return cldrJsonPath
            }
        }

        val fromBaseDir = Path("").resolve("cldr-json")
        if (fromBaseDir.exists() && fromBaseDir.resolve("cldr-json").exists()) {
            return fromBaseDir
        }

        throw IllegalStateException("Could not find base directory of '<project_root>/cldr-json' submodule, please specify it explicitly")
    }

}