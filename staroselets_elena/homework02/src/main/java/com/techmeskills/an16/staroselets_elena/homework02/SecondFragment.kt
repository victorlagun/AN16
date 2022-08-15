package com.techmeskills.an16.staroselets_elena.homework02


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onResume() {
        super.onResume()
        saveButton.setOnClickListener { onClicked() }

    }

    private fun onClicked() {
        if(editPersonName.text.toString() == ""){
            Toast.makeText(activity, "Заполните поле Name", Toast.LENGTH_SHORT).show()
            return
        }

        if(editPersonSecondName.text.toString() == ""){
            Toast.makeText(activity, "Заполните поле Фамилия", Toast.LENGTH_SHORT).show()
            return
        }

        if(editAge.text.toString() == "" || Integer.parseInt(editAge.text.toString()) == 0){
            Toast.makeText(activity, "Заполните поле возраст", Toast.LENGTH_SHORT).show()
            return
        }
        var usr = User()
        usr.name = editPersonName.text.toString()
        usr.secondname = editPersonSecondName.text.toString()
        usr.age = Integer.parseInt(editAge.text.toString())
        //******************************************************

        setFragmentResult(
            FirstFragment.RESULT,
            bundleOf("user" to usr)
        )
        onBackPressed()
    }

    private fun onBackPressed() {
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.remove(this)
        ft.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}