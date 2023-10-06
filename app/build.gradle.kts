plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt") // Kotlin compiler -> enables you to generate code or make compiler level changes
    id("com.google.dagger.hilt.android") // Android HILT
}

android {
    namespace = "com.example.apikeypractice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.apikeypractice"
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
            buildConfigField("String", "API_KEY", "\"Authorization: token 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\"")
        }

        debug {
            buildConfigField("String", "API_KEY", "\"Authorization: token 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\"")
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
        buildConfig = true
    }

}

dependencies {

//Glide Dependency
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    //Recycler View Dependency
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")
    implementation ("androidx.appcompat:appcompat:1.3.0")

    //Annotation Processor for Image in Data Class File
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")

    // For control over item selection of both touch and mouse driven selection
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")

    //Used for Splash Screen
    implementation("androidx.core:core-splashscreen:1.0.1")

    //Added
    //Retrofit Dependency
    implementation( "com.squareup.retrofit2:retrofit:2.9.0")

    //OkHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.10.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    //Gson
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


    //Card View
    implementation("androidx.cardview:cardview:1.0.0")

    //Recycler View Dependency
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")
    implementation("androidx.recyclerview:recyclerview:1.3.1")


    //Glide Dependency
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    //Retrofit Dependency
    implementation( "com.squareup.retrofit2:retrofit:2.9.0")

    //OkHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.10.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")


    //Gson
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


    // HILT
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")


    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}