package com.techmeskills.an16.homework04.sleeptracker

import com.techmeskills.an16.homework04.database.SleepNight

class SleepNightListener(val clickListener: (sleepId: Long) -> Unit) {
    fun onClick(night: SleepNight) = clickListener(night.nightId)
}