package net.codinux.i18n.platform

import net.codinux.i18n.LanguageTag

internal actual object Platform {

    actual val AvailableLocales: List<LanguageTag> =
        AppleLocale.AvailableLocales

    actual fun getSystemLocale(): LanguageTag =
        AppleLocale.getDeviceLocale()

    fun setSystemLocale(language: LanguageTag) {
        val locale = NSLocale(identifier: language.tag)
        UserDefaults.standard.set([languageCode], forKey: "AppleLanguages")
        UserDefaults.standard.synchronize()
        // Re-load your UI elements after changing the locale.
    }

}