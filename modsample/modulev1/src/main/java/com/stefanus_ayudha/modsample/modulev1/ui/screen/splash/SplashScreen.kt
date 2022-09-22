package com.stefanus_ayudha.modsample.modulev1.ui.screen.splash

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.stefanus_ayudha.core.ui.ui.theme.ContentThemeWrapper

@Composable
fun SplashScreen(name: String = "Splash") {
    Text(text = "Hello $name!")
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    ContentThemeWrapper {
        SplashScreen()
    }
}