package com.jhlee.kmmtest.core.di

import com.jhlee.kmmtest.core.database.di.databaseModule
import com.jhlee.kmmtest.core.network.di.networkModule
import com.jhlee.kmmtest.data.di.dataModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            databaseModule,
            networkModule(enableNetworkLogs),
            dataModule
        )
    }