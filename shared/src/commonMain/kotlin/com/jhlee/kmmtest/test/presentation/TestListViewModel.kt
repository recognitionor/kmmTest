package com.jhlee.kmmtest.test.presentation

import com.jhlee.kmmtest.core.domain.Resource
import com.jhlee.kmmtest.core.util.Logger
import com.jhlee.kmmtest.test.domain.Test
import com.jhlee.kmmtest.test.domain.TestDataSource
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class TestListViewModel(private val testDataSource: TestDataSource) : ViewModel() {

    private val _state = MutableStateFlow(TestListState())
    val state = _state.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), _state.value)

    fun add(test: Test) {
        testDataSource.insertTest(test).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    getList()
                }

                is Resource.Loading -> {}
                is Resource.Error -> {}
            }
        }.launchIn(viewModelScope)
    }

    fun delete(test: Test) {
        testDataSource.deleteTest(test).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    getList()
                }

                is Resource.Loading -> {}
                is Resource.Error -> {}
            }
        }.launchIn(viewModelScope)
    }

    fun getList() {
        testDataSource.getTestList().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Logger.log("result ${result.data}")
                    _state.update { it.copy(testList = result.data ?: emptyList()) }
                }

                is Resource.Loading -> {}
                is Resource.Error -> {}
            }
        }.launchIn(viewModelScope)
    }
}