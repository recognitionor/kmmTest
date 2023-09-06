package com.jhlee.kmmtest

import androidx.compose.ui.window.ComposeUIViewController
import com.jhlee.kmmtest.di.AppModule
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

fun MainViewController() = ComposeUIViewController {
    App(AppModule())
}