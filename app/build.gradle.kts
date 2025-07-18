plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.devtools.ksp)
}

android {
    namespace = "com.example.employee"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.employee"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
}

kotlin {
    jvmToolchain(19) // Or your desired JVM version as an Int
}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.media3.common.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.core.ktx.v1120) // Or latest version
    implementation(libs.androidx.appcompat) // Or latest version
    implementation(libs.material) // Or latest version
    implementation(libs.androidx.constraintlayout) // Or latest version
    implementation(libs.androidx.lifecycle.viewmodel.ktx) // For ViewModel
    implementation(libs.androidx.lifecycle.livedata.ktx) // For LiveData
    implementation(libs.androidx.recyclerview) // For RecyclerView

    // Room components
    //val room_version = "2.6.1" // Or latest version
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.room.compiler)
    // To use Kotlin Symbol Processing (KSP)
    ksp(libs.room.compiler)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)

    // Navigation Component (optional but recommended for multi-fragment apps)
    //val nav_version = "2.7.7" // Or latest version
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Test Implementations (already there usually)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core.v351)

}