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
    api(project(":core:common"))
}