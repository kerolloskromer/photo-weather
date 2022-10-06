plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Kotlin
    implementation(Deps.kotlin)

    //Coroutines
    implementation(Deps.coroutines)

    // UI
    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.materialDesign)
    implementation(Deps.recyclerView)
    implementation(Deps.constraintLayout)
    implementation(Deps.fragment)
    implementation(Deps.coil)

    // Navigation
    implementation(Deps.navigationFragment)
    implementation(Deps.navigationUI)

    // LifeCycle
    implementation(Deps.lifecycleViewModel)
    implementation(Deps.lifecycleLiveData)
    implementation(Deps.lifecycleSavedState)
    implementation(Deps.lifecycleCompiler)
    implementation(Deps.lifecycleService)
    implementation(Deps.lifecycleProcess)
    implementation(Deps.lifecycleReactiveStreams)
    implementation(Deps.lifecycleTesting)

    // UI TEST
    androidTestImplementation(Deps.androidJunit)
    androidTestImplementation(Deps.espresso)

    // Dagger-Hilt
    implementation(Deps.hilt)
    kapt(Deps.hiltCompiler)

    // Timber for logging
    implementation(Deps.timber)

    implementation(project(Modules.domain))
}