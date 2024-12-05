plugins {
    kotlin("jvm") version "2.0.20"
}

group = "net.codinux.i18n"
version = "0.5.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}