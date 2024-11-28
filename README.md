[![](https://jitpack.io/v/ahmedorabi94/ValifyTask.svg)](https://jitpack.io/#ahmedorabi94/ValifyTask)

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Jetpack Compose ](https://developer.android.com/develop/ui/compose/documentation) - Jetpack Compose is the modern toolkit for building native Android UI. Here's where you'll find the latest information about using Compose.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more.
- [Flow](https://kotlinlang.org/docs/flow.html) -  a flow is a type that can emit multiple values sequentially.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
  - [Room](https://developer.android.com/training/data-storage/room) - Save data in a local database using Room.
- [Dependency Injection](https://developer.android.com/training/dependency-injection)
  - [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Hilt is a dependency injection library for Android that reduces        the boilerplate of doing manual dependency injection in your project
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - Repository pattern
  - Clean Architecture approach.

![architecture-overview](https://user-images.githubusercontent.com/7644709/174149866-27ad6cf5-2b56-4087-9b38-d54c12fa7ef8.png)
![final-architecture](https://user-images.githubusercontent.com/7644709/94259993-b2691b80-ff2f-11ea-8bff-cc4ed3c8b6d9.png)


## How to use

```
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

Then in your app module

@HiltAndroidApp
class BasicApp : Application()

 startActivity(Intent(this,RegisterActivity::class.java))
 finish()

```
