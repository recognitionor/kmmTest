package com.jhlee.kmmtest.core.network.helper

import com.jhlee.kmmtest.core.network.errors.PokedexError
import com.jhlee.kmmtest.core.network.errors.PokedexException
import com.jhlee.kmmtest.pokedexDispatchers
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.withContext

suspend inline fun <reified T> handleErrors(
    crossinline response: suspend () -> HttpResponse
): T = withContext(pokedexDispatchers.io) {

    val result = try {
        response()
    } catch(e: IOException) {
        throw PokedexException(PokedexError.ServiceUnavailable)
    }

    when(result.status.value) {
        in 200..299 -> Unit
        in 400..499 -> throw PokedexException(PokedexError.ClientError)
        500 -> throw PokedexException(PokedexError.ServerError)
        else -> throw PokedexException(PokedexError.UnknownError)
    }

    return@withContext try {
        result.body()
    } catch(e: Exception) {
        throw PokedexException(PokedexError.ServerError)
    }

}