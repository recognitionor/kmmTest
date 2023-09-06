package com.jhlee.kmmtest.test.presentation

import com.jhlee.kmmtest.test.domain.Test

data class TestListState(
    val testList: List<Test> = emptyList()
)

