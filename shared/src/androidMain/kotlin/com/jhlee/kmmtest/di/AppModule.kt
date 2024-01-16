package com.jhlee.kmmtest.di

import android.content.Context
import app.cash.sqldelight.db.AfterVersion
import com.jhlee.kmmtest.TestDatabase
import com.jhlee.kmmtest.core.data.DatabaseDriverFactory
import com.jhlee.kmmtest.core.util.Logger
import com.jhlee.kmmtest.test.data.SqlDelightTestDataSource
import com.jhlee.kmmtest.test.domain.TestDataSource

actual class AppModule(
    private val context: Context,
) {
    private val driver = DatabaseDriverFactory(context).create()

    init {
        Logger.log("init :  ${TestDatabase.Schema.version}")
//        TestDatabase.Schema.migrate(driver = driver,
//            oldVersion = 1,
//            newVersion = TestDatabase.Schema.version,
//            AfterVersion(2) { driver ->
//                Logger.log("play~~")
////                driver.execute(null, "INSERT INTO test (value) VALUES('hello')", 0)
//            })

        Logger.log("TestDatabase.Schema.version : ${TestDatabase.Schema.version}")

    }

    actual val testDataSource: TestDataSource by lazy {

        SqlDelightTestDataSource(
            db = TestDatabase(
                driver = driver,
            ),
        )
    }
}