package com.techmeskills.an16.homework04.sleepdetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techmeskills.an16.homework04.database.SleepDatabase
import com.techmeskills.an16.homework04.database.SleepDatabaseDao
import com.techmeskills.an16.homework04.network.RealEstateService
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

class SleepDetailViewModelFactory @AssistedInject constructor(
    private val context: Context,
    private val database: SleepDatabaseDao,
    private val networkService: RealEstateService,
    @Assisted private val sleepNightKey: Long,
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SleepDetailViewModel::class.java)) {
            return SleepDetailViewModel(context, database, networkService, sleepNightKey) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted sleepNightKey: Long): SleepDetailViewModelFactory
    }
}