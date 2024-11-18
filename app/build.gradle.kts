plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "be.bnp.tictactoe"
    compileSdk = 35

    defaultConfig {
        applicationId = "be.bnp.tictactoe"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    // Core libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Compose libraries
    implementation(platform(libs.androidx.compose.bom)) // BOM for Compose versions.
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Unit testing libraries
    testImplementation(libs.junit)

    // Android test libraries
    androidTestImplementation(libs.androidx.junit) // JUnit for Android testing.
    androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI testing.
    androidTestImplementation(libs.androidx.ui.test.junit4) // Jetpack Compose UI tests.

    // Debugging tools
    debugImplementation(libs.androidx.ui.tooling) // Tools for Compose UI previews.
    debugImplementation(libs.androidx.ui.test.manifest) // Test manifest debugging tools.
}

