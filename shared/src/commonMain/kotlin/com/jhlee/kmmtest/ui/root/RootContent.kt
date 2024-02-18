package com.jhlee.kmmtest.ui.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.jhlee.kmmtest.ui.main.MainScreen

@Composable
internal fun RootContent(component: RootComponent) {
    Children(
        stack = component.childStack,
        animation = stackAnimation(fade())
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.Main -> MainScreen(child.component)
        }
    }
}