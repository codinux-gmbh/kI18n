package net.codinux.i18n.platform

actual object Platform {

    actual fun getSystemLocale() = PosixLocale.getSystemLocale()

}