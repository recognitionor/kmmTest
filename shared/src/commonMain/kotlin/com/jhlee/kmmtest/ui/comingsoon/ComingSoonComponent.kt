package com.jhlee.kmmtest.ui.comingsoon

import com.arkivanov.decompose.ComponentContext

class ComingSoonComponent(
    componentContext: ComponentContext,
    private val output: (Output) -> Unit
): ComponentContext by componentContext {

    fun onOutput(output: Output) {
        output(output)
    }

    sealed class Output {
        object NavigateBack : Output()
    }

}