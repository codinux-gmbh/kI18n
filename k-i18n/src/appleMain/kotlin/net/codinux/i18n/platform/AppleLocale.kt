package net.codinux.i18n.platform

import net.codinux.collections.toImmutableList
import net.codinux.i18n.LanguageTag
import platform.Foundation.*

object AppleLocale {

    private val AvailableNSLocales by lazy {
        NSLocale.availableLocaleIdentifiers()
            .filterIsInstance<String>()
            .map { NSLocale(it) }
    }

    val AvailableLocales: List<LanguageTag> by lazy {
        AvailableNSLocales
            .map { mapToLanguageTag(it) }
            .toImmutableList()
    }

    fun getDeviceLocale(): LanguageTag =
        mapToLanguageTag(NSLocale.currentLocale,  // NSLocale.currentLocale returns the Device locale with device default language, currency, ...
            // NSLocale.preferredLanguages() returns the languages the user has configured in Settings app -> apps should use this for display texts
            NSLocale.preferredLanguages().firstOrNull() as? String)

    fun getAppLanguage(): String? =
        NSLocale.preferredLanguages().firstOrNull() as? String
            ?: NSBundle.mainBundle().preferredLocalizations().firstOrNull() as? String

    fun nsLocaleForLocale(locale: LanguageTag): NSLocale? =
        nsLocaleForLanguageTag(locale.tag)
            ?: nsLocaleForLanguageTag("${locale.languageCode}_${locale.regionCode}")

    fun nsLocaleForLanguageTag(languageTag: String): NSLocale? =
        AvailableNSLocales.firstOrNull { it.localeIdentifier == languageTag }

    private fun mapToLanguageTag(locale: NSLocale, preferredLanguage: String? = null) =
        if (preferredLanguage != null) {
            LanguageTag(locale.localeIdentifier.replace(locale.languageCode, preferredLanguage), preferredLanguage, locale.countryCode ?: "", locale.scriptCode, locale.variantCode)
        } else {
            LanguageTag(locale.localeIdentifier, locale.languageCode, locale.countryCode ?: "", locale.scriptCode, locale.variantCode)
        }

}