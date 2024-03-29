package com.techmeskills.an16.miseyko_denis.homework02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import kotlinx.android.synthetic.main.fragment_user.*
import java.lang.Integer.parseInt

class UserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            if (name.text.toString() == "" || secondName.text.toString() == "" || age.text.toString() == "") {
                Toast.makeText(context, R.string.missingField, Toast.LENGTH_SHORT)
                    .show()
            } else {
                val user = User(
                    name = name.text.toString(),
                    secondName = secondName.text.toString(),
                    age = parseInt(age.text.toString())
                )

                if (ListFragment.data.contains(user)) {
                    Toast.makeText(context, R.string.exist, Toast.LENGTH_SHORT).show()
                } else {
                    onClicked()
                }
            }
        }
    }

    private fun onClicked() {
        setFragmentResult(
            ListFragment.RESULT,
            bundleOf(
                KEY_NAME to name.text.toString(),
                KEY_SECONDNAME to secondName.text.toString(),
                KEY_AGE to parseInt(age.text.toString())
                )
            )
        onBackPressed()
    }

    private fun onBackPressed() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, ListFragment.newInstance())
            .commit()
    }


    companion object {

        const val KEY_NAME = "name"
        const val KEY_SECONDNAME = "secondName"
        const val KEY_AGE = "age"
        @JvmStatic
        fun newInstance() = UserFragment()
    }

}
