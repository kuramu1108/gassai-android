package com.pocraft.gassai

import android.app.Application
import com.pocraft.gassai.di.component.ApplicationComponent
import com.pocraft.gassai.di.component.DaggerApplicationComponent
import io.realm.Realm

class TheApplication: Application() {
    lateinit var component: ApplicationComponent
    override fun onCreate() {
        super.onCreate()

        setUp()
    }

    private fun setUp() {
        initRealmConfiguration()

        component = DaggerApplicationComponent.builder().build()
        component.inject(this)
    }

    private fun initRealmConfiguration() {
        Realm.init(this)

    }
}