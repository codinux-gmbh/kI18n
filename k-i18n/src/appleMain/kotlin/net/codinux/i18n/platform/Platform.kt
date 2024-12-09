package net.codinux.i18n.platform

import net.codinux.i18n.LanguageTag

internal actual object Platform {

    actual val AvailableLocales: List<LanguageTag> =
        AppleLocale.AvailableLocales

    actual fun getSystemLocale(): LanguageTag =
        AppleLocale.getDeviceLocale()

}