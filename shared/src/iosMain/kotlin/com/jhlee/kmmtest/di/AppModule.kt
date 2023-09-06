package com.jhlee.kmmtest.di

import com.jhlee.kmmtest.TestDatabase
import com.jhlee.kmmtest.core.data.DatabaseDriverFactory
import com.jhlee.kmmtest.test.data.SqlDelightTestDataSource
import com.jhlee.kmmtest.test.domain.TestDataSource

actual class AppModule {

    actual val testDataSource: TestDataSource by lazy {
        SqlDelightTestDataSource(
            db = TestDatabase(
                driver = DatabaseDriverFactory().create()
            )
        )
    }
}