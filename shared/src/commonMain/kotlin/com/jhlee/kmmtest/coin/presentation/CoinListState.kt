package com.jhlee.kmmtest.coin.presentation

import com.jhlee.kmmtest.coin.domain.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
