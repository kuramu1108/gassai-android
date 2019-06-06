package com.pocraft.gassai.di.module

import com.pocraft.gassai.view.fragment.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment
}