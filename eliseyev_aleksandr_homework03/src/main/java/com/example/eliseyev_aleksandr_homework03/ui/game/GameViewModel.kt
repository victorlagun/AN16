package com.example.eliseyev_aleksandr_homework03.ui.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.eliseyev_aleksandr_homework03.databinding.GameFragmentBinding

class GameViewModel : ViewModel() {
    init {
        Log.d("GameFragment", "GameViewModel created!")
    }

    private var score = 0
    private var currentWordCount = 0

    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private var _count = 0

    val count: Int
        get() = _count

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

}
