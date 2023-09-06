package com.jhlee.kmmtest.core.util

actual class Logger actual constructor() {
    actual fun log(message: String) {
        println("jhlee: $message") // Swift에서 print 함수 사용
    }
}