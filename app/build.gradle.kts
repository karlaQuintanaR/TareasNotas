plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // Nota: El plugin KSP tiene una versión más nueva disponible. La mantenemos aquí
    // pero considera actualizarla a "2.1.0-1.0.29" como sugiere la advertencia.
    id("com.google.devtools.ksp") version "2.1.0-1.0.29"
}

android {
    // Advertencia: Tienes una versión más nueva disponible (36)
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.inventory"
        minSdk = 26
        // Advertencia: Tienes una versión más nueva disponible (36)
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    namespace = "com.example.inventory"
}

dependencies {
    val roomVersion = "2.6.1"

    // Compose BOM (Bill of Materials)
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.navigation:navigation-compose:2.7.5")

    // Room
    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

    // Testing
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    // Gson for JSON parsing
    implementation("com.google.code.gson:gson:2.10.1")

    // Accompanist Permissions for managing permissions
    implementation("com.google.accompanist:accompanist-permissions:0.36.0")

    // DocumentFile for managing documents and storage
    implementation("androidx.documentfile:documentfile:1.0.1")

    // Coil for image loading
    implementation("io.coil-kt:coil-compose:2.5.0")

    // Material Icons Core for Compose
    implementation("androidx.compose.material:material-icons-core-android:1.5.4")

    implementation("androidx.activity:activity-ktx:1.9.0")

}