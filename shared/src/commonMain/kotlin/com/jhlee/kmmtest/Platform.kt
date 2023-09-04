package com.jhlee.kmmtest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform