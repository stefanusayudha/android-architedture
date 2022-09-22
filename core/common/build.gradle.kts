android {
    kotlinOptions {
        jvmTarget = rootProject.extra["jvmTarget"] as String
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion =
            rootProject.extra["kotlinCompilerExtensionVersion"] as String
    }
}

dependencies {

    // CORE
    val coreKtxVersion = rootProject.extra["coreKtxVersion"]
    api("androidx.core:core-ktx:$coreKtxVersion")

    val lifecycleVersion = rootProject.extra["lifecycleVersion"]
    api("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")

    val activityComposeVersion = rootProject.extra["activityComposeVersion"]
    api("androidx.activity:activity-compose:$activityComposeVersion")

    val workerVersion = rootProject.extra["workerVersion"]
    api("androidx.work:work-runtime:$workerVersion")

    val arrowVersion = rootProject.extra["arrowVersion"]
    api("io.arrow-kt:arrow-core:$arrowVersion")
    api("io.arrow-kt:arrow-core-retrofit:$arrowVersion")

    testApi("junit:junit:4.13.2")
    testApi("org.testng:testng:7.6.1")
    androidTestApi("androidx.test.ext:junit:1.1.3")
    androidTestApi("androidx.test.espresso:espresso-core:3.4.0")

    // UI
    val composeVersion = rootProject.extra["composeVersion"]
    api("androidx.compose.ui:ui:$composeVersion")
    api("androidx.compose.ui:ui-tooling-preview:$composeVersion")

    val materialVersion = rootProject.extra["materialVersion"]
    api("androidx.compose.material3:material3:$materialVersion")

    // NAVIGATION
    val composeNavigationVersion = rootProject.extra["composeNavigationVersion"]
    api("androidx.navigation:navigation-compose:$composeNavigationVersion")

    // Accompanist
    val accompanistVersion = rootProject.extra["accompanistVersion"]
    api("com.google.accompanist:accompanist-pager:$accompanistVersion")
    api("com.google.accompanist:accompanist-pager-indicators:$accompanistVersion")
    api("com.google.accompanist:accompanist-navigation-animation:$accompanistVersion")
    api("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")

    // Compose preview is buggy need pooling container
    val customViewVersion = rootProject.extra["customViewVersion"]
    debugApi("androidx.customview:customview:$customViewVersion")
    val poolingContainerVersion = rootProject.extra["poolingContainerVersion"]
    debugApi("androidx.customview:customview-poolingcontainer:$poolingContainerVersion")

    debugApi("androidx.compose.ui:ui-tooling:$composeVersion")
    debugApi("androidx.compose.ui:ui-test-manifest:$composeVersion")
    androidTestApi("androidx.compose.ui:ui-test-junit4:$composeVersion")

    // INJECTION
    val koinVersion = rootProject.extra["koinVersion"]
    api("io.insert-koin:koin-core:$koinVersion")
    api("io.insert-koin:koin-android:$koinVersion")
    api("io.insert-koin:koin-androidx-workmanager:$koinVersion")
    api("io.insert-koin:koin-androidx-navigation:$koinVersion")
    api("io.insert-koin:koin-androidx-compose:$koinVersion")

    // RETROFIT
    val retrofitVersion = rootProject.extra["retrofitVersion"]
    api("com.squareup.retrofit2:retrofit:$retrofitVersion")
    api("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    // APOLLO
    val apolloVersion = rootProject.extra["apolloVersion"]
    api("com.apollographql.apollo3:apollo-runtime:$apolloVersion")

    // BUILDER
    val thinkLogicBuilderVersion = rootProject.extra["thinkLogicBuilderVersion"]
    api("com.thinkinglogic.builder:kotlin-builder-annotation:$thinkLogicBuilderVersion")

    // PREFERENCE
    val armadilloVersion = rootProject.extra["armadilloVersion"]
    api("at.favre.lib:armadillo:$armadilloVersion")

    // GSON
    val gsonVersion = rootProject.extra["gsonVersion"]
    api("com.google.code.gson:gson:$gsonVersion")

    // DEBUG
    val chuckerVersion = rootProject.extra["chuckerVersion"]
    debugApi("com.github.chuckerteam.chucker:library:$chuckerVersion")
    releaseApi("com.github.chuckerteam.chucker:library-no-op:$chuckerVersion")

    // IMAGE LOADER
    val coilVersion = rootProject.extra["coilVersion"]
    api("io.coil-kt:coil-compose:$coilVersion")

    // BLACK CODE
    api("androidx.core:core-ktx:1.9.0")
    api("androidx.appcompat:appcompat:1.5.1")
    api("com.google.android.material:material:1.6.1")
    api("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    api("androidx.activity:activity-compose:1.5.1")

    // Activity Compose
    api("androidx.activity:activity-compose:1.5.1")

    // CameraX
    api("androidx.camera:camera-camera2:1.1.0")
    api("androidx.camera:camera-lifecycle:1.1.0")
    api("androidx.camera:camera-view:1.2.0-beta01")

    // Zxing
    api("com.google.zxing:core:3.3.3")

    // Maps
    api("com.google.maps.android:maps-compose:2.7.0")
    api("com.google.android.gms:play-services-maps:18.1.0")

}