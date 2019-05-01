package com.pocraft.gassai

import android.app.Activity
import android.app.Application
import com.pocraft.gassai.di.component.ApplicationComponent
import com.pocraft.gassai.di.component.DaggerApplicationComponent
import com.pocraft.gassai.di.module.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import javax.inject.Inject

class TheApplication: Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        setUp()
    }

    private fun setUp() {
        initRealmConfiguration()

        appComponent = DaggerApplicationComponent.builder()
            .applicationBind(this)
            .netWorkModuleBind(NetworkModule("https://api.github.com"))
            .build()
        appComponent.inject(this)
    }

    private fun initRealmConfiguration() {
        Realm.init(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}