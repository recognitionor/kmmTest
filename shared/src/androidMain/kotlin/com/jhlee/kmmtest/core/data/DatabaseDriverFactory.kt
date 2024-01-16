package com.jhlee.kmmtest.core.data

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.jhlee.kmmtest.TestDatabase


actual class DatabaseDriverFactory(
    private val context: Context,
) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(

            TestDatabase.Schema, context, "test.db"
        )
    }


}