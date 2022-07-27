package com.example.eliseyev_aleksandr_homework03.ui.game

import androidx.lifecycle.ViewModel

/**
 * ViewModel containing the app data and methods to process the data
 */
class GameViewModel : ViewModel() {
    private var score = 0
    private var currentWordCount = 0

    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private var _count = 0

    val count: Int
        get() = _count

}
