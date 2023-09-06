package com.jhlee.kmmtest.core.data

import com.jhlee.kmmtest.TestDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(TestDatabase.Schema, "test.db")
    }
}