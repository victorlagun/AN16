package com.example.android.marsrealestate.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModel::class])
interface RetrofitComponent {
    fun inject()
}