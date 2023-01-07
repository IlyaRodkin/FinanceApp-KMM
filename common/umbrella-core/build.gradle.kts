plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:core-utils"))

                implementation(project(":common:categories:data"))

                implementation(Dependencies.Kodein.core)
            }
        }
    }
}