package com.jhlee.kmmtest.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.jhlee.kmmtest.core.di.initKoin
import com.jhlee.kmmtest.ui.ContentView
import com.jhlee.kmmtest.ui.root.RootComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.stopKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initKoin(
            enableNetworkLogs = BuildConfig.DEBUG
        ) {
            androidContext(applicationContext)
        }

        val rootComponent =
            RootComponent(
                componentContext = defaultComponentContext(),
                storeFactory = DefaultStoreFactory(),
            )

        setContent {
            ContentView(component = rootComponent)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }
}
