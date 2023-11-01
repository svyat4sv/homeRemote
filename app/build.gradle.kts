plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.homeremote"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.homeremote"
        minSdk = 24
        targetSdk = 33
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
        implementation ("androidx.core:core-ktx:1.12.0")
        implementation ("androidx.appcompat:appcompat:1.6.1")
        implementation ("com.google.android.material:material:1.10.0")
        implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
        implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
        implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
        implementation ("androidx.navigation:navigation-fragment-ktx:2.7.4")
        implementation ("androidx.navigation:navigation-ui-ktx:2.7.4")
        testImplementation ("junit:junit:4.13.2")
        androidTestImplementation ("androidx.test.ext:junit:1.1.5")
        androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
        implementation("com.squareup.moshi:moshi-kotlin:1.14.0")

        //Room
        implementation ("androidx.room:room-runtime:2.6.0")
        annotationProcessor ("androidx.room:room-compiler:2.6.0")
        kapt ("androidx.room:room-compiler:2.6.0")
        implementation ("androidx.room:room-ktx:2.6.0")
        implementation("androidx.room:room-paging:2.6.0")



        //Hilt
        implementation ("com.google.dagger:hilt-android:2.48")


        implementation ("androidx.fragment:fragment-ktx:1.6.1")
        //Navigation
        implementation ("androidx.navigation:navigation-fragment-ktx:2.7.4")
        implementation ("androidx.navigation:navigation-ui-ktx:2.7.4")

        //Coroutines
        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

        //lifecycle
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

        // Retrofit
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("com.google.code.gson:gson:2.9.1")
// Retrofit with Scalar Converter
        implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")
        // Retrofit with Moshi Converter
        implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")

        //Paging 3
        implementation ("androidx.paging:paging-runtime:3.2.1")



        implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
        // Swipe Refresh
        implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")
        implementation ("com.github.bumptech.glide:glide:4.15.1")
        implementation ("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    }