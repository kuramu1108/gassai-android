package com.pocraft.gassai.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pocraft.gassai.model.Team

// ref https://medium.com/@marco_cattaneo/integrate-dagger-2-with-room-persistence-library-in-few-lines-abf48328eaeb

@Dao
interface TeamDao {
    @Query("SELECT * FROM teams ORDER BY id ASC")
    suspend fun getAll(): List<Team>
//    fun getAll(): LiveData<List<Team>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(team: Team)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(teams: List<Team>)

    @Query("SELECT * FROM teams WHERE id = :teamId")
    fun getTeam(teamId: Int): LiveData<Team>

    @Update
    fun update(team: Team)
}