plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("maven-publish")
}

android {
    namespace = "com.example.valifytask"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.valifytask"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }

//    publishing {
//        singleVariant("release") {
//            withSourcesJar()
//            withJavadocJar()
//        }
//    }
}

dependencies {
    implementation(project(":Registration SDK"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)


}

//publishing {
//    publications {
//        create("maven-public", MavenPublication::class)  {
//            groupId = "com.github.ahmedorabi94"
//            artifactId = "ValifyTask"
//            version = "0.0.6"
//
//            // from(components.findByName("release"))
//            from(components.getByName("java"))
//            // from components.findByName('release')
//        }
//    }
////    repositories {
////        maven {
////            name = "releases"
////            url = uri("https://jitpack.io")
////        }
////    }
//}


//publishing {
//    publications {
//        register<MavenPublication>("release") {
//            groupId = "com.github.ahmedorabi94"
//            artifactId = "ValifyTask"
//            version = "0.0.6"
//
//            afterEvaluate {
//                from(components["release"])
//            }
//        }
//    }
//}