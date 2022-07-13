// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://jitpack.io") }
    }

    dependencies {
        classpath(Plugins.CLASSPATH_GRADLE)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
        classpath(Plugins.CLASSPATH_DAGGER_HILT)
        classpath(Plugins.CLASSPATH_NAV_SAFE_ARGS)
        classpath(Plugins.CLASSPATH_MP_CHART)
        classpath("com.google.gms:google-services:4.3.10")
    }
}

plugins {
    id(Plugins.DETEKT) version PluginVersion.DETEKT_VERSION
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

subprojects {

    apply(plugin = Plugins.DETEKT)

}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
