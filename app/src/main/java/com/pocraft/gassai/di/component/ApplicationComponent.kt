package com.pocraft.gassai.di.component

import com.pocraft.gassai.TheApplication
import com.pocraft.gassai.di.module.ApplicationModule
import com.pocraft.gassai.di.module.DatabaseModule
import dagger.Component

@Component(modules = [ApplicationModule::class, DatabaseModule::class])
interface ApplicationComponent {
    fun inject(application: TheApplication)
}