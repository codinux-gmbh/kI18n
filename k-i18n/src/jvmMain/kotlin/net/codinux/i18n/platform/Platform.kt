package net.codinux.i18n.platform

import net.codinux.collections.toImmutableList
import net.codinux.i18n.LanguageTag

internal actual object Platform {

    private val AvailableJavaLocales by lazy { java.util.Locale.getAvailableLocales() }

    actual val AvailableLocales: List<LanguageTag> by lazy {
        AvailableJavaLocales
            .map { mapLocale(it) }
            .toImmutableList()
    }

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