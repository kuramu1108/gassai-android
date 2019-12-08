package com.pocraft.gassai.di.module

import android.app.Application
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pocraft.gassai.api.ApiService
import com.pocraft.gassai.model.dao.TeamDao
import com.pocraft.gassai.model.db.AppDatabase
import com.pocraft.gassai.model.repository.TeamRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(
            app,
            AppDatabase::class.java, "gassai.db")
//            .addMigrations(
//                MIGRATION_1_2,
//                MIGRATION_2_3)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    @Singleton
    @Provides
    fun provideTeamDao(db: AppDatabase): TeamDao =
        db.teamDao()

    @Singleton
    @Provides
    fun provideTeamRepository(dao: TeamDao, api: ApiService): TeamRepository =
        TeamRepository(dao, api)
}