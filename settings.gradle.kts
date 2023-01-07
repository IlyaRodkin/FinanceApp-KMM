pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FinanceApp-KMM"
include(":androidApp")

include(":common:dashboard:api")
include(":common:dashboard:data")
include(":common:dashboard:compose")
include(":common:dashboard:presentation")

include(":common:categories:api")
include(":common:categories:data")
include(":common:categories:compose")
include(":common:categories:presentation")

include(":common:transaction:api")
include(":common:transaction:data")
include(":common:transaction:compose")
include(":common:transaction:presentation")

include(":common:core")
include(":common:core-compose")
include(":common:core-utils")
include(":common:umbrella-ios")
include(":common:umbrella-compose")
include(":common:umbrella-core")

