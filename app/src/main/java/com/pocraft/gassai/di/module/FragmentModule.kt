package com.pocraft.gassai.di.module

import com.pocraft.gassai.view.fragment.*
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

    @ContributesAndroidInjector
    abstract fun bindFeedFragment(): FeedFragment
}