plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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
}

dependencies {
    // Kotlin
    implementation(Deps.kotlin)

    //Coroutines
    implementation(Deps.coroutines)

    // Retrofit
    implementation(Deps.retrofit)
    implementation(Deps.converterGson)
    implementation(Deps.loggingInterceptor)

    // Room
    implementation(Deps.roomRuntime)
    kapt(Deps.roomCompiler)
    implementation(Deps.roomKtx)

    // Timber for logging
    implementation(Deps.timber)

    // Google Location
    implementation(Deps.googleLocation)

    // Dagger-Hilt
    implementation(Deps.hilt)
    kapt(Deps.hiltCompiler)

    implementation(project(Modules.domain))
}