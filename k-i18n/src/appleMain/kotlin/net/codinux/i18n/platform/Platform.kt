package net.codinux.i18n.platform

import net.codinux.i18n.LanguageTag
import platform.Foundation.*

internal actual object Platform {

    actual val AvailableLocales: List<LanguageTag> =
        AppleLocale.AvailableLocales

    actual fun getSystemLocale(): LanguageTag =
        AppleLocale.getDeviceLocale()

    fun setSystemLocale(language: LanguageTag) {
        // TODO: this code compiles but it doesn't work
        val locale = NSLocale(localeIdentifier = language.tag)
        NSUserDefaults.standardUserDefaults.setObject(NSArray.arrayWithArray(listOf(locale.localeIdentifier)), "AppleLanguages")
//        NSUserDefaults.standardUserDefaults.setValue(NSArray.arrayWithArray(listOf(locale.localeIdentifier)), forKey = "AppleLanguages")
        NSUserDefaults.standardUserDefaults.synchronize()
        // Re-load your UI elements after changing the locale.
    }

}