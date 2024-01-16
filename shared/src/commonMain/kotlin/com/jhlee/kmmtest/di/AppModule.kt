package com.jhlee.kmmtest.di

import com.jhlee.kmmtest.test.domain.TestDataSource


expect class AppModule {

    val testDataSource: TestDataSource
}