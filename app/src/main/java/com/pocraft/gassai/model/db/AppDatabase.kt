package com.pocraft.gassai.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.model.dao.TeamDao

@Database(entities = arrayOf(Team::class, TableVersion::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun teamDao(): TeamDao
}