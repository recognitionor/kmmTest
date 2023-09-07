package com.jhlee.kmmtest.coin.data

import com.jhlee.kmmtest.coin.domain.Coin
import com.jhlee.kmmtest.coin.domain.CoinDataSource
import com.jhlee.kmmtest.core.domain.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SqlDelightCoinDataSource : CoinDataSource {
    override fun getCoinList(): Flow<Resource<List<Coin>>> {
        return flow { }
    }
}