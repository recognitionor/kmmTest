package com.jhlee.kmmtest.test.data

import com.jhlee.kmmtest.test.domain.Test
import database.TestEntity

suspend fun TestEntity.toTest(): Test {
    return Test(id = id, name = name)
}