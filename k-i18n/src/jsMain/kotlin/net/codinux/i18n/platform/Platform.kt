package net.codinux.i18n.platform

import net.codinux.collections.toImmutableList
import net.codinux.i18n.LanguageTag
import net.codinux.log.logger

actual object Platform {

    private val log by logger()


    // JavaScript has no method to get all supported Locales. So use that ones from
    // LanguageTag.availableLanguageTagsAsString and see which of them Intl.Locale can instantiate
    actual val AvailableLocales: List<LanguageTag> by lazy {
        LanguageTag.availableLanguageTagsAsString
            .mapNotNull { getLocaleForLanguageTag(it) }
            .toImmutableList()
    }


    actual fun getSystemLocale(): LanguageTag {
        val localeString = js("Intl.NumberFormat().resolvedOptions().locale") as String

        return getLocaleForLanguageTag(localeString)!!
    }

    private fun getLocaleForLanguageTag(languageTag: String) = getIntlLocaleForLanguageTag(languageTag)?.let { locale ->
        LanguageTag(languageTag, locale.language, locale.region, locale.script)
    }

    private fun getIntlLocaleForLanguageTag(languageTag: String): IntlLocale? {
        return try {
            eval("new Intl.Locale(\"$languageTag\")").unsafeCast<IntlLocale?>()
        } catch (e: Throwable) {
            log.error(e) { "Could not get locale for languageTag '$languageTag'" }
            null
        }
    }

}