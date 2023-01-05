plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Kodein.core)
                implementation(project(":common:categories:api"))

                /* //implementation(project(":common:auth:presentation"))
                 implementation(project(":common:core-compose"))
                 implementation(project(":common:core-utils"))

                 implementation(Dependencies.Other.ViewModel.core)
                 implementation(Dependencies.Other.ViewModel.compose)
                 implementation(Dependencies.Other.ViewModel.odyssey)

                 implementation(Dependencies.Other.Navigation.core)
                 implementation(Dependencies.Other.Navigation.compose)*/
            }
        }
    }
}
