package com.jhlee.kmmtest.core.data

import android.content.Context
import com.jhlee.kmmtest.TestDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(
            TestDatabase.Schema, context, "test.db"
        )
    }
}