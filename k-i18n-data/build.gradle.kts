@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl


plugins {
    kotlin("multiplatform")
}


kotlin {
    jvmToolchain(11)

    jvm {
        withJava()
    }

    js {
        moduleName = "k-i18n-data"
        binaries.executable()

        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    useFirefoxHeadless()
                }
            }
        }

        nodejs {
            testTask {
                useMocha {
                    timeout = "20s" // Mocha times out after 2 s, which is too short for bufferExceeded() test
                }
            }
        }
    }

    wasmJs {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    useFirefoxHeadless()
                }
            }
        }
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


    val immutableCollectionsVersion: String by project

    sourceSets {
        commonMain.dependencies {
            implementation("net.codinux.collections:immutable-collections:$immutableCollectionsVersion")
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

apply(from = "../gradle/scripts/publish-codinux.gradle.kts")