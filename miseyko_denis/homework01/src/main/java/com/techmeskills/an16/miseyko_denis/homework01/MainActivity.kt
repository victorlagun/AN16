package com.techmeskills.an16.miseyko_denis.homework01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.techmeskills.an16.miseyko_denis.homework01.R.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, Fragment())
                .commit()
        }
    }
}
