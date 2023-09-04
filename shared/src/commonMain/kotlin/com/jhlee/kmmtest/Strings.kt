package com.jhlee.kmmtest

import dev.icerock.moko.resources.StringResource

expect fun getString(id: StringResource, args: List<Any> = emptyList()): String
expect fun getString(id: StringResource): String