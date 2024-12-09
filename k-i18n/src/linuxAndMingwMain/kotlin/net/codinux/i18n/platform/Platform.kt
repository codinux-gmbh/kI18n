package net.codinux.i18n.platform

import net.codinux.i18n.LanguageTag

actual object Platform {

    // available locales may can be read from /usr/share/i18n/SUPPORTED, but that's of course not a robust and universal way to get all locales
    // "locale -a" didn't work on my system
    // This is may due to not all locales have been generated, see "cat /etc/locale.gen" for available and currently unavailable locales
    actual val AvailableLocales: List<LanguageTag> = LanguageTag.availableLanguageTags // for now use that ones from CLDR

    actual fun getSystemLocale() = PosixLocale.getSystemLocale()

}