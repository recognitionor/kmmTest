package com.jhlee.kmmtest.core.util

actual object Logger {
    actual fun log(message: String) {
        println("jhlee: $message") // Swift에서 print 함수 사용
    }
}