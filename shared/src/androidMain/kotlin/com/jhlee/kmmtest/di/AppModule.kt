package com.jhlee.kmmtest.di

import android.content.Context
import com.jhlee.kmmtest.TestDatabase
import com.jhlee.kmmtest.core.data.DatabaseDriverFactory
import com.jhlee.kmmtest.test.data.SqlDelightTestDataSource
import com.jhlee.kmmtest.test.domain.TestDataSource

actual class AppModule(
    private val context: Context
) {

    actual val testDataSource: TestDataSource by lazy {
        SqlDelightTestDataSource(
            db = TestDatabase(
                driver = DatabaseDriverFactory(context).create(),
            ),
        )
    }
}