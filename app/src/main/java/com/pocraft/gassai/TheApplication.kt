package com.pocraft.gassai

import android.app.Application
import com.pocraft.gassai.di.component.ApplicationComponent
import com.pocraft.gassai.di.component.DaggerApplicationComponent
import com.pocraft.gassai.di.module.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class TheApplication: Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        setUp()
    }

    private fun setUp() {
        appComponent = DaggerApplicationComponent.factory()
            .create(application = this,
                networkModule = NetworkModule("https://po-quick-server.herokuapp.com"))

//        appComponent = DaggerApplicationComponent.builder()
//            .applicationBind(this)
//            .netWorkModuleBind(NetworkModule("https://api.github.com"))
//            .build()
        appComponent.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}