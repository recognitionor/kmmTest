package com.jhlee.kmmtest

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.jhlee.kmmtest.coin.presentation.CoinListScreen
import com.jhlee.kmmtest.core.data.KtorClientFactory
import com.jhlee.kmmtest.core.presentation.getString
import com.jhlee.kmmtest.core.util.Logger
import com.jhlee.kmmtest.di.AppModule
import com.jhlee.kmmtest.test.domain.Test
import com.jhlee.kmmtest.test.presentation.TestScreen
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(appModule: AppModule) {
    Scaffold {
        CoinListScreen()

    }
}