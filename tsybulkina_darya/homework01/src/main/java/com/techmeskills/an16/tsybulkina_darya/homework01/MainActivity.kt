package com.techmeskills.an16.tsybulkina_darya.homework01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val persons:MutableList<Person>  = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { clickRegistration() }
    }

    private fun clickRegistration() {
        if (editTextAge.text.isNotEmpty() && editTextName.text.isNotEmpty() && editTextSurName.text.isNotEmpty()) {
            val surName = editTextName.text.toString()
            val name = editTextSurName.text.toString()
            val age = editTextAge.text.toString()
            val findPerson = persons.filter { Person(name, surName, age.toInt()) == it }
            if (findPerson.isNotEmpty()){
                textViewRegistration.text = resources.getString(R.string.error_registration);
            } else {
                persons.add(Person(name, surName, age.toInt()))
                textViewRegistration.text = getString(R.string.registration_message,persons.last().toString() )
            }
        } else {
            Toast.makeText(this, resources.getString(R.string.empty_field), Toast.LENGTH_SHORT).show()
        }
        editTextName.setText("")
        editTextSurName.setText("")
        editTextAge.setText("")
    }
}

data class Person(val name:String, val secondName:String, val age:Int){
    override fun toString(): String {
        return "$name $secondName ($age лет)"
    }
}