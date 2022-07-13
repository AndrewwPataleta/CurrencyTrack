import andrew.pataleta.buildsrc.extension.addAppModuleDependencies

plugins {
    id(Plugins.ANDROID_APPLICATION_PLUGIN)
    id(Plugins.KOTLIN_ANDROID_PLUGIN)
    id(Plugins.KOTLIN_ANDROID_EXTENSIONS_PLUGIN)
    id(Plugins.KOTLIN_KAPT_PLUGIN)
    id(Plugins.DAGGER_HILT_PLUGIN)
    id(Plugins.NAVIGATION_SAFE_ARGS)

}

android {

    defaultConfig {
        applicationId = AndroidVersion.APPLICATION_ID
        compileSdk = AndroidVersion.COMPILE_SDK_VERSION
        minSdk= AndroidVersion.MIN_SDK_VERSION
        targetSdk = AndroidVersion.TARGET_SDK_VERSION
        versionCode = AndroidVersion.VERSION_CODE
        versionName = AndroidVersion.VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {

        }
    }



    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    dynamicFeatures.apply {
        add(Modules.DynamicFeature.CURRENCY)
        add(Modules.DynamicFeature.CURRENCY_FILTER)
        add(Modules.DynamicFeature.CURRENCY_FAVORITE)
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }

}

dependencies {

    implementation(project(Modules.AndroidLibrary.DATA))
    implementation(project(Modules.AndroidLibrary.DOMAIN))
    implementation(project(Modules.AndroidLibrary.CORE))


    addAppModuleDependencies()

}
