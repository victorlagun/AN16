package com.techmeskills.an16.lazovskiy_anton.homework01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener{ textView.text = "User created!"
            action { Toast.makeText(this, "Test!", Toast.LENGTH_SHORT).show() }}
    }

    private fun action(function: () -> Unit) {
    }

    data class User(
        val name: String,
        val secondName: String,
        val age: Int
    )
}