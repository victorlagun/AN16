package com.techmeskills.an16.eliseyev_aleksandr.homework02

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
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onResume() {
        super.onResume()
        saveButton.setOnClickListener {
            onClicked()
        }
    }

    private fun onClicked() {
        val textName = editName.text
        val textSecondName = editSecondName.text
        val numberAge = editTextNumberSigned.text

            if (textName.isBlank() || textSecondName.isBlank() || numberAge.isBlank()) {
                Toast.makeText(requireContext(), "All fields must be filled", Toast.LENGTH_SHORT)
                    .show()
            } else {
                requireActivity().supportFragmentManager.setFragmentResult(
                    FirstFragment.RESULT,
                    bundleOf(
                        "name" to editName.text.toString(),
                        "secondName" to editSecondName.text.toString(),
                        "age" to editTextNumberSigned.text.toString()
                    )
                )
                onBackPressed()
            }
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