package com.pocraft.gassai.di.module

import android.app.Application
import com.pocraft.gassai.TheApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: TheApplication) {
    @Provides
    @Singleton
    fun provideApplication(): Application {
        return app
    }
}