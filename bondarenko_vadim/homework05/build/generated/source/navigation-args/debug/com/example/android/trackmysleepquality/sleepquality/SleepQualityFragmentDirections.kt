package com.example.android.trackmysleepquality.sleepquality

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.techmeskills.an16.bondarenko_vadim.homework04.R

public class SleepQualityFragmentDirections private constructor() {
  public companion object {
    public fun actionSleepQualityFragmentToSleepTrackerFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_sleepQualityFragment_to_sleepTrackerFragment)
  }
}
