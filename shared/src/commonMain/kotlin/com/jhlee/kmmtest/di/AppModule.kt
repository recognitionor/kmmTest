package com.jhlee.kmmtest.di

import com.jhlee.kmmtest.coin.domain.CoinDataSource
import com.jhlee.kmmtest.test.domain.TestDataSource


expect class AppModule {
    val dbTestDataSource: TestDataSource

    val remoteCoinDataSource: CoinDataSource
}