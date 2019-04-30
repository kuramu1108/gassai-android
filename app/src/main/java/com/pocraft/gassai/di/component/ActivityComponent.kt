package com.pocraft.gassai.di.component

import com.pocraft.gassai.MainActivity
import com.pocraft.gassai.di.module.ActivityModule
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}