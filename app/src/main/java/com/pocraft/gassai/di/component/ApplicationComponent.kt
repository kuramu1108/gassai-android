package com.pocraft.gassai.di.component

import android.app.Application
import com.pocraft.gassai.TheApplication
import com.pocraft.gassai.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
//    ApplicationModule::class,
    ActivityModule::class,
    DatabaseModule::class,
    ViewModelModule::class,
    NetworkModule::class])
interface ApplicationComponent {
    fun inject(application: TheApplication)

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun applicationBind(application: Application): Builder

//        @BindsInstance
        fun netWorkModuleBind(networkModule: NetworkModule): Builder
    }
}