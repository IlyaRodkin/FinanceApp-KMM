plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:core"))
                api(project(":common:categories:api"))

                implementation(Dependencies.Other.ViewModel.core)
            }
        }
    }
}
