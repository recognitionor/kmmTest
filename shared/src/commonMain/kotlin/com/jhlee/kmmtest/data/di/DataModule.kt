package com.jhlee.kmmtest.data.di

import com.jhlee.kmmtest.data.repository.PokemonRepository
import com.jhlee.kmmtest.data.repository.PokemonRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<PokemonRepository> { PokemonRepositoryImpl() }
}