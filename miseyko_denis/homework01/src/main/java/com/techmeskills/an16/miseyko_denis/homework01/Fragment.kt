package com.techmeskills.an16.miseyko_denis.homework01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment.*
import java.lang.Integer.parseInt

class Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            if (name.text.toString() == "" || secondName.text.toString() == "" || age.text.toString() == "") {
                Toast.makeText(context, R.string.missingField, Toast.LENGTH_SHORT).show()
            } else {
                val user = User(
                    name = name.text.toString(),
                    secondName = secondName.text.toString(),
                    age = parseInt(age.text.toString())
                )

                if (users.contains(user)) {
                    list.text = getString(R.string.exist)
                } else {
                    users.add(user)
                    list.text = "$user " + getString(R.string.added)
                }

                name.text.clear()
                secondName.text.clear()
                age.text.clear()
            }
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        list.text = savedInstanceState?.getString(LIST_KEY)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LIST_KEY, list.text.toString())
    }

    companion object {
        val users = listOf<User>().toMutableList()
        const val LIST_KEY = "list"
    }

}
