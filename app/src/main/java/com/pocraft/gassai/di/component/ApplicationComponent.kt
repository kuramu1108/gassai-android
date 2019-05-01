package com.pocraft.gassai.di.component

import com.pocraft.gassai.TheApplication
import com.pocraft.gassai.di.module.ActivityModule
import com.pocraft.gassai.di.module.ApplicationModule
import com.pocraft.gassai.di.module.DatabaseModule
import com.pocraft.gassai.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityModule::class, DatabaseModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: TheApplication)

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun applicationBind(application: TheApplication): Builder
    }
}