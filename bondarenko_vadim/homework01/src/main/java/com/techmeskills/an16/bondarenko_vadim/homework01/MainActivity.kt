package com.techmeskills.an16.bondarenko_vadim.homework01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var users: MutableList<User> = mutableListOf()
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val name = Name.text.toString()
            val secondName = SecondName.text.toString() // проверить
            val age: Int = Age.text.toString().toIntOrNull() ?: 0
            if (checkName(name) && checSecondName(secondName) && checAge(age)) {
                val person = User(name, secondName, age)
                if (users.contains(person)) {
                    Toast.makeText(this, "Такой элемент уже есть", Toast.LENGTH_SHORT).show()
                } else {
                    users.add(person)
                }
            }
            if (users.isEmpty()) {
                Toast.makeText(this, "Пусто", Toast.LENGTH_SHORT).show()
            } else {
                textView.text = users.last().toString()
            }
        }
    }

    fun checkName(name: String): Boolean {
        if (name == "") {
            Toast.makeText(this, "Name Null", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }

    /// убрать одну fun
    fun checSecondName(secondName: String): Boolean {
        if (secondName == "") {
            Toast.makeText(this, "Second Name Null", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }

    fun checAge(age: Int): Boolean {
        if (age == 0) {
            Toast.makeText(this, "Age Null", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }
}