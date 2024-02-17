package com.jhlee.kmmtest.ui.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.jhlee.kmmtest.ui.favorite.FavoriteComponent
import com.jhlee.kmmtest.ui.favorite.components.FavoriteContent

@Composable
internal fun FavoriteScreen(favoriteComponent: FavoriteComponent) {
    val state by favoriteComponent.state.collectAsState()

    FavoriteContent(
        state = state,
        onEvent = favoriteComponent::onEvent,
        onOutput = favoriteComponent::onOutput
    )
}