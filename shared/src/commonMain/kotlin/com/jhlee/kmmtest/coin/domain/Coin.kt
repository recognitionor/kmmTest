package com.jhlee.kmmtest.coin.domain

data class Coin(
    val id: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)