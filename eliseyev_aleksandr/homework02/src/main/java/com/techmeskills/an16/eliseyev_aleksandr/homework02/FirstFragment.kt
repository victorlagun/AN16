package com.techmeskills.an16.eliseyev_aleksandr.homework02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.techmeskills.an16.eliseyev_aleksandr.homework02.adapter.UsersAdapter
import com.techmeskills.an16.eliseyev_aleksandr.homework02.model.Users
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*

class FirstFragment : Fragment() {
    private val users: MutableList<Users> = mutableListOf()


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
            viewLifecycleOwner) { _, bundle ->
                users.add(
                    Users(
                        bundle.getString("name")!!,
                        bundle.getString("secondName")!!,
                        bundle.getString("age")!!
                    )
                )
                updateListOfUsers()
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
        updateListOfUsers()
    }

    private fun updateListOfUsers() {
        if (users.size == 0) {
            empty_list.visibility = View.VISIBLE
            list.visibility = View.GONE

        } else {
            empty_list.visibility = View.GONE
            list.visibility = View.VISIBLE
            list.layoutManager = LinearLayoutManager(activity)
            list.adapter = UsersAdapter(users)
        }
    }

    companion object {
        const val RESULT = "result"

        @JvmStatic
        fun newInstance() = FirstFragment()

    }
}