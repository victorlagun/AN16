/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.techmeskills.an16.bondarenko_vadim.homework05.sleeptracker

import android.app.Application
import android.net.ipsec.ike.TransportModeChildSessionParams
import android.provider.SyncStateContract.Helpers.insert
import android.provider.SyncStateContract.Helpers.update
import android.service.autofill.Transformation
import android.text.method.TransformationMethod
import androidx.lifecycle.*
import androidx.lifecycle.Transformations.map
import com.techmeskills.an16.bondarenko_vadim.homework05.database.SleepDatabaseDao
import com.techmeskills.an16.bondarenko_vadim.homework05.database.SleepNight
import com.techmeskills.an16.bondarenko_vadim.homework05.formatNights
import kotlinx.coroutines.launch


/**
 * ViewModel for SleepTrackerFragment.
 */
class SleepTrackerViewModel(
    val database: SleepDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private val tonight = MutableLiveData<SleepNight?>()
    private val nights = database.getAllNigth()

    val nightString = Transformations.map(nights) { nights ->
        formatNights(nights, application.resources)
    }


    val startButtonVisible = Transformations.map(tonight) {
        null == it
    }
    val stopButtonVisible = Transformations.map(tonight) {
        null != it
    }
    val clearButtonVisible = Transformations.map(nights) {
        it?.isNotEmpty()
    }


    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackbarEvent: LiveData<Boolean>
        get() = _showSnackbarEvent


    private val _navigateToSleepQuality = MutableLiveData<SleepNight>()
    val navigateToSleepQuality: LiveData<SleepNight>
        get() = _navigateToSleepQuality

    fun doneShowingSnackbar(){
        _showSnackbarEvent.value = false
    }

    fun doneNavigating() {
        _navigateToSleepQuality.value = null
    }


    init {
        initializeToNight()
    }


    private fun initializeToNight() {
        viewModelScope.launch {
            tonight.value = getTonightFromDatabase()
        }

    }








    private suspend fun getTonightFromDatabase(): SleepNight? {
        var night = database.getToNight()
        if (night?.endTimeMilli != night?.startTimeMilli) {
            night == null
        }
        return night
    }



    private suspend fun insert(night: SleepNight) {
        database.insert(night)
    }

    private suspend fun update(night: SleepNight) {
        database.update(night)
    }

    private suspend fun clear() {
        database.clear()
    }
    //   val night = database.getAllNigth()

    fun onStartTracking() {
        viewModelScope.launch {
            val newNight = SleepNight()
            insert(newNight)
            tonight.value = getTonightFromDatabase()
        }
    }

    fun onStopTracker() {
        viewModelScope.launch {
            val oldNight = tonight.value ?: return@launch
            oldNight.endTimeMilli = System.currentTimeMillis()
            update(oldNight)

            _navigateToSleepQuality.value = oldNight
        }
    }

    fun onClear() {
        viewModelScope.launch {
            clear()
            tonight.value = null
            _showSnackbarEvent.value = true
        }

    }







}

