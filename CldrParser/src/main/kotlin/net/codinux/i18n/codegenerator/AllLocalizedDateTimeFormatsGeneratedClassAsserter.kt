package net.codinux.i18n.codegenerator

import net.codinux.i18n.LanguageTag
import net.codinux.i18n.datetime.DateOrTimeFormats
import net.codinux.i18n.datetime.LocalizedDateTimeFormats
import net.codinux.i18n.datetime.LocalizedDateTimeFormatsResolver
import net.codinux.i18n.model.DateAndTimeFormats
import net.codinux.i18n.parser.CldrJsonParser

fun main() {
    AllLocalizedDateTimeFormatsGeneratedClassAsserter().assert()
}

/**
 * It cannot be run directory after [AllLocalizedDateTimeFormatsClassGenerator.generate] as
 * [net.codinux.i18n.datetime.AllLocalizedDateTimeFormats] has to be compiled first. So i extracted this class, which
 * has to be run manually after [AllLocalizedDateTimeFormatsClassGenerator.generate].
 */
class AllLocalizedDateTimeFormatsGeneratedClassAsserter(
    private val cldrJsonParser: CldrJsonParser = CldrJsonParser()
) {

    fun assert() {
        val locales = cldrJsonParser.getLocalesWithLocalizedDateTimeFormats().map { LanguageTag.ofAvailable(it) }

        val formatsByLocale = locales.associateWith { cldrJsonParser.parseDateTimeFormatsForLocale(it) }

        assertFormatsHaveBeenWrittenCorrectly(formatsByLocale)
    }

    private fun assertFormatsHaveBeenWrittenCorrectly(formatsByLocale: Map<LanguageTag, DateAndTimeFormats>) {
        val resolver = LocalizedDateTimeFormatsResolver()

        formatsByLocale.forEach { (locale, formats) ->
            val resolvedFormats = resolver.getDateTimeFormatsForLocale(locale)

            assertFormatsEqual(locale, formats, resolvedFormats)
        }
    }

    private fun assertFormatsEqual(locale: LanguageTag, expectedFormats: DateAndTimeFormats, resolvedFormats: LocalizedDateTimeFormats?) {
        requireNotNull(resolvedFormats) {
            "Could not resolve DateTimeFormats for locale $locale"
        }

        assertFormatsEqual(locale, "date", expectedFormats.dateFormats, resolvedFormats.dateFormats)

        assertFormatsEqual(locale, "time", expectedFormats.timeFormats, resolvedFormats.timeFormats)

        assertFormatsEqual(locale, "dateTime", expectedFormats.dateTimeFormats, resolvedFormats.dateTimeFormats)
    }

    private fun assertFormatsEqual(locale: LanguageTag, type: String, expectedFormats: DateOrTimeFormats, resolvedFormats: DateOrTimeFormats) {
        require(expectedFormats.full == resolvedFormats.full) {
            "${type}.full of locale $locale does not match. CLDR: '${expectedFormats.full}', resolved: '${resolvedFormats.full}'"
        }

        require(expectedFormats.long == resolvedFormats.long) {
            "${type}.long of locale $locale does not match. CLDR: '${expectedFormats.long}', resolved: '${resolvedFormats.long}'"
        }

        require(expectedFormats.medium == resolvedFormats.medium) {
            "${type}.medium of locale $locale does not match. CLDR: '${expectedFormats.medium}', resolved: '${resolvedFormats.medium}'"
        }

        require(expectedFormats.short == resolvedFormats.short) {
            "${type}.short of locale $locale does not match. CLDR: '${expectedFormats.short}', resolved: '${resolvedFormats.short}'"
        }
    }

}