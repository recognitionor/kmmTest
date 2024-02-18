package com.jhlee.kmmtest

import kotlinx.coroutines.CoroutineDispatcher

interface TestDispatchers {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}

expect val testDispatchers: TestDispatchers

