package com.example.eliseyev_aleksandr_homework03.ui.game

import androidx.fragment.app.viewModels


class GameFragment {
    private fun updateNextWordOnScreen() {
        binding.textViewUnscrambledWord.text = viewModel.currentScrambledWord
    }
}