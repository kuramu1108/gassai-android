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
    ActivityModule::class,
    FragmentModule::class,
    DatabaseModule::class,
    ViewModelModule::class,
    NetworkModule::class])
interface ApplicationComponent {
    fun inject(application: TheApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application, networkModule: NetworkModule): ApplicationComponent
    }
//    @Component.Builder
//    interface Builder {
//        fun build(): ApplicationComponent
//
//        @BindsInstance
//        fun applicationBind(application: Application): Builder
//
//        fun netWorkModuleBind(networkModule: NetworkModule): Builder
//    }
}