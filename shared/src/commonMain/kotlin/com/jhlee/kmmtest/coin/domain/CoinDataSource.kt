package com.jhlee.kmmtest.coin.domain

import com.jhlee.kmmtest.core.domain.Resource
import com.jhlee.kmmtest.test.domain.Test
import kotlinx.coroutines.flow.Flow

interface CoinDataSource {
    fun getCoinList(): Flow<Resource<List<Coin>>>
}