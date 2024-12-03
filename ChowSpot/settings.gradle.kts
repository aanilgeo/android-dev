pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") } // Added Jitpack repository
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS) // Changed to PREFER_SETTINGS
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") } // Ensure Jitpack is added for required dependencies
    }
}

rootProject.name = "ChowSpot"
include(":app")

