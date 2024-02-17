package com.jhlee.kmmtest.core.database.di

import com.jhlee.kmmtest.core.database.createDatabase
import com.jhlee.kmmtest.core.database.dao.PokemonDao
import com.jhlee.kmmtest.core.database.dao.PokemonInfoDao
import com.jhlee.kmmtest.core.database.sqlDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    factory { sqlDriverFactory() }
    single { createDatabase(driver = get()) }
    single { PokemonDao(pokemonDatabase = get()) }
    single { PokemonInfoDao(pokemonDatabase = get()) }
}