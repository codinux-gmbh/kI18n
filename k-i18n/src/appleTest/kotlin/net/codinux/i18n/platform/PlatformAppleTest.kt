package net.codinux.i18n.platform

import assertk.assertThat
import assertk.assertions.isEqualTo
import net.codinux.i18n.LanguageTag
import kotlin.test.Ignore
import kotlin.test.Test

class PlatformAppleTest {

    @Ignore // TODO: does not work yet
    @Test
    fun setSystemLocale() {
        val currentLocale = Platform.getSystemLocale()
        val expectedLocale = if (currentLocale.tag == "fr") "en" else "fr"

        Platform.setSystemLocale(LanguageTag.ofAvailable(expectedLocale))

        val result = Platform.getSystemLocale()

        assertThat(result.tag).isEqualTo(expectedLocale)
    }

}