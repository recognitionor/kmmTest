package com.jhlee.kmmtest

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.jhlee.kmmtest.di.AppModule
import com.jhlee.kmmtest.test.presentation.DBTestScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(appModule: AppModule) {
    Scaffold {
        DBTestScreen(appModule)
    }
}