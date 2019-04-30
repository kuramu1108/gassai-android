package com.pocraft.gassai.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration

@Module
class DatabaseModule {
    @Provides
    fun provideRealm(context: Context): Realm {
        Realm.init(context)
        val config = RealmConfiguration.Builder().apply {
            name("matsuri.realm")
        }.build()
        return Realm.getInstance(config)
    }
}