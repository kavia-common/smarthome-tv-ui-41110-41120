androidApplication {
    namespace = "org.example.app"

    // Enable Jetpack Compose in module
    compose {
        enabled = true
    }

    // Module-specific dependencies. Using Compose BOM to align versions; explicit versions for libs not in BOM.
    dependencies {
        implementation(platform("androidx.compose:compose-bom:2024.09.03"))
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-tooling-preview")
        implementation("androidx.compose.material3:material3")
        implementation("androidx.activity:activity-compose:1.9.3")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
        implementation("androidx.navigation:navigation-compose:2.8.3")

        // Material icons (extended) for Videocam, VolumeUp, VolumeOff, Pause, Fullscreen, etc.
        implementation("androidx.compose.material:material-icons-extended")

        // Compose foundation/layout helpers (padding, focus, etc.) align via BOM
        implementation("androidx.compose.foundation:foundation")

        // TV support lib (non-Compose UI components if needed)
        implementation("androidx.leanback:leanback:1.2.0")

        // Optional UI helpers
        implementation("com.google.accompanist:accompanist-placeholder-material:0.36.0")

        // Tooling kept as regular implementation due to lack of scoped config support in this DSL
        implementation("androidx.compose.ui:ui-tooling")
    }
}
