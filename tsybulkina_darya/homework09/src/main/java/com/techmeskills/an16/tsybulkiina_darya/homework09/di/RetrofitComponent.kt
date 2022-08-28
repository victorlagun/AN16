package com.techmeskills.an16.tsybulkiina_darya.homework09.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModel::class])
interface RetrofitComponent {
    fun inject()
}