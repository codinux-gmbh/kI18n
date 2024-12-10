# kI18n

Brings the internationalization (i18n) data of the great [Unicode CLDR](https://github.com/unicode-org/cldr), "the largest and most extensive standard repository of locale data available", to Kotlin (Multiplatform).

It supports localizing Languages, Countries, Currencies, Units and Dates and has formatters for Numbers, Currencies, Percentages and Dates.

## Usage

### LanguageTag

To receive language, region, script (writing system), ... specific data a language tag is used. You know it from throughout the internet, like `en-US` for US-American English or `es-AR` for Spanish as spoken in Argentina.

You can either retrieve it using our enum constants:

```kotlin
val language = LanguageTag.of(Language.Hindi)

val languageWithRegion = LanguageTag.of(Language.Arabic, Region.Yemen)

val languageWithVariant = LanguageTag.of(Language.Belarusian, variant = "tarask")
```

Alternatively, you can specify the language tag as a string:

```kotlin
val language = LanguageTag.parse("es-AR") // throws an exception if language tag is invalid
val languageOrNull = LanguageTag.parseOrNull("invalid") // returns null if language tag is invalid
```

Or, you can use one of the available language tags from the CLDR data:

```kotlin
val availables: List<LanguageTag> = LanguageTag.availableLanguageTags
val availableTags: List<String> = LanguageTag.availableLanguageTagsAsString
val availablesByTag: Map<String, LanguageTag> = LanguageTag.availableLanguageTagsByTag

val fromAvailableTags = LanguageTag.ofAvailable("jp")
// it's a valid LanguageTag, but there's no instance for it in LanguageTag.availableLanguageTags (as CLDR as no direct data for it)
val fromAvailableTagsOrNull = LanguageTag.ofAvailableOrNull("en-001") 
```

Get the system's current language tag:

```kotlin
val current = LanguageTag.current // equal to Java's Locale.getDefault()
```

## Implementation

### LanguageTag

We use a (not complete) implementation of BCP 47 LanguageTag. It consists of:
- Two or three lowercase letters for the language, e.g. `en`, `es`, `ru`, `ar` and `zh` for English, Spanish, Russian, Arabic and Chinese. See [Language](./k-i18n-data/src/commonMain/kotlin/net/codinux/i18n/Language.kt) or all supported languages.
- Optionally a two or three uppercase letters or a three-digit UN M.49 code for the region, e.g. `001`, `FR`, `GH`, `IN` and `JP` for World, France, Ghana, India and Japan. See [Region](./k-i18n-data/src/commonMain/kotlin/net/codinux/i18n/Region.kt) for all supported regions.
- Optionally a four-letter ISO 15924 code for the script (writing system) in title case like `Latn`, `Arab`, `Hebr`, `Cryl` and `Hans` for Latin, Arabic, Hebrew, Cyrillic and simplified Han.
- Optionally a five to eight lowercase letters or four characters starting with a digit variant like `tarask` or `valencia`.

### Limitations

However it's not a copmlete implementation of the BCP 47 language tag:


## Comparison to Java Locale

- Cleaner API.
- Not (almost) everything is stored on quite heavyweight Locale object but in lightweight domain specific LanguageTag, DisplayNames, Formatter, ... classes.

## Work with the code

This project includes https://github.com/unicode-org/cldr-json as a Git submodule, so after initial checkout init submodules:

```shell
git clone https://github.com/codinux/k-i18n

git submodule init
git submodule update
```
