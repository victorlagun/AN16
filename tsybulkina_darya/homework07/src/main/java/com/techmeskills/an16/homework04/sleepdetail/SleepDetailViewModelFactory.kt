package com.techmeskills.an16.homework04.sleepdetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techmeskills.an16.homework04.database.SleepDatabaseDao
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

class SleepDetailViewModelFactory @AssistedInject constructor(
    private val context: Context,
    @Assisted private val sleepNightKey: Long,
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SleepDetailViewModel::class.java)) {
            return SleepDetailViewModel(context, sleepNightKey) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted sleepNightKey: Long): SleepDetailViewModelFactory
    }
}