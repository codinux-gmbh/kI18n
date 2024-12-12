plugins {
    kotlin("jvm")
}


kotlin {
    jvmToolchain(11)
}


dependencies {
    val kotlinPoetVersion: String by project

    val jacksonVersion: String by project

    val apachePoiVersion: String by project

    val immutableCollectionsVersion: String by project

    val klfVersion: String by project

    val assertKVersion: String by project
    val logbackVersion: String by project


    implementation(project(":k-i18n"))

    implementation("com.squareup:kotlinpoet:$kotlinPoetVersion")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")

    implementation("org.apache.poi:poi:$apachePoiVersion")

    implementation("net.codinux.collections:immutable-collections:$immutableCollectionsVersion")

    implementation("net.codinux.log:klf:$klfVersion")


    testImplementation(kotlin("test"))

    testImplementation("com.willowtreeapps.assertk:assertk:$assertKVersion")

    testImplementation("ch.qos.logback:logback-classic:$logbackVersion")
}

tasks.test {
    useJUnitPlatform()
}