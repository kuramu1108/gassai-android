package com.pocraft.gassai.di.module

import com.pocraft.gassai.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule () {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}