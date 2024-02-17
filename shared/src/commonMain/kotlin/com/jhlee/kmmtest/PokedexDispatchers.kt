package com.jhlee.kmmtest

import kotlinx.coroutines.CoroutineDispatcher

interface PokedexDispatchers {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}

expect val pokedexDispatchers: PokedexDispatchers