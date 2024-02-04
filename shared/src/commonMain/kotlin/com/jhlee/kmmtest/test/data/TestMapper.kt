package com.jhlee.kmmtest.test.data

import com.jhlee.kmmtest.test.domain.Test
import migrations.TestEntity

suspend fun TestEntity.toTest(): Test {
    return Test(id = id, name = name, number = number.toInt())
}
//import migrations.TestEntity2

//suspend fun TestEntity2.toTest2(): Test2 {
//    return Test2(id = id, name = name, count = count?.toInt() ?: 0)
//}

