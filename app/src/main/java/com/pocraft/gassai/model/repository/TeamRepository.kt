package com.pocraft.gassai.model.repository

import com.pocraft.gassai.model.Team
import com.pocraft.gassai.model.dao.TeamDao

class TeamRepository(private val teamDao: TeamDao) {
//    val allTeams = teamDao.getAll()
    suspend fun getAll() = teamDao.getAll()

    suspend fun insertAll(teams: List<Team>) {
        teamDao.insertAll(teams)
    }

    suspend fun insert(team: Team) {
        teamDao.insert(team)
    }

    fun update(team: Team) {
        teamDao.update(team)
    }
}