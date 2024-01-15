package com.jhlee.kmmtest.test.domain

import kotlinx.coroutines.flow.Flow

interface TestDataSource {
    suspend fun getTestList(): Flow<List<Test>>
    suspend fun insertTest(test: Test)
}