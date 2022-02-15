plugins {
    kotlin("multiplatform") version "1.6.10"
    id("com.android.library") version "7.1.0"
}

group = "me.andrewreed"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    mavenLocal()
}

kotlin {
    iosSimulatorArm64 {
        binaries.framework("library")
    }
    iosArm64("ios") {
        binaries.framework("library")
    }
    android {
        publishAllLibraryVariants()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.myunidays:segmenkt:0.0.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val iosMain by getting
        val iosSimulatorArm64Main by getting
        iosSimulatorArm64Main.dependsOn(iosMain)

        val iosTest by getting
        val iosSimulatorArm64Test by getting
        iosSimulatorArm64Test.dependsOn(iosTest)

        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13")
            }
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 28
        targetSdk = 31
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}