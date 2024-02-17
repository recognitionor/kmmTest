package com.jhlee.kmmtest

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.jhlee.kmmtest.ui.ContentView
import com.jhlee.kmmtest.ui.helper.LocalSafeArea
import com.jhlee.kmmtest.ui.root.RootComponent
import com.jhlee.kmmtest.ui.theme.PokedexTheme
import platform.UIKit.*

@Suppress("unused", "FunctionName")
fun MainViewController(
    lifecycle: LifecycleRegistry,
    topSafeArea: Float,
    bottomSafeArea: Float
): UIViewController {
    com.jhlee.kmmtest.core.di.initKoin()

    val rootComponent =
        RootComponent(
            componentContext = DefaultComponentContext(lifecycle = lifecycle),
            storeFactory = DefaultStoreFactory(),
        )

    return ComposeUIViewController {
        val density = LocalDensity.current

        val topSafeAreaDp = with(density) { topSafeArea.toDp() }
        val bottomSafeAreaDp = with(density) { bottomSafeArea.toDp() }
        val safeArea = PaddingValues(top = topSafeAreaDp + 10.dp, bottom = bottomSafeAreaDp)

        // Bind safe area as the value for LocalSafeArea
        CompositionLocalProvider(LocalSafeArea provides safeArea) {
            PokedexTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ContentView(
                        component = rootComponent,
                    )
                }
            }
        }
    }
}