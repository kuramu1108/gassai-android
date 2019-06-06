package com.pocraft.gassai.viewmodel

import androidx.lifecycle.MutableLiveData
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

    val repoSize = MutableLiveData(0)

    fun getRepo() = runBlocking {
        repoSize.value = apiService.getRepository("kuramu1108").await().size
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}