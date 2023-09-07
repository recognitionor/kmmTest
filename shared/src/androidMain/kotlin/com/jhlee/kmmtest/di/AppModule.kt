package com.jhlee.kmmtest.di

import android.content.Context
import com.jhlee.kmmtest.TestDatabase
import com.jhlee.kmmtest.coin.data.RemoteCoinDataSource
import com.jhlee.kmmtest.coin.domain.CoinDataSource
import com.jhlee.kmmtest.core.data.DatabaseDriverFactory
import com.jhlee.kmmtest.core.data.KtorClientFactory
import com.jhlee.kmmtest.test.data.DBTestDataSource
import com.jhlee.kmmtest.test.domain.TestDataSource

actual class AppModule(
    private val context: Context
) {

    actual val dbTestDataSource: TestDataSource by lazy {
        DBTestDataSource(
            db = TestDatabase(
                driver = DatabaseDriverFactory(context).create(),
            ),
        )
    }
    actual val remoteCoinDataSource: CoinDataSource by lazy {
        RemoteCoinDataSource(KtorClientFactory.build())
    }
}