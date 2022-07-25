package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.combine
import java.lang.Error
import java.util.*

class GameViewModel : ViewModel() {


    private var _score = 0
    val score: Int
        get() = _score

    private var _currentWordCount = 0
    val currentWordCount: Int
        get() = _currentWordCount


    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord


    private var _count = 0
    val count: Int
        get() = _count // для того чтобы закрыть переменные, извне доступны только для чтения

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String  //lateinit для того чтобы инициализировать потом


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

    init {

        Log.d("Game Fragment", "GameViewModel created!")
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    fun nextWord(): Boolean{
        return if (currentWordCount < MAX_NO_OF_WORDS){
            getNextWord()
            true
        } else false
    }

    private fun increaseScore(){
        _score += SCORE_INCREASE
    }

    fun isUserWordCorrect(playerWord: String): Boolean{
        if (playerWord.equals(currentWord, true)){
            increaseScore()
            return true
        }
        return false
    }

fun reinitializeData(){
    _count = 0
    _currentWordCount = 0
    wordsList.clear()
    getNextWord()
}


}