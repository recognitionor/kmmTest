package com.jhlee.kmmtest.test.presentation

import com.jhlee.kmmtest.core.util.Logger
import com.jhlee.kmmtest.test.domain.Test
import com.jhlee.kmmtest.test.domain.TestDataSource
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TestListViewModel(private val testDataSource: TestDataSource) : ViewModel() {

    private val _state = MutableStateFlow(TestListState())
    val state = _state.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), _state.value)

    fun onEvent(event: TestEvent) {
        when (event) {
            TestEvent.OnTestClick -> {
                Logger().log("test")
                viewModelScope.launch {
                    testDataSource.insertTest(Test(0, "test"))
                }
                println("test")
            }
        }
    }

}