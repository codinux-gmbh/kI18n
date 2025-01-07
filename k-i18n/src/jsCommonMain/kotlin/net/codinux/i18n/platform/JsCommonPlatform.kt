package net.codinux.i18n.platform

object JsCommonPlatform {

    // VisibleForTesting
    internal fun getLanguageTagForAcceptLanguageAndLocaleString(acceptLanguageHeader: String, localeString: String): String {
        val acceptLanguage = acceptLanguageHeader.substringBefore(',').substringBefore(';').takeUnless { it.isBlank() }?.replace('_', '-')
        if (acceptLanguage != null && acceptLanguage.contains('-')) {
            return acceptLanguage
        }

        return if (acceptLanguage != null && localeString.startsWith(acceptLanguage) == false) {
            val localeStringWithoutLanguage = localeString.replace('_', '_').substringAfter('-', "")
            acceptLanguage + if (localeStringWithoutLanguage.isBlank()) "" else "-$localeStringWithoutLanguage"
        } else {
            localeString
        }
    }

}