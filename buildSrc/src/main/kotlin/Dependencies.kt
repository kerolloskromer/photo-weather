/**
 * To define plugins
 */
object BuildPlugins {
    const val android = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val safeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.safeArgsPlugin}"
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}

/**
 * To define dependencies
 */
object Deps {
    // Kotlin
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // UI
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"

    // Navigation
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // LifeCycle
    // ViewModel
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // LiveData
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    // Saved state module for ViewModel
    const val lifecycleSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"

    // Annotation processor
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

    // optional - helpers for implementing LifecycleOwner in a Service
    const val lifecycleService = "androidx.lifecycle:lifecycle-service:${Versions.lifecycle}"

    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Versions.lifecycle}"

    // optional - ReactiveStreams support for LiveData
    const val lifecycleReactiveStreams =
        "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.lifecycle}"

    // optional - Test helpers for LiveData
    const val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.arch}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    // Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // Dagger-Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    // Timber for logging
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Leak Canary - memory leak detection
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"

    // UNIT TEST
    const val junit = "junit:junit:${Versions.junit}"
    const val mockito = "org.mockito.kotlin:mockito-kotlin:${Versions.mockito}"

    // UI TEST
    const val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // Chucker OkHttp Interceptor
    const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"

    // Google Location
    const val googleLocation =
        "com.google.android.gms:play-services-location:${Versions.googleLocation}"
}

/**
 * To define Modules
 */
object Modules {
    const val data = ":data"
    const val domain = ":domain"
    const val presentation = ":presentation"
}