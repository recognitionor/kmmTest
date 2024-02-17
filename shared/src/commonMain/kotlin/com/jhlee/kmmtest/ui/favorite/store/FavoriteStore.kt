package com.jhlee.kmmtest.ui.favorite.store

import com.arkivanov.mvikotlin.core.store.Store
import com.jhlee.kmmtest.core.model.Pokemon

interface FavoriteStore: Store<FavoriteStore.Intent, FavoriteStore.State, Nothing> {

    sealed class Intent

    data class State(
        val isLoading: Boolean = false,
        val error: String? = null,
        val pokemonList: List<Pokemon> = emptyList(),
    )

}