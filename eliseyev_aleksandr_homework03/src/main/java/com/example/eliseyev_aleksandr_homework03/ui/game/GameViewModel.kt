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

    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord



    private var _count = 0

    val count: Int
        get() = _count

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
    }

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordsList.add(currentWord)
        }
    }

    fun nextWord(): Boolean {
        return if (currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

}
