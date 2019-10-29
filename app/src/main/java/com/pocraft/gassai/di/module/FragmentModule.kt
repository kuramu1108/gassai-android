package com.pocraft.gassai.di.module

import com.pocraft.gassai.view.fragment.HomeFragment
import com.pocraft.gassai.view.fragment.ReminderFragment
import com.pocraft.gassai.view.fragment.TeamFragment
import com.pocraft.gassai.view.fragment.TimeTableFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun bindTeamFragment(): TeamFragment

    @ContributesAndroidInjector
    abstract fun bindTimeTableFragment(): TimeTableFragment

    @ContributesAndroidInjector
    abstract fun bindReminderFragment(): ReminderFragment
}