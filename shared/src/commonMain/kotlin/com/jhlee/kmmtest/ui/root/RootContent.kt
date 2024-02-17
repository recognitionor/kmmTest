package com.jhlee.kmmtest.ui.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.jhlee.kmmtest.ui.comingsoon.ComingSoonScreen
import com.jhlee.kmmtest.ui.main.MainScreen
import com.jhlee.kmmtest.ui.pokedex.PokedexScreen
import com.mocoding.pokedex.ui.details.DetailsScreen
import com.jhlee.kmmtest.ui.favorite.FavoriteScreen

@Composable
internal fun RootContent(component: RootComponent) {
    Children(
        stack = component.childStack,
        animation = stackAnimation(fade()),
    ) {
        when(val child = it.instance) {
            is RootComponent.Child.Main -> MainScreen(child.component)
            is RootComponent.Child.Pokedex -> PokedexScreen(child.component)
            is RootComponent.Child.Favorite -> FavoriteScreen(child.component)
            is RootComponent.Child.Details -> DetailsScreen(child.component)
            is RootComponent.Child.ComingSoon -> ComingSoonScreen(child.component)
        }
    }
}