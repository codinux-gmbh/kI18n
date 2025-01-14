
allprojects {
    group = "net.codinux.i18n"
    version = "0.7.1"

    ext["sourceCodeRepositoryBaseUrl"] = "github.com/codinux-gmbh/kI18n"

    ext["projectDescription"] = "Localizing language, country, unit and currency names and formatting numbers and dates for Kotlin Multiplatform with the data from Unicode CLDR project"

    repositories {
        mavenCentral()
    }
}