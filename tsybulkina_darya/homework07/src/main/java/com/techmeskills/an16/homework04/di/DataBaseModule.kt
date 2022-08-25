package com.techmeskills.an16.homework04.di

import android.content.Context
import androidx.room.Room
import com.techmeskills.an16.homework04.database.SleepDatabase
import com.techmeskills.an16.homework04.database.SleepDatabaseDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule(private var context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideDatabase(context: Context):SleepDatabase{
        return Room.databaseBuilder(
            context.applicationContext,
            SleepDatabase::class.java,
            "sleep_history_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideDBDao(db:SleepDatabase):SleepDatabaseDao{
        return db.sleepDatabaseDao
    }
}