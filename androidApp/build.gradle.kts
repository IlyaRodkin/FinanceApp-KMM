plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.rodkin.financeapp_kmm.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.rodkin.financeapp_kmm.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":common:core"))
    implementation(project(":common:umbrella-compose"))
    implementation(project(":common:umbrella-core"))

    implementation(Dependencies.Android.Compose.runtime)
    implementation(Dependencies.Android.Compose.ui)
    implementation(Dependencies.Android.Compose.material)
    implementation(Dependencies.Android.Compose.icons)
    implementation(Dependencies.Android.Compose.tooling)

    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.5.0")
}