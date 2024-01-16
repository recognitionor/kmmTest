plugins {
    kotlin("multiplatform")
//    kotlin("native.cocoapods")
    id("com.android.library")

    id("org.jetbrains.compose")
    id("app.cash.sqldelight").version("2.0.0")
    id("dev.icerock.mobile.multiplatform-resources")
    kotlin("plugin.serialization") version "1.5.10"
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class) kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val ktorVersion = "2.3.2-eap-692"

        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class) implementation(
                    compose.components.resources
                )
                api("io.github.qdsfdhvh:image-loader:1.2.9")

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

                implementation("app.cash.sqldelight:runtime:2.0.0")
                implementation("app.cash.sqldelight:coroutines-extensions:2.0.0")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                api("dev.icerock.moko:resources:0.23.0")

                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")

                implementation("io.ktor:ktor-client-logging:$ktorVersion")

                implementation("io.github.aakira:napier:2.6.1")

                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1") // 버전은 적절히 선택
                api("dev.gitlive:firebase-storage:1.10.0")
                api("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.2")

                implementation("com.opencsv:opencsv:5.5.2")
                implementation("com.google.code.gson:gson:2.9.0")


            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("app.cash.sqldelight:android-driver:2.0.0")
                implementation("androidx.appcompat:appcompat:1.6.1")
                implementation("androidx.activity:activity-compose:1.7.2")
                implementation("io.ktor:ktor-client-android:$ktorVersion")

                implementation("dev.gitlive:firebase-storage:1.10.0")
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependencies {
                implementation("app.cash.sqldelight:native-driver:2.0.0")
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
            }
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by getting {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.jhlee.kmmtest"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
multiplatformResources {
    multiplatformResourcesPackage = "com.jhlee.kmmtest"
    multiplatformResourcesClassName = "SharedRes"
}


sqldelight {
    databases {
        create("TestDatabase") {
            packageName.set("com.jhlee.kmmtest")

            verifyMigrations.set(true)
            deriveSchemaFromMigrations.set(true)
            migrationOutputFileFormat.set(".sqm")
            migrationOutputDirectory.set(file("sqldelight/migrations"))
        }
    }
}

dependencies {
    implementation("androidx.core:core:1.10.1")
    implementation("com.google.firebase:firebase-common-ktx:20.3.3")
    implementation("androidx.test:monitor:1.6.1")
    commonMainApi("dev.icerock.moko:mvvm-core:0.16.1")
    commonMainApi("dev.icerock.moko:mvvm-compose:0.16.1")
    commonMainApi("dev.icerock.moko:mvvm-flow:0.16.1")
    commonMainApi("dev.icerock.moko:mvvm-flow-compose:0.16.1")
}
