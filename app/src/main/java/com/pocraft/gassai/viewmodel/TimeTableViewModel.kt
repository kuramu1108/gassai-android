package com.pocraft.gassai.viewmodel

import com.pocraft.gassai.api.ApiService
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class TimeTableViewModel @Inject constructor(): BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

    @Inject
    lateinit var apiService: ApiService

    private val job = Job() + coroutineContext

    fun getName() = "it works"

    fun getRepo() = runBlocking {
        apiService.getRepository("kuramu1108").await().size
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}