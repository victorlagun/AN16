package com.techmeskills.an16.tsybulkina_darya.homework02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onResume() {
        super.onResume()
        button.setOnClickListener { onClicked() }
    }

    private fun onClicked() {
        if (checkValue()) {
            requireActivity().supportFragmentManager.setFragmentResult(
                FirstFragment.RESULT,
                bundleOf(
                    "name" to editTextName.text.toString(),
                    "surname" to editTextSurName.text.toString(),
                    "age" to editTextAge.text.toString()
                )
            )
            onBackPressed()
        }
    }

    private fun checkValue(): Boolean {
        if (editTextName.length() == 0) {
            outputError("имени")
            false
        }
        if (editTextSurName.length() == 0) {
            outputError("фамилии")
            false
        }
        if (editTextAge.length() == 0) {
            outputError("возраста")
            false
        }
        return true
    }

    private fun outputError(massage: String) {
        Toast.makeText(
            requireContext(),
            "Поле $massage должно быть заполнено",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun onBackPressed() {
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.remove(this)
        ft.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SecondFragment()
    }
}