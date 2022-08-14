package com.techmeskills.an16.homework04.sleeptracker

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.techmeskills.an16.homework04.convertDurationToFormatted
import com.techmeskills.an16.homework04.convertNumericQualityToString
import com.techmeskills.an16.homework04.database.SleepNight
import com.techmeskills.an16.lagun_victor.homework04.R

@BindingAdapter("sleepDurationFormatted")
fun TextView.setSleepDurationFormatted(item: SleepNight?) {
    item?.let {
        text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, context.resources)
    }
}


@BindingAdapter("sleepQualityString")
fun TextView.setSleepQualityString(item: SleepNight?) {
    item?.let {
        text = convertNumericQualityToString(item.sleepQuality, context.resources)
    }
}


@BindingAdapter("sleepImage")
fun ImageView.setSleepImage(item: SleepNight?) {
    setImageResource(
        when (item?.sleepQuality) {
            0 -> R.drawable.ic_sleep_0
            1 -> R.drawable.ic_sleep_1
            2 -> R.drawable.ic_sleep_2

            3 -> R.drawable.ic_sleep_3

            4 -> R.drawable.ic_sleep_4
            5 -> R.drawable.ic_sleep_5
            else -> R.drawable.ic_launcher_sleep_tracker_foreground
        }
    )
}