package com.pocraft.gassai.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pocraft.gassai.api.ApiService
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.model.TimeTable
import com.pocraft.gassai.model.repository.TeamRepository
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

    @Inject
    lateinit var teamRepository: TeamRepository

    private val job = Job() + coroutineContext

    val teamList = arrayListOf(
        Team(0, "abc", "JAP", 5, "longtexxt", false),
        Team(1, "s", "JAP", 5, "longtexxt", false),
        Team(2, "abcsd", "JAP", 5, "longtexxt", false),
        Team(3, "abcddd", "JAP", 5, "l", false),
        Team(4, "cc_c", "JAP", 5, "longtexsfdgsdfgsdfgxtasdfa", false),
        Team(5, "abcddd", "JAP", 5, "l", false),
        Team(6, "abcddd", "JAP", 5, "l", false),
        Team(7, "abcddd", "JAP", 5, "l", false),
        Team(8, "abcddd", "JAP", 5, "l", false),
        Team(9, "abcddd", "JAP", 5, "l", false)
    )

    val date1 = LocalDate.of(2019, Month.MARCH, 30)
    val date2 = LocalDate.of(2019, Month.MARCH, 31)
    val time1 = LocalTime.of(9, 0)
    val timeTableList1 = arrayListOf(
        TimeTable(0, teamList[0], null, date1, time1, ""),
        TimeTable(1, teamList[1], null, date1, time1, ""),
        TimeTable(2, teamList[2], null, date1, time1, ""),
        TimeTable(3, teamList[3], null, date1, time1, ""),
        TimeTable(4, teamList[4], null, date1, time1, ""),
        TimeTable(5, teamList[5], null, date1, time1, ""),
        TimeTable(2, teamList[2], null, date1, time1, ""),
        TimeTable(3, teamList[3], null, date1, time1, ""),
        TimeTable(4, teamList[4], null, date1, time1, ""),
        TimeTable(5, teamList[5], null, date1, time1, "")
    )

    val timeTableList2 = arrayListOf(
        TimeTable(0, teamList[6], null, date1, time1, ""),
        TimeTable(1, teamList[7], null, date1, time1, ""),
        TimeTable(2, teamList[8], null, date1, time1, ""),
        TimeTable(3, teamList[9], null, date1, time1, "")
    )

    fun getDates() = arrayListOf(date1, date2, date2, date2, date2)

    fun getVenueList() = arrayOf(
        "熊本城", "城彩苑", "辛島",
        "上通北", "上通南", "下通二", "下通四", "銀座通", "新市街"
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

    fun getTimeTables(date: Int): ArrayList<ArrayList<TimeTable>> {
        return arrayListOf(
            timeTableList1,
            timeTableList1,
            timeTableList1,
            timeTableList1,
            timeTableList1,
            timeTableList2,
            timeTableList2,
            timeTableList2,
            timeTableList2
        )
    }

    fun populateTeams() = launch {
        teamRepository.insertAll(teamList)
    }

    fun teams() = runBlocking {
        teamRepository.getAll()
    }

    // https://medium.com/androiddevelopers/coroutines-on-android-part-i-getting-the-background-3e0e54d20bb

    fun updateTeam(team: Team) = launch {
            teamRepository.update(team)
    }
}