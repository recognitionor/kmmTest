package com.jhlee.kmmtest.data.repository

import com.jhlee.kmmtest.core.model.Pokemon
import com.jhlee.kmmtest.core.model.PokemonInfo
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getPokemonList(page: Long): Result<List<Pokemon>>

    suspend fun getPokemonFlowByName(name: String): Result<PokemonInfo>
    suspend fun getFavoritePokemonListFlow(): Flow<List<Pokemon>>
    suspend fun updatePokemonFavoriteState(name: String, isFavorite: Boolean)

}