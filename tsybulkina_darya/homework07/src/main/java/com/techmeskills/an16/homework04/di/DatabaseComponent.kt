package com.techmeskills.an16.homework04.di

import androidx.lifecycle.ViewModel
import com.techmeskills.an16.homework04.sleepdetail.SleepDetailFragment
import com.techmeskills.an16.homework04.sleepdetail.SleepDetailViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DataBaseModule::class, NetworkModule::class])
@Singleton
interface DatabaseComponent {

    fun inject(fragment: SleepDetailFragment)
}