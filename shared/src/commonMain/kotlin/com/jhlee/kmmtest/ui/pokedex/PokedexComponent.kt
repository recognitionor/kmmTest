package com.jhlee.kmmtest.ui.pokedex

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.jhlee.kmmtest.ui.pokedex.store.PokedexStore
import com.jhlee.kmmtest.ui.pokedex.store.PokedexStoreFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow

class PokedexComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    searchValue: String,
    private val output: (Output) -> Unit
): ComponentContext by componentContext {

    private val pokedexStore =
        instanceKeeper.getStore {
            PokedexStoreFactory(
                storeFactory = storeFactory,
                searchValue = searchValue,
            ).create()
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    val state: StateFlow<PokedexStore.State> = pokedexStore.stateFlow

    fun onEvent(event: PokedexStore.Intent) {
        pokedexStore.accept(event)
    }

    fun onOutput(output: Output) {
        output(output)
    }

    sealed class Output {
        object NavigateBack : Output()
        data class NavigateToDetails(val name: String) : Output()
    }

}