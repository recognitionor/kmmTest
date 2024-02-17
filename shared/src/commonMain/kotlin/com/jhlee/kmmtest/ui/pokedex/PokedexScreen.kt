package com.jhlee.kmmtest.ui.pokedex

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.jhlee.kmmtest.ui.pokedex.components.PokedexContent

@Composable
internal fun PokedexScreen(component: PokedexComponent) {

    val state by component.state.collectAsState()

    PokedexContent(
        state = state,
        onEvent = component::onEvent,
        onOutput = component::onOutput
    )

}