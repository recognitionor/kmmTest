package com.jhlee.kmmtest.test.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jhlee.kmmtest.core.util.Logger
import com.jhlee.kmmtest.di.AppModule
import com.jhlee.kmmtest.test.domain.Test
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun DBTestScreen(appModule: AppModule) {

    val viewModel = getViewModel(key = "test-list-screen",
        factory = viewModelFactory { TestListViewModel(appModule.testDataSource) })
    val state by viewModel.state.collectAsState()
    Column {
        Row {
            Button({
                viewModel.add(Test(0, "test", 1))
            }) {
                Text("add")
            }

            Button({
                viewModel.getList()
            }) {
                Text("getList")
            }
        }
        val click = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = CustomIndication

        ) {
            Logger.log("test")
        }
        Column(
            modifier = Modifier.border(
                width = 4.dp, color = Color.Black, shape = RoundedCornerShape(84.dp)
            )
        ) {
            Row(modifier = Modifier.height(60.dp).width(200.dp)
                .clip(shape = RoundedCornerShape(84.dp)).clickable { }
                .background(color = Color.LightGray, shape = RoundedCornerShape(84.dp))) {
                // 내용
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