package com.techmeskills.an16.tsybulkiina_darya.homework09.di

import com.techmeskills.an16.tsybulkiina_darya.homework09.MainActivity
import com.techmeskills.an16.tsybulkiina_darya.homework09.overview.OverviewViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModel::class])
interface RetrofitComponent {
    fun injecty(view: OverviewViewModel)
}