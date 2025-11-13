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
        jdkVersion = 17
        compileSdk = 34
        minSdk = 30

        versionCode = 1
        versionName = "0.1"
        applicationId = "org.gradle.experimental.android.app"

        // Enable Compose for application modules in defaults
        compose {
            enabled = true
            kotlinCompilerExtensionVersion = "1.5.15"
        }

        dependencies {
            implementation(platform("androidx.compose:compose-bom:2024.09.03"))
            implementation("androidx.compose.ui:ui")
            implementation("androidx.compose.ui:ui-tooling-preview")
            implementation("androidx.compose.material3:material3:1.3.0")
            implementation("androidx.activity:activity-compose:1.9.3")
            implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
            implementation("androidx.navigation:navigation-compose:2.8.3")
            implementation("androidx.leanback:leanback:1.2.0")
            implementation("com.google.accompanist:accompanist-placeholder-material:0.36.0")
        }

        dependencyScopes {
            debug {
                implementation("androidx.compose.ui:ui-tooling")
            }
        }

        testing {
            dependencies {
                implementation("org.junit.jupiter:junit-jupiter:5.10.2")
                runtimeOnly("org.junit.platform:junit-platform-launcher")
            }
        }
    }

    androidLibrary {
        jdkVersion = 17
        compileSdk = 34
        minSdk = 30

        // Enable Compose in library modules too in case of shared UI later
        compose {
            enabled = true
            kotlinCompilerExtensionVersion = "1.5.15"
        }

        testing {
            dependencies {
                implementation("org.junit.jupiter:junit-jupiter:5.10.2")
                runtimeOnly("org.junit.platform:junit-platform-launcher")
            }
        }
    }
}
