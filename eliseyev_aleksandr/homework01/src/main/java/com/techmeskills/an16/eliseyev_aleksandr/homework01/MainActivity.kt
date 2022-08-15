package com.techmeskills.an16.eliseyev_aleksandr.homework01


import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showButton = findViewById<Button>(R.id.getButton)
        val editText = findViewById<EditText>(R.id.editName)
        val editTextSecondName = findViewById<EditText>(R.id.editSecondName)
        val editAge = findViewById<EditText>(R.id.editTextNumberSigned)
        val textView = findViewById<TextView>(R.id.textView)

        val user = object {
            val name = editText.text
            val secondName = editTextSecondName.text
            val age = editAge.text

            override fun toString() = "$name $secondName $age"
        }

        val users: MutableList<String> = mutableListOf()

        showButton.setOnClickListener{
            val textName = editText.text
            val textSecondName = editTextSecondName.text
            val numberAge = editAge.text
            val info = user.toString()
            checkEmptyText()
            if (users.contains(info)){
                textView.setText("This user is already exist")
            } else {
                users.add(info)
                if (textName.isBlank() || textSecondName.isBlank() || numberAge.isBlank()) {
                    Toast.makeText(this, "All fields must be filled in", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    textView.setText("User: $info")
                    editText.getText().clear();
                    editSecondName.getText().clear();
                    editAge.getText().clear();
                }
            }

        }

    }


    private fun checkEmptyText() {
        val strName = editName.text.toString()
        val strSecondName = editSecondName.text.toString()
        val strAge = editTextNumberSigned.text.toString()

        if (TextUtils.isEmpty(strName)) {
            editName.error = "Field NAME must be filled in"
            return
        }

        if (TextUtils.isEmpty(strSecondName)) {
            editSecondName.error = "Field SECOND NAME must be filled in"
            return
        }

        if (TextUtils.isEmpty(strAge)) {
            editTextNumberSigned.error = "Field AGE must be filled in"
            return
        }
    }
}
