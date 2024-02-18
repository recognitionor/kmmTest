package com.jhlee.kmmtest.ui

import androidx.compose.runtime.Composable
import com.jhlee.kmmtest.ui.root.RootComponent
import com.jhlee.kmmtest.ui.root.RootContent

@Composable
internal fun ContentView(
    component: RootComponent,
) {
    RootContent(component)

}