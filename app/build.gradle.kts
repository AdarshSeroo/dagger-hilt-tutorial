plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //dagger
    id("com.google.dagger.hilt.android")
    //kapt
    id("kotlin-kapt")

}

android {
    namespace = "com.example.dagger_hilt_tutorial"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dagger_hilt_tutorial"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

//buildConfig field for api
        buildConfigField("String","BASE_URL","\"https://5e510330f2c0d300147c034c.mockapi.io/\"")

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
    //buildConfig is required
    buildFeatures{
        buildConfig = true
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

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.activity:activity-ktx:1.8.1")
//glide
    implementation("com.github.bumptech.glide:glide:5.0.0-rc01")

//retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.4.0")
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.8.0")

//coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

//dagger&hilt
    implementation ("androidx.hilt:hilt-work:1.1.0")
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")

//worker
    implementation ("androidx.work:work-runtime-ktx:2.8.1")
    implementation( "androidx.work:work-runtime:2.8.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}