plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
}

android {
    namespace = "com.example.loginapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.loginapp"
        minSdk = 27
        targetSdk = 34
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit: 2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Corrutinas
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    //Room
    implementation ("androidx.room:room-ktx:2.4.0")
    kapt("androidx.room:room-compiler:2.3.0")

    //ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")

    //Koin
    implementation("io.coil-kt:coil:1.1.0")

    implementation("io.insert-koin:koin-android:3.1.5")
}