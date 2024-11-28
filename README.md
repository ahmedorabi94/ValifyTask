[![](https://jitpack.io/v/ahmedorabi94/ValifyTask.svg)](https://jitpack.io/#ahmedorabi94/ValifyTask)


How to use

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://www.jitpack.io")
        }
    }
}

implementation("com.github.ahmedorabi94:ValifyTask:0.0.16")
