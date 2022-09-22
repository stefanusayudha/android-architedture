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
    api(project(":control:provider"))
    val thinkLogicBuilderVersion = rootProject.extra["thinkLogicBuilderVersion"]
    kapt("com.thinkinglogic.builder:kotlin-builder-processor:$thinkLogicBuilderVersion")
}