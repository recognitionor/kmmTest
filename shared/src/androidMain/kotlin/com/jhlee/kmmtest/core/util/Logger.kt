package com.jhlee.kmmtest.core.util

import android.os.Build
import android.util.Log

actual class Logger actual constructor() {
    actual fun log(message: String) {
        Log.d("jhlee", message)
    }
}