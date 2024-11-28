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
//        maven {
//            url = uri("https://jitpack.io")
//        }
        maven {
            url = uri("https://www.jitpack.io")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://www.jitpack.io")
        }
      //  maven { url = uri("https://maven.scijava.org/content/repositories/public/") }

    }
}

rootProject.name = "ValifyTask"
include(":app")
include(":Registration SDK")
