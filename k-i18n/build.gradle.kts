import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    kotlin("multiplatform")
}


kotlin {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        // suppresses compiler warning: [EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING] 'expect'/'actual' classes (including interfaces, objects, annotations, enums, and 'actual' typealiases) are in Beta.
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }


    jvmToolchain(11)

    jvm {
        withJava()
    }

    js {
        moduleName = "k-i18n"
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

    // removed WASM because i don't know how to get system locale in wasmJS


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

    val klfVersion: String by project

    val assertKVersion: String by project
    val logbackVersion: String by project

    sourceSets {
        commonMain.dependencies {
            implementation("net.codinux.collections:immutable-collections:$immutableCollectionsVersion")

            implementation("net.codinux.log:klf:$klfVersion")
        }
        commonTest.dependencies {
            implementation(kotlin("test"))

            implementation("com.willowtreeapps.assertk:assertk:$assertKVersion")
        }

        jvmTest.dependencies {
            implementation("ch.qos.logback:logback-classic:$logbackVersion")
        }


        val linuxAndMingwMain by creating {
            dependsOn(nativeMain.get())
        }
        linuxMain {
            dependsOn(linuxAndMingwMain)
        }
        mingwMain {
            dependsOn(linuxAndMingwMain)
        }
    }
}



apply(from = "../gradle/scripts/publish-codinux.gradle.kts")