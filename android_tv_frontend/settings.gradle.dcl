pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.experimental.android-ecosystem").version("0.1.43")
}

rootProject.name = "example-android-app"

include("app")
include("list")
include("utilities")

defaults {
    androidApplication {
        // Set required JDK toolchain for Android builds
        jdkVersion = 17
        compileSdk = 35
        minSdk = 30
        namespace = "org.example.app"
    }
    androidLibrary {
        // Ensure library modules inherit required toolchain and SDK settings
        jdkVersion = 17
        compileSdk = 35
        minSdk = 30
    }
}
