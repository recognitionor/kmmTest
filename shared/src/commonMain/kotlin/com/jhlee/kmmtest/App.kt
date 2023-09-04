package com.jhlee.kmmtest

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun App() {
    Column {
        SharedRes.strings.hello_world
        Text(text = "${getString(SharedRes.strings.hello_world)} : 11")
    }
}