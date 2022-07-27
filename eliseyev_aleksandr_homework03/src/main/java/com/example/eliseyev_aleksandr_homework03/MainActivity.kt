package com.example.eliseyev_aleksandr_homework03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.unscramble.R

/**
 * Creates an Activity that hosts the Game fragment in the app
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}