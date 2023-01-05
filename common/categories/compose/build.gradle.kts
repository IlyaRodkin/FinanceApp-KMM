plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Kodein.core)
                api(project(":common:categories:api"))
                implementation(Dependencies.Other.ViewModel.core)
                implementation(project(":common:core"))
            }
        }
    }
}
