package com.jhlee.kmmtest.coin.data

import com.jhlee.kmmtest.coin.domain.Coin
import com.jhlee.kmmtest.coin.domain.CoinDataSource
import com.jhlee.kmmtest.core.domain.Resource
import com.jhlee.kmmtest.core.util.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.native.concurrent.ThreadLocal

class RemoteCoinDataSource(private val httpClient: HttpClient) : CoinDataSource {

    override fun getCoinList(): Flow<Resource<List<Coin>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val list: List<Coin> =
                    httpClient.get("https://api.coinpaprika.com/v1/coins").body<List<CoinDto>>()
                        .map { it.toCoin() }
                emit(Resource.Success(list))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }
    }
}