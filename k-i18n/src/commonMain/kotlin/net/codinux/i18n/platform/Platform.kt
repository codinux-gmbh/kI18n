package net.codinux.i18n.platform

import net.codinux.i18n.LanguageTag

internal expect object Platform {

    val AvailableLocales: List<LanguageTag>

    fun getSystemLocale(): LanguageTag

}