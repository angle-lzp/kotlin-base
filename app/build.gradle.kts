plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.navigationapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.navigationapplication"
        minSdk = 27
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")

    //okhttp
    implementation("com.squareup.okhttp3:okhttp:4.10.0")//okhttp
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")//网络请求日志打印

    //json解析
    implementation("com.google.code.gson:gson:2.10.1")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")//retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") //json转换


    //kotlin协程
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")//kotlin协程
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6")//kotlin协程测试

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //spring
    implementation("org.springframework:spring-core:5.3.10")
    implementation("org.springframework:spring-beans:5.3.10")
    implementation("org.springframework:spring-web:5.3.10")

}