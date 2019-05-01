package com.pocraft.gassai.di.module

import com.pocraft.gassai.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule () {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}