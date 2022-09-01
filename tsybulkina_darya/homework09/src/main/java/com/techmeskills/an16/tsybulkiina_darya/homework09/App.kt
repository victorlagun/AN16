package com.techmeskills.an16.tsybulkiina_darya.homework09

import android.app.Application
import android.content.Context
import com.techmeskills.an16.tsybulkiina_darya.homework09.di.DaggerRetrofitComponent
import com.techmeskills.an16.tsybulkiina_darya.homework09.di.RetrofitComponent

class App:Application() {
    lateinit var appComponent: RetrofitComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerRetrofitComponent.create()
    }
}

fun Context.getAppComponent(): RetrofitComponent{
    return when(this){
        is App -> appComponent
        else -> (this.applicationContext as App).appComponent
    }
}