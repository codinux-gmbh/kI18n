package net.codinux.i18n.platform

import net.codinux.collections.toImmutableList
import net.codinux.i18n.LanguageTag
import net.codinux.log.logger

fun getCurrentLocale(): String =
    js("Intl.NumberFormat().resolvedOptions().locale")

fun getIntlLocaleForLanguageTag(languageTag: String): IntlLocale? =
    js("new Intl.Locale(languageTag)")

internal actual object Platform {

    private val log by logger()


    // JavaScript has no method to get all supported Locales. So use that ones from
    // LanguageTag.availableLanguageTagsAsString and see which of them Intl.Locale can instantiate
    actual val AvailableLocales: List<LanguageTag> by lazy {
        LanguageTag.availableLanguageTagsAsString
            .mapNotNull { getLocaleForLanguageTag(it) }
            .toImmutableList()
    }

    actual fun getSystemLocale(): LanguageTag {
        val localeString = getCurrentLocale()

        return LanguageTag.parse(localeString)
    }

    private fun getLocaleForLanguageTag(languageTag: String) = getIntlLocaleForLanguageTagSafe(languageTag)?.let { locale ->
        LanguageTag(languageTag, locale.language, locale.region, locale.script)
    }

    private fun getIntlLocaleForLanguageTagSafe(languageTag: String): IntlLocale? {
        return try {
            getIntlLocaleForLanguageTag(languageTag)
        } catch (e: Throwable) {
            log.error(e) { "Could not get locale for languageTag '$languageTag'" }
            null
        }
    }

}