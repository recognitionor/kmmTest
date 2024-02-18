package com.jhlee.kmmtest.ui.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.jhlee.kmmtest.ui.main.MainComponent

class RootComponent internal constructor(
    componentContext: ComponentContext,
    private val main: (ComponentContext, (MainComponent.Output) -> Unit) -> MainComponent
) : ComponentContext by componentContext {

    constructor(
        componentContext: ComponentContext,
        storeFactory: StoreFactory,
    ) : this(componentContext = componentContext, main = { childContext, output ->
        MainComponent(
            componentContext = childContext, storeFactory = storeFactory, output = output
        )
    })

    private val navigation = StackNavigation<Configuration>()

    private val stack = childStack(
        source = navigation,
        initialConfiguration = Configuration.Main,
        handleBackButton = false,
        childFactory = ::createChild
    )

    val childStack: Value<ChildStack<*, Child>> = stack

    private fun createChild(
        configuration: Configuration, componentContext: ComponentContext
    ): Child = when (configuration) {
        is Configuration.Main -> Child.Main(main(componentContext, ::onMainOutput))
    }

    private fun onMainOutput(output: MainComponent.Output): Unit = when (output) {
        MainComponent.Output.TestClicked -> navigation.push(Configuration.Main)
    }


    private sealed class Configuration : Parcelable {
        @Parcelize
        object Main : Configuration()
    }

    sealed class Child {
        data class Main(val component: MainComponent) : Child()
    }
}