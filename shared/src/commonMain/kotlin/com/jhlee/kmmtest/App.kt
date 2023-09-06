package com.jhlee.kmmtest

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.jhlee.kmmtest.core.presentation.getString
import com.jhlee.kmmtest.di.AppModule
import com.jhlee.kmmtest.test.presentation.TestScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(appModule: AppModule) {
    Scaffold {
        TestScreen(appModule)
    }
}