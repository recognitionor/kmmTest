package com.jhlee.kmmtest.ui.details.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.jhlee.kmmtest.core.model.PokemonInfo
import com.jhlee.kmmtest.data.repository.PokemonRepository
import com.jhlee.kmmtest.pokedexDispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class DetailsStoreFactory(
    private val storeFactory: StoreFactory,
    private val pokemonName: String
): KoinComponent {
    private val pokemonRepository by inject<PokemonRepository>()

    fun create(): DetailsStore =
        object : DetailsStore, Store<DetailsStore.Intent, DetailsStore.State, Nothing> by storeFactory.create(
            name = "DetailsStore",
            initialState = DetailsStore.State(),
            bootstrapper = SimpleBootstrapper(Unit),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}

    private sealed class Msg {
        object PokemonInfoLoading : Msg()
        data class PokemonInfoLoaded(val pokemonInfo: PokemonInfo) : Msg()
        data class PokemonInfoFailed(val error: String?) : Msg()
        data class PokemonInfoFavoriteStateUpdated(val isFavorite: Boolean) : Msg()
    }

    private inner class ExecutorImpl : CoroutineExecutor<DetailsStore.Intent, Unit, DetailsStore.State, Msg, Nothing>(
        pokedexDispatchers.main) {
        override fun executeAction(action: Unit, getState: () -> DetailsStore.State) {
            loadPokemonInfoByName(pokemonName)
        }

        override fun executeIntent(intent: DetailsStore.Intent, getState: () -> DetailsStore.State): Unit =
            when (intent) {
                is DetailsStore.Intent.UpdatePokemonFavoriteState -> togglePokemonFavorite(pokemonName, intent.isFavorite)
            }

        private var loadPokemonInfoByNameJob: Job? = null
        private fun loadPokemonInfoByName(name: String) {
            if (loadPokemonInfoByNameJob?.isActive == true) return

            loadPokemonInfoByNameJob = scope.launch {
                dispatch(Msg.PokemonInfoLoading)

                pokemonRepository
                    .getPokemonFlowByName(name)
                    .onSuccess { pokemonInfo ->
                        dispatch(Msg.PokemonInfoLoaded(pokemonInfo))
                    }
                    .onFailure { e ->
                        dispatch(Msg.PokemonInfoFailed(e.message))
                    }
            }
        }

        private var togglePokemonFavoriteJob: Job? = null
        private fun togglePokemonFavorite(name: String, isFavorite: Boolean) {
            if (togglePokemonFavoriteJob?.isActive == true) return

            togglePokemonFavoriteJob = scope.launch {
                pokemonRepository.updatePokemonFavoriteState(
                    name = name,
                    isFavorite = isFavorite,
                )

                dispatch(Msg.PokemonInfoFavoriteStateUpdated(isFavorite))
            }
        }
    }

    private object ReducerImpl: Reducer<DetailsStore.State, Msg> {
        override fun DetailsStore.State.reduce(msg: Msg): DetailsStore.State =
            when (msg) {
                is Msg.PokemonInfoLoading -> DetailsStore.State(isLoading = true)
                is Msg.PokemonInfoLoaded -> DetailsStore.State(pokemonInfo = msg.pokemonInfo)
                is Msg.PokemonInfoFailed -> DetailsStore.State(error = msg.error)
                is Msg.PokemonInfoFavoriteStateUpdated -> copy(pokemonInfo = pokemonInfo?.copy(isFavorite = msg.isFavorite))
            }
    }

}