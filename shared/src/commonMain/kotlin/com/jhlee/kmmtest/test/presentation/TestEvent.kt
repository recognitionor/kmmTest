package com.jhlee.kmmtest.test.presentation

import androidx.compose.foundation.IndicationInstance
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope

interface TestEvent {
    object OnTestClick : TestEvent
}