package com.pocraft.gassai.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

fun <T, A> networkBoundLiveData(databaseQuery: () -> LiveData<T>,
                                shouldFetch: suspend () -> Boolean,
                                networkCall: suspend () -> Deferred<Response<A>>,
                                saveCallResult: suspend (A) -> Unit):LiveData<Result<T>> =
    liveData(Dispatchers.IO) {
        emit(Result.loading<T>())
        val source = databaseQuery.invoke().map { Result.success(it) }
        emitSource(source)
        if (shouldFetch.invoke()) {
            emit(Result.loading<T>())
            val response = networkCall.invoke().await()
            if (response.isSuccessful) {
                saveCallResult(response.body()!!)
                val source = databaseQuery.invoke().map { Result.success(it) }
                emitSource(source)
            } else {
                emit(Result.error<T>(response.errorBody()?.string() ?: "unknown error"))
                val source = databaseQuery.invoke().map { Result.success(it) }
                emitSource(source)
            }
        }
    }