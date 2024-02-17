package com.jhlee.kmmtest.core.network.di

import com.jhlee.kmmtest.core.network.client.PokemonClient
import com.jhlee.kmmtest.core.network.createHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: (enableLogging: Boolean) -> Module get() = { enableLogging ->
    module {
        single { createHttpClient(enableLogging) }
        single { PokemonClient(httpClient = get()) }
    }
}