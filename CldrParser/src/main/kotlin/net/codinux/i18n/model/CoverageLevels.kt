package net.codinux.i18n.model

class CoverageLevels(
    val coverageLevels: Map<String, String>,
    val effectiveCoverageLevels: Map<String, String>
) {
    override fun toString() = "$coverageLevels"
}