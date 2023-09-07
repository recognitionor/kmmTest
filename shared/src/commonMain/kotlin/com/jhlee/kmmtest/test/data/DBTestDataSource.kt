package com.jhlee.kmmtest.test.data

import com.jhlee.kmmtest.test.domain.Test
import com.jhlee.kmmtest.test.domain.TestDataSource
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.supervisorScope
import com.jhlee.kmmtest.TestDatabase

class DBTestDataSource(
    db: TestDatabase
) : TestDataSource {
    private val queries = db.testQueries

    override fun getTestList(): Flow<List<Test>> {
        return queries.getTestList().asFlow().mapToList().map { testList ->
            supervisorScope {
                testList.map {
                    async { it.toTest() }
                }.map { it.await() }
            }
        }
    }

    override fun insertTest(test: Test) {
        queries.insertTestEntity(test.name)
    }
}