package com.pocraft.gassai.model.repository

import android.util.Log
import com.pocraft.gassai.api.ApiService
import com.pocraft.gassai.api.networkBoundLiveData
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.model.dao.TeamDao
import com.pocraft.gassai.model.db.TableVersion
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.lang.Exception

class TeamRepository(private val teamDao: TeamDao, private val api:ApiService) {
//    val allTeams = teamDao.getAll()
    suspend fun getAll() = teamDao.getAll()

    fun getAllTeams() = networkBoundLiveData(
        databaseQuery = { teamDao.getAll() },
        shouldFetch = { shouldFetch() },
        networkCall = { api.getAllTeams() },
        saveCallResult = { teamDao.insertAll(it) }
    )

    suspend fun insertAll(teams: List<Team>) {
        teamDao.insertAll(teams)
    }

    suspend fun insert(team: Team) {
        teamDao.insert(team)
    }

    fun update(team: Team) {
        teamDao.update(team)
    }

    private suspend fun shouldFetch(): Boolean {
        var result = false
//        try {
        val remote = api.getTeamVersion().await().version
        if (teamDao.getTableVersion() == null) {
            teamDao.insertTableVersion(TableVersion(0, "teams", 0))
        }
        val local = teamDao.getTableVersion()?.version
//        } catch (e: Exception) {
//            Log.v("Error", e.message)
//        }
        return remote != local
    }
}