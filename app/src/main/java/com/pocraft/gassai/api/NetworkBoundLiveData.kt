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
        if (shouldFetch.invoke()) {

            val response = networkCall.invoke().await()
            emit(Result.loading<T>())
            if (response.isSuccessful) {
                saveCallResult(response.body()!!)
                val source = databaseQuery.invoke().map { Result.success(it) }
                emitSource(source)
            } else {
                emit(Result.error<T>(response.errorBody()?.string() ?: "unknown error"))
                val source = databaseQuery.invoke().map { Result.success(it) }
                emitSource(source)
            }
        } else {
            val source = databaseQuery.invoke().map { Result.success(it) }
            emitSource(source)
        }
    }