package com.techmeskills.an16.staroselets_elena.homework03.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    private var _score = 0
    val score: Int
        get() = _score

    private var __currentWordCount = 0
    val currentWordCount: Int
        get() = __currentWordCount



    private lateinit var _currentScrambledWord : String
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private var _count = 0
    val count: Int
    get() = _count

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String


    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
    }

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (String(tempWord).equals(currentWord, false)){
            tempWord.shuffle()
        }

        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++__currentWordCount
            wordsList.add(currentWord)
        }
    }
    private fun increaseScore(){
        _score+= SCORE_INCREASE
    }

    fun isUserWordCorrect(playerWord: String):Boolean{
        if(playerWord.equals(currentWord,true)) {
            increaseScore()
            return true
        }
        return false
    }



    /*
    * Returns true if the current word count is less than MAX_NO_OF_WORDS.
    * Updates the next word.
    */
    fun nextWord(): Boolean {
        return if (currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }
}
