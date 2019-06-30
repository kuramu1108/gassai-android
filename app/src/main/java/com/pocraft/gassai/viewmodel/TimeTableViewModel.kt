package com.pocraft.gassai.viewmodel

import androidx.lifecycle.MutableLiveData
import com.pocraft.gassai.api.ApiService
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.model.TimeTable
import kotlinx.coroutines.*
import java.time.LocalDate
import java.time.LocalTime
import java.time.Month
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class TimeTableViewModel @Inject constructor(): BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

    @Inject
    lateinit var apiService: ApiService

    private val job = Job() + coroutineContext

    val teamList = arrayListOf(
        Team(0, "abc", "JAP", 5, "longtexxt"),
        Team(1, "s", "JAP", 5, "longtexxt"),
        Team(2, "abcsd", "JAP", 5, "longtexxt"),
        Team(3, "abcddd", "JAP", 5, "l"),
        Team(4, "cc_c", "JAP", 5, "longtexsfdgsdfgsdfgxtasdfa"),
        Team(5, "abcddd", "JAP", 5, "l"),
        Team(6, "abcddd", "JAP", 5, "l"),
        Team(7, "abcddd", "JAP", 5, "l"),
        Team(8, "abcddd", "JAP", 5, "l"),
        Team(9, "abcddd", "JAP", 5, "l")
    )

    val date1 = LocalDate.of(2019, Month.MARCH, 30)
    val date2 = LocalDate.of(2019, Month.MARCH, 31)
    val time1 = LocalTime.of(9, 0)
    val timeTableList = arrayListOf(
        TimeTable(0, null, null, date1, time1, "")
    )

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