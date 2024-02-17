package com.jhlee.kmmtest.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jhlee.kmmtest.ui.root.RootComponent
import com.jhlee.kmmtest.ui.root.RootContent
import com.jhlee.kmmtest.ui.theme.PokedexTheme

@Composable
fun ContentView(component: RootComponent) {
    PokedexTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RootContent(component)
        }
    }
}