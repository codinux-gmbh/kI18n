package net.codinux.i18n.model

data class LikelySubtagsFile(
    val supplemental: LikelySubtagsSupplemental
)

data class LikelySubtagsSupplemental(
    val likelySubtags: Map<String, String>
)