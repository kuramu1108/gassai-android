package com.pocraft.gassai.di.module

import android.app.Application
import androidx.room.Room
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
//            .addCallback(object : RoomDatabase.Callback() {
//                override fun onOpen(db: SupportSQLiteDatabase) {
//                    super.onOpen(db)
//                    if (db.version == 1) {
//
//                    }
//                }
//            })
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
    fun provideTeamRepository(dao: TeamDao): TeamRepository =
        TeamRepository(dao)
}