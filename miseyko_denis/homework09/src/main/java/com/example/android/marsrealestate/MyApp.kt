package com.example.android.marsrealestate

import android.app.Application
import android.content.Context


class MyApp : Application() {


    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MyApp -> appComponent
        else -> this.applicationContext.appComponent
    }