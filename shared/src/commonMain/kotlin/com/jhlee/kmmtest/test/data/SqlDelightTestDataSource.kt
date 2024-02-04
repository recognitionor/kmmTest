package com.jhlee.kmmtest.test.data

import com.jhlee.kmmtest.TestDatabase
import com.jhlee.kmmtest.core.domain.Resource
import com.jhlee.kmmtest.core.util.Logger
import com.jhlee.kmmtest.test.domain.Test
import com.jhlee.kmmtest.test.domain.TestDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SqlDelightTestDataSource(
    db: TestDatabase,
) : TestDataSource {
    private val queries = db.testQueries

    override fun getTestList(): Flow<Resource<List<Test>>> = flow {
        emit(Resource.Loading())
        val list = queries.getTestList().executeAsList()
        val testList = queries.getPlayerList().executeAsList()
//        val list2 = queries.getTestList2().executeAsList()
        Logger.log("list : $list")
        Logger.log("testList : $testList")

//        Logger.log("list2 : $list2")
        emit(Resource.Success(list.map { it.toTest() }))
    }

    override fun insertTest(test: Test): Flow<Resource<Unit>> = flow {
        queries.insertTestEntity(test.name, 9, 1000)
        queries.insertPlayer(0, "MF")
//        queries.insertTest(test.name)
        emit(Resource.Success(Unit))
    }

    override fun deleteTest(test: Test): Flow<Resource<Unit>> = flow {
        test.id?.let {
            queries.deleteTest(it)
        }
        emit(Resource.Success(Unit))
    }
}