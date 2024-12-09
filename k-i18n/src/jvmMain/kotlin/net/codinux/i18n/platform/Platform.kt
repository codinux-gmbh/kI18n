package net.codinux.i18n.platform

import net.codinux.i18n.LanguageTag

actual object Platform {

    actual fun getSystemLocale(): LanguageTag {
        val jvmLocale = java.util.Locale.getDefault()

        return mapLocale(jvmLocale)
    }

    private fun mapLocale(jvmLocale: java.util.Locale) = LanguageTag(
        jvmLocale.toLanguageTag(),
        jvmLocale.language,
        jvmLocale.country,
        jvmLocale.script.takeIf { it.isNotBlank() },
        jvmLocale.variant.takeIf { it.isNotBlank() }
    )

}