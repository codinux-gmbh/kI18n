package net.codinux.i18n.platform

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString
import net.codinux.i18n.LanguageTag
import platform.posix.LC_ALL

@OptIn(ExperimentalForeignApi::class)
object PosixLocale {

    // see header <locale.h> or <bits/locale.h> respectively (e.g. /user/include/locale.h)

    const val LC_MESSAGES = 5

    const val LC_PAPER = 7

    const val LC_NAME = 8

    const val LC_ADDRESS = 9

    const val LC_TELEPHONE = 10

    const val LC_MEASUREMENT = 11

    const val LC_IDENTIFICATION = 12


    fun getSystemLocale(): LanguageTag {
        // In Posix systems the locale is determined by these values in this order:
        // - the LANGUAGE environment value
        // - the LC_ALL locale value
        // - the LC_ALL locale value
        // - the LANGUAGE environment value
        val language = platform.posix.getenv("LANGUAGE")?.toKString()
            ?: getValueForCategory(LC_ALL)
            ?: getValueForCategory(LC_MESSAGES)
            ?: platform.posix.getenv("LANG")?.toKString()
            ?: "en_US" // fallback value

        return parseToLocale(language)
    }

    internal fun parseToLocale(locale: String): LanguageTag {
        // the format is language[_territory][.codeset][@modifier], where
        // - language is an ISO 639 language code,
        // - territory is an ISO 3166 country code,
        // - codeset is a character set or encoding identifier like ISO-8859-1 or UTF-8.
        //   For a list of all supported locales, try "locale -a" (see locale(1)).

        var indexOfUnderscore = locale.indexOf('_')
        if (indexOfUnderscore < 0) {
            indexOfUnderscore = locale.indexOf('-') // Apple systems use '-' instead of '_'
        }
        val indexOfDot = locale.indexOf('.')
        val indexOfAt = locale.indexOf('@')

        val variant = if (indexOfAt > -1) {
            locale.substring(indexOfAt + 1)
        } else {
            null
        }

        val countryCode = if (indexOfUnderscore > -1) {
            if (indexOfDot > -1) {
                locale.substring(indexOfUnderscore + 1, indexOfDot)
            } else if (indexOfAt > -1) {
                locale.substring(indexOfUnderscore + 1, indexOfAt)
            } else {
                locale.substring(indexOfUnderscore + 1)
            }
        } else {
            ""
        }

        val languageCode = if (indexOfUnderscore > -1) {
            locale.substring(0, indexOfUnderscore)
        } else if (indexOfDot > -1) {
            locale.substring(0, indexOfDot)
        } else if (indexOfAt > -1) {
            locale.substring(0, indexOfAt)
        } else {
            locale
        }

        val languageTag = locale.replace('_', '-').replace('.', '-').replace('@', '-')
        return LanguageTag(languageTag, languageCode, countryCode, variant = variant)
    }

    internal fun getValueForCategory(category: Int): String? {
        val localePointer = platform.posix.setlocale(category, "")
        val locale = localePointer?.toKString()

        // LC_ALL value sometimes contains all LC_xyz values which are separated by ';' -> filter out these
        return if (locale.isNullOrBlank() || locale == "C" || (category == LC_ALL || locale.contains(';'))) {
            null
        } else {
            locale
        }
    }

}