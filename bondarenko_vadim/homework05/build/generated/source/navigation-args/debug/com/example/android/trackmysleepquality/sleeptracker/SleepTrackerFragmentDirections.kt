package com.example.android.trackmysleepquality.sleeptracker

import android.os.Bundle
import androidx.navigation.NavDirections
import com.techmeskills.an16.bondarenko_vadim.homework04.R
import kotlin.Int
import kotlin.Long

public class SleepTrackerFragmentDirections private constructor() {
  private data class ActionSleepTrackerFragmentToSleepQualityFragment(
    public val sleepNightKey: Long
  ) : NavDirections {
    public override val actionId: Int = R.id.action_sleepTrackerFragment_to_sleepQualityFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putLong("sleepNightKey", this.sleepNightKey)
        return result
      }
  }

  public companion object {
    public fun actionSleepTrackerFragmentToSleepQualityFragment(sleepNightKey: Long): NavDirections
        = ActionSleepTrackerFragmentToSleepQualityFragment(sleepNightKey)
  }
}
