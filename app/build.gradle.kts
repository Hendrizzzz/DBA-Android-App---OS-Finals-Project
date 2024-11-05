plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.hendrizzzz.dba2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.hendrizzzz.dba2"
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
        viewBinding = true // Enable ViewBinding
        dataBinding = true // Enable Data Binding
    }
}


dependencies {
    implementation ("androidx.navigation:navigation-compose:2.5.2")
    implementation ("androidx.compose.ui:ui:1.3.0")
    implementation ("androidx.compose.material:material:1.3.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.3.0")

    implementation ("androidx.compose.ui:ui:1.4.1") // Replace with the latest version
    implementation ("androidx.compose.material3:material3:1.0.0") // or the latest version
    implementation ("androidx.navigation:navigation-compose:2.5.3") // or the latest version

    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3") // or the latest version
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3") // or the latest version
    // For Compose
    implementation ("androidx.navigation:navigation-compose:2.5.3") // or the latest version

    implementation ("androidx.fragment:fragment-ktx:1.8.5")
    implementation ("androidx.appcompat:appcompat:1.7.0")

    // Compose BOM to manage versions of Compose libraries
    implementation(platform(libs.androidx.compose.bom)) // Reference to the Compose BOM

    // Core Compose libraries
    implementation(libs.androidx.ui) // Core UI library
    implementation(libs.androidx.ui.tooling) // Tooling support
    implementation(libs.androidx.material3) // Material 3 components

    // AndroidX libraries
    implementation(libs.androidx.core.ktx) // Kotlin extensions
    implementation(libs.androidx.lifecycle.runtime.ktx) // Lifecycle extensions
    implementation(libs.androidx.activity.compose) // Activity Compose support

    // Testing dependencies
    testImplementation(libs.junit) // JUnit for unit testing
    androidTestImplementation(libs.androidx.junit) // AndroidX JUnit
    androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI testing
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Compose BOM for testing
    androidTestImplementation(libs.androidx.ui.test.junit4) // Compose UI testing
    debugImplementation(libs.androidx.ui.test.manifest) // Manifest for debug testing
}


