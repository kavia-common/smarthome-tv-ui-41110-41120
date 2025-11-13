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

// Keep defaults minimal and within supported fields for the declarative DSL.
defaults {
    androidApplication {
        jdkVersion = 17
        compileSdk = 35
        minSdk = 30

        versionCode = 1
        versionName = "0.1"
        applicationId = "org.gradle.experimental.android.app"
        // Compose enablement and dependencies are moved to module-level build.gradle.dcl for compatibility.
    }

    androidLibrary {
        jdkVersion = 17
        compileSdk = 35
        minSdk = 30
        // Compose configuration for libraries is also handled at module-level if/when needed.
    }
}
