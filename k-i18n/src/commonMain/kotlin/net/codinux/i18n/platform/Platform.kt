package net.codinux.i18n.platform

import net.codinux.i18n.LanguageTag

expect object Platform {

    fun getSystemLocale(): LanguageTag

}