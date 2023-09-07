package com.jhlee.kmmtest.coin.presentation

import com.jhlee.kmmtest.coin.data.CoinDto
import com.jhlee.kmmtest.coin.domain.CoinDataSource
import com.jhlee.kmmtest.core.data.KtorClientFactory
import com.jhlee.kmmtest.core.domain.Resource
import com.jhlee.kmmtest.core.util.Logger
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CoinListViewModel(private val coinDataSource: CoinDataSource) : ViewModel() {
    companion object {
        const val VIEWMODEL_KEY = "coin_list_view_model"
    }

    private val _state = MutableStateFlow(CoinListState())
    val state = combine(_state, coinDataSource.getCoinList()) { state, data ->
        when (data) {
            is Resource.Error -> {
                Logger.log("error ${data.message}")
                state.copy(isLoading = false, error = data.message ?: "error")
            }

            is Resource.Loading -> {
                Logger.log("loading")
                state.copy(isLoading = true)
            }

            is Resource.Success -> {
                Logger.log("success  : ${data.data}")
                state.copy(coins = data.data ?: emptyList())
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), CoinListState())
}