package net.codinux.i18n.model

import com.fasterxml.jackson.annotation.JsonAnySetter

open class LocaleSpecificFileHeader<T> {
    lateinit var main: LocalSpecificFileMainChild<T>
}

class LocalSpecificFileMainChild<T> {
    @JsonAnySetter
    // actually always contains only one key - the Locale tag (to state the obvious) - but as it's a Map we cannot parse it generically
    val localeSpecificProperties = mutableMapOf<String, T>()
}