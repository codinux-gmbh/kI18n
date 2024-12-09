package net.codinux.i18n.platform

import net.codinux.i18n.LanguageTag

actual object Platform {

    actual fun getSystemLocale(): LanguageTag =
        AppleLocale.getDeviceLocale()

}