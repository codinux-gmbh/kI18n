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
            .map { mapToUtilLocale(it) }
            .toImmutableList()
    }

    fun getDeviceLocale(): LanguageTag =
        mapToUtilLocale(NSLocale.currentLocale) // this returns the Device language

    fun getAppLanguage(): String? =
        NSLocale.preferredLanguages().firstOrNull() as? String
            ?: NSBundle.mainBundle().preferredLocalizations().firstOrNull() as? String

    fun nsLocaleForLocale(locale: LanguageTag): NSLocale? =
        nsLocaleForLanguageTag(locale.tag)
            ?: nsLocaleForLanguageTag("${locale.languageCode}_${locale.regionCode}")

    fun nsLocaleForLanguageTag(languageTag: String): NSLocale? =
        AvailableNSLocales.firstOrNull { it.localeIdentifier == languageTag }

    private fun mapToUtilLocale(locale: NSLocale) =
        LanguageTag(locale.localeIdentifier, locale.languageCode, locale.countryCode ?: "", locale.scriptCode, locale.variantCode)

}