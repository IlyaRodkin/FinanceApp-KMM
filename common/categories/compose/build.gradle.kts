plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Kodein.core)
                implementation(Dependencies.Other.ViewModel.core)
                api(project(":common:categories:api"))
                implementation(project(":common:core"))
                implementation(project(":common:core-compose"))
            }
        }
    }
}
