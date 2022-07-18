package com.techmeskills.an16.miseyko_denis.homework02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val list = view.findViewById<RecyclerView>(R.id.list)
        val adapter = ListAdapter(data)
        list.adapter = adapter
        return view
    }


    override fun onResume() {
        super.onResume()

        floatingActionButton.setOnClickListener { onClicked() }
        setFragmentResultListener(RESULT) { _, bundle ->
            val user = User(
                bundle.getString("name").toString(),
                bundle.getString("secondName").toString(),
                bundle.getInt("age")
            )
            data.add(user)
        }

        if (data.isEmpty()) {
            text.visibility = View.VISIBLE
        } else {
            text.visibility = View.GONE
        }
    }

    private fun onClicked() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, UserFragment.newInstance())
            .commit()
    }

    companion object {
        val data = mutableListOf<User>()
        const val RESULT = "result"

        fun newInstance() = ListFragment()
    }


}