package com.techmeskills.an16.homework04

import android.app.Application
import android.content.Context
import com.techmeskills.an16.homework04.di.DaggerDatabaseComponent
import com.techmeskills.an16.homework04.di.DataBaseModule
import com.techmeskills.an16.homework04.di.DatabaseComponent

class App : Application() {
    lateinit var daggerComponent: DatabaseComponent
    override fun onCreate() {
        super.onCreate()
        daggerComponent =
            DaggerDatabaseComponent.builder().dataBaseModule(DataBaseModule(this)).build()
    }
}

fun Context.getAppComponent(): DatabaseComponent {
    return when (this) {
        is App -> daggerComponent
        else -> (this.applicationContext as App).daggerComponent
    }
}