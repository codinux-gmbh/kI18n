plugins {
    kotlin("multiplatform")
}


kotlin {
    jvmToolchain(11)

    jvm()

    js {
        browser()
        nodejs()
    }

    linuxX64()
    mingwX64()

    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosX64()
    macosArm64()

    watchosArm64()
    watchosSimulatorArm64()
    tvosArm64()
    tvosSimulatorArm64()

    applyDefaultHierarchyTemplate()


    sourceSets {
        commonMain.dependencies {
            implementation(project(":k-i18n"))
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}