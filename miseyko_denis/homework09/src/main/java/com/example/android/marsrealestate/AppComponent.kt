package com.example.android.marsrealestate

import com.example.android.marsrealestate.di.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {

    fun inject(app: MyApp)
}