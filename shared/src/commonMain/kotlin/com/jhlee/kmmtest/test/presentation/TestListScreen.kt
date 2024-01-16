package com.jhlee.kmmtest.test.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jhlee.kmmtest.di.AppModule
import com.jhlee.kmmtest.test.domain.Test
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun TestScreen(appModule: AppModule) {

    val viewModel = getViewModel(key = "test-list-screen",
        factory = viewModelFactory { TestListViewModel(appModule.testDataSource) })
    val state by viewModel.state.collectAsState()
    Column {
        Row {
            Button({
                viewModel.add(Test(0, "test"))
            }) {
                Text("add")
            }

            Button({
                viewModel.getList()
            }) {
                Text("getList")
            }
        }

        LazyColumn {
            items(state.testList.size) {
                val test = state.testList[it]
                Text(text = test.toString(),
                    modifier = Modifier.height(50.dp).fillMaxWidth().clickable {
                        viewModel.delete(test)
                    })
            }
        }
    }
}