package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonProperty
import net.codinux.i18n.Region
import java.time.Instant

class ScriptMetadataFile(
    val scriptMetadata: Map<String, ScriptMetadata>
) {
    override fun toString() = "$scriptMetadata"
}

class ScriptMetadata(
    val rank: Int,
    val age: ScriptMetadataAge,
    val sampleChar: String, // cannot be mapped to Char as it contains more than 1-character Strings
    val idUsage: String,
    rtl: String,
    lbLetters: String,
    hasCase: String,
    val shapingReq: String,
    ime: String,
    val density: Int,
    originCountry: String,
    val likelyLanguage: String // values like "Aghb" cannot be mapped to Language enum
) {
    val rtl: Boolean = rtl.equals("YES", true)
    val lbLetters: Boolean = lbLetters.equals("YES", true)
    val hasCase: Boolean = hasCase.equals("YES", true)
    val ime: Boolean = ime.equals("YES", true)

    val originCountry: Region = Region.entries.first { it.code == originCountry }

    override fun toString() = "$originCountry $likelyLanguage $sampleChar ${age.version}"
}

class ScriptMetadataAge(
    @JsonProperty("m_version_")
    val version: Instant
)