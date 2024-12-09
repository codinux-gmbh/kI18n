package net.codinux.i18n.service

import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.absolute
import kotlin.io.path.absolutePathString
import kotlin.io.path.exists

object FileSystemUtil {

    fun determineCldrJsonBasePath() = determineProjectPath("cldr-json")

    fun determineKI18nProjectPath() = determineProjectPath("k-i18n")

    fun determineKI18nDataProjectPath() = determineProjectPath("k-i18n-data")

    private fun determineProjectPath(projectName: String): Path {
        determineRootProjectPath()?.let {
            return it.resolve(projectName)
        }

        throw IllegalStateException("Could not find base directory of '<project_root>/$projectName' submodule, please specify it explicitly")
    }

    fun determineRootProjectPath(): Path? {
        // try to find "cldr-json" project folder. If found, take its base path
        val currentDir = Path(".").absolutePathString()
        val index = currentDir.indexOf("/src/main/").takeIf { it > 0 }
            ?: currentDir.indexOf("/build/").takeIf { it > 0 }
            ?: currentDir.indexOf("/CldrParser/.").takeIf { it > 0 }?.plus("/CldrParser/".length)

        if (index != null) {
            val rootProjectPath = Path(currentDir.substring(0, index)).parent
            if (rootProjectPath.resolve("cldr-json").exists()) {
                return rootProjectPath
            }
        }

        val fromBaseDir = Path("").absolute().resolve("cldr-json")
        if (fromBaseDir.exists() && fromBaseDir.resolve("cldr-json").exists()) {
            return fromBaseDir.parent
        }

        return null
    }

}