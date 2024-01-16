package com.jhlee.kmmtest.core.util

import android.os.Build
import android.util.Log

actual object Logger {
    actual fun log(message: String) {
        Log.d("jhlee", message)
    }
}