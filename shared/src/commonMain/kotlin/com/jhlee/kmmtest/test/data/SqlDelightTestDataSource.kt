package com.jhlee.kmmtest.test.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.jhlee.kmmtest.test.domain.Test
import com.jhlee.kmmtest.test.domain.TestDataSource
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.supervisorScope
import com.jhlee.kmmtest.TestDatabase
import kotlinx.coroutines.currentCoroutineContext

class SqlDelightTestDataSource(
    db: TestDatabase,
) : TestDataSource {
    private val queries = db.testQueries

    override suspend fun getTestList(): Flow<List<Test>> {
        return queries.getTestList().asFlow().mapToList(currentCoroutineContext()).map { testList ->
            supervisorScope {
                testList.map {
                    async { it.toTest() }
                }.map { it.await() }
            }
        }
    }

    override suspend fun insertTest(test: Test) {
        queries.insertTestEntity(test.name)
    }
}