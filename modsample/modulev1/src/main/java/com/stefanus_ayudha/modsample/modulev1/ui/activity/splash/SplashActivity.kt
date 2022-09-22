package com.stefanus_ayudha.modsample.modulev1.ui.activity.splash

import androidx.compose.runtime.Composable
import com.stefanus_ayudha.control.provider.sample.space.TodoSpace
import com.stefanus_ayudha.core.common.util.activity.BaseActivity
import com.stefanus_ayudha.core.common.util.activity.createLauncher
import com.stefanus_ayudha.core.common.util.coroutine.LaunchInIO
import com.stefanus_ayudha.core.common.util.logDebug
import com.stefanus_ayudha.core.ui.setupScreenSize
import com.stefanus_ayudha.modsample.modulev1.ui.screen.splash.SplashScreen
import org.koin.android.ext.android.inject

class SplashActivity : BaseActivity() {

    private val todoSpace: TodoSpace by inject()

    private val todoLauncher = createLauncher(todoSpace) {
        logDebug("pouipuyouyqwouyowq TODO $it")
    }

    override val content = @Composable {
        setupScreenSize(1f)
        SplashScreen()
    }

    override fun initAction() {
        LaunchInIO {
            todoLauncher.launch(
                TodoSpace.Payload()
            )
        }
    }
}