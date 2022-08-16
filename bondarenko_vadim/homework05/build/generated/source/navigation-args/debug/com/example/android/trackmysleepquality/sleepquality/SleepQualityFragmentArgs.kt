package com.example.android.trackmysleepquality.sleepquality

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Long
import kotlin.jvm.JvmStatic

public data class SleepQualityFragmentArgs(
  public val sleepNightKey: Long
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putLong("sleepNightKey", this.sleepNightKey)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("sleepNightKey", this.sleepNightKey)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): SleepQualityFragmentArgs {
      bundle.setClassLoader(SleepQualityFragmentArgs::class.java.classLoader)
      val __sleepNightKey : Long
      if (bundle.containsKey("sleepNightKey")) {
        __sleepNightKey = bundle.getLong("sleepNightKey")
      } else {
        throw IllegalArgumentException("Required argument \"sleepNightKey\" is missing and does not have an android:defaultValue")
      }
      return SleepQualityFragmentArgs(__sleepNightKey)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): SleepQualityFragmentArgs {
      val __sleepNightKey : Long?
      if (savedStateHandle.contains("sleepNightKey")) {
        __sleepNightKey = savedStateHandle["sleepNightKey"]
        if (__sleepNightKey == null) {
          throw IllegalArgumentException("Argument \"sleepNightKey\" of type long does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"sleepNightKey\" is missing and does not have an android:defaultValue")
      }
      return SleepQualityFragmentArgs(__sleepNightKey)
    }
  }
}
