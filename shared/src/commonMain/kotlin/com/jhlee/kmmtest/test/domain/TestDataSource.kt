package com.jhlee.kmmtest.test.domain

import com.jhlee.kmmtest.core.domain.Resource
import kotlinx.coroutines.flow.Flow

interface TestDataSource {
    fun getTestList(): Flow<Resource<List<Test>>>
    fun insertTest(test: Test): Flow<Resource<Unit>>
    fun deleteTest(test: Test): Flow<Resource<Unit>>
}