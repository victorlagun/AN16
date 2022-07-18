package com.techmeskills.an16.tsybulkina_darya.homework02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.techmeskills.an16.tsybulkina_darya.homework02.adapter.UserAdapter
import com.techmeskills.an16.tsybulkina_darya.homework02.model.Person
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {
    val persons: MutableList<Person> = mutableListOf()

    val data = listOf<Person>(Person("sd", "wed", 12))
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onResume() {
        super.onResume()
        floatingActionButton.setOnClickListener { onClicked() }
        requireActivity().supportFragmentManager.setFragmentResultListener(
            RESULT,
            viewLifecycleOwner
        ) { _, bundle ->
            val findPerson = persons.filter {
                Person(
                    bundle.getString("name")!!,
                    bundle.getString("surname")!!,
                    bundle.getString("age")!!.toInt()
                ) == it
            }
            if (findPerson.isNotEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Пользователь не добавлен. Данный пользователь уже существует",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                persons.add(
                    Person(
                        bundle.getString("name")!!,
                        bundle.getString("surname")!!,
                        bundle.getString("age")!!.toInt()
                    )
                )
                Toast.makeText(
                    requireContext(),
                    "Пользователь ${persons.last().toString()} зарегистрирован",
                    Toast.LENGTH_SHORT
                ).show()
            }
            updateList()
        }

    }

    private fun onClicked() {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container, SecondFragment.newInstance())
        fragmentTransaction.commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateList()
    }

    private fun updateList() {
        if (persons.size == 0) {
            empty_view.visibility = View.VISIBLE
            list.visibility = View.GONE

        } else {
            empty_view.visibility = View.GONE
            list.visibility = View.VISIBLE
            list.layoutManager = LinearLayoutManager(activity)
            list.adapter = UserAdapter(persons)
        }
    }

    companion object {
        const val RESULT = "result"

        @JvmStatic
        fun newInstance() = FirstFragment()

    }
}