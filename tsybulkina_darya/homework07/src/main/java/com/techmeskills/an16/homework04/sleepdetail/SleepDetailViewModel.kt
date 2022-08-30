package com.techmeskills.an16.homework04.sleepdetail

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techmeskills.an16.homework04.database.SleepDatabaseDao
import com.techmeskills.an16.homework04.database.SleepNight
import com.techmeskills.an16.homework04.getAppComponent
import com.techmeskills.an16.homework04.network.Item
import com.techmeskills.an16.homework04.network.RealEstateService
import kotlinx.coroutines.launch
import javax.inject.Inject

class SleepDetailViewModel (
    private val context: Context,
    private val sleepNightKey: Long = 0L,
) : ViewModel() {

    init {
        context.getAppComponent().inject(this)
    }
    /**
     * Hold a reference to SleepDatabase via its SleepDatabaseDao.
     */
    @Inject
    lateinit var database :SleepDatabaseDao
    @Inject
    lateinit var networkService: RealEstateService

    private val night: LiveData<SleepNight>

    val list: MutableLiveData<String> = MutableLiveData()



    fun getNight() = night


    init {
        night = database.getNightWithId(sleepNightKey)
        list.postValue("lskjdfsldjklsfkj")

        viewModelScope.launch {
            list.postValue("ldkgjfldfjgdlkfg")

            try {
                list.postValue(networkService.getData())
                Log.e("ERROR", networkService.getData())
            } catch (e: Exception) {
                list.postValue(e.message)
            }
        }
    }

    /**
     * Variable that tells the fragment whether it should navigate to [SleepTrackerFragment].
     *
     * This is `private` because we don't want to expose the ability to set [MutableLiveData] to
     * the [Fragment]
     */
    private val _navigateToSleepTracker = MutableLiveData<Boolean?>()

    /**
     * When true immediately navigate back to the [SleepTrackerFragment]
     */
    val navigateToSleepTracker: LiveData<Boolean?>
        get() = _navigateToSleepTracker


    /**
     * Call this immediately after navigating to [SleepTrackerFragment]
     */
    fun doneNavigating() {
        _navigateToSleepTracker.value = null
    }

    fun onClose() {
        _navigateToSleepTracker.value = true
    }
}