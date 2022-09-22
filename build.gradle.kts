// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("compileSdk", 33)
        set("applicationId", "com.stefanus_ayudha.basearchitecture")
        set("minSdk", 28)
        set("targetSdk", 32)
        set("versionCode", 1)
        set("versionName", "1.0")
        set("testInstrumentationRunner", "androidx.test.runner.AndroidJUnitRunner")
        set("vectorDrawables.useSupportLibrary", true)

        set("kotlinCompilerExtensionVersion", "1.1.1")
        set("jvmTarget", "1.8")

        // TODO: use version catalogue of gradle 7.2+ instead
        set("coreKtxVersion", "1.8.0")
        set("lifecycleVersion", "2.5.1")
        set("activityComposeVersion", "1.5.1")
        set("workerVersion", "2.7.1")
        set("composeVersion", "1.1.1")
        set("materialVersion", "1.0.0-alpha15")
        set("composeNavigationVersion", "2.5.1")
        set("accompanistVersion", "0.23.0")
        set("customViewVersion", "1.2.0-alpha01")
        set("poolingContainerVersion", "1.0.0")
        set("koinVersion", "3.1.5")
        set("retrofitVersion", "2.9.0")
        set("apolloVersion", "3.1.0")
        set("thinkLogicBuilderVersion", "1.2.1")
        set("armadilloVersion", "1.0.0")
        set("gsonVersion", "2.9.0")
        set("chuckerVersion", "3.5.2")
        set("arrowVersion", "1.0.1")
        set("coilVersion", "2.2.0")
    }
}

plugins {
    id("com.android.application") version "7.2.1" apply false
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}