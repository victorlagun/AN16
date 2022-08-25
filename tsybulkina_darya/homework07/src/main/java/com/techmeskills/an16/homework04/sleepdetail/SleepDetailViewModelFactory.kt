package com.techmeskills.an16.homework04.sleepdetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techmeskills.an16.homework04.database.SleepDatabaseDao

class SleepDetailViewModelFactory(
    private val context: Context,
    private val sleepNightKey: Long,
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SleepDetailViewModel::class.java)) {
            return SleepDetailViewModel(context, sleepNightKey) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}