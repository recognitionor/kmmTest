package com.jhlee.kmmtest.coin.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.jhlee.kmmtest.coin.data.RemoteCoinDataSource
import com.jhlee.kmmtest.core.data.KtorClientFactory
import com.jhlee.kmmtest.core.util.Logger
import com.jhlee.kmmtest.test.presentation.TestListViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun CoinListScreen() {
    val viewModel = getViewModel(key = CoinListViewModel.VIEWMODEL_KEY,
        factory = viewModelFactory { CoinListViewModel(RemoteCoinDataSource(KtorClientFactory.build())) })
    val state by viewModel.state.collectAsState()
    Column {
        LazyColumn {
            items(state.coins) { test ->
                Row {
                    Text(text = test.name)
                    Text(text = "!!")
                }
            }
        }
    }
}
