package com.techmeskills.an16.staroselets_elena.homework02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*


class FirstFragment : Fragment() {
    // храним спиок пользователей в фрагмента
    var userList:MutableList<User>  = mutableListOf()
    var myListAdapter:MyListAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //создаем переменную адаптера
/*
        var usr = User()
        usr.name = "aa"
        usr.secondname = "bb"
        usr.age = 32
        userList.add(usr)
        */
        myListAdapter =  MyListAdapter(view.context, userList)

        userListView.adapter = myListAdapter
    }


    override fun onResume() {
        super.onResume()
        floatingActionButton.setOnClickListener { onClicked() }

        setFragmentResultListener(RESULT) { _, bundle ->

            if (bundle.containsKey("user")) {
                var usr = bundle.getParcelable<User>("user")

                if (usr != null) {
                    val listIterator = userList.listIterator()
                    var userExist = false;
                    while (listIterator.hasNext()) {
                        val cu = listIterator.next()
                        if (cu.equals(usr)) {
                            userExist = true;
                            break;
                        }
                    }

                    if (userExist) {
                        Toast.makeText(
                            activity,
                            "Данный пользователь уже добавлен",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        userList.add(usr)

                        myListAdapter?.notifyDataSetChanged()
                    }
                    isEmptyList()
                }

            }
        }
    }

    private fun isEmptyList(){
        if(userList.size==0){
            textEmptyList.visibility=VISIBLE
            userListView.visibility= GONE
        }
        else{
            textEmptyList.visibility= GONE
            userListView.visibility= VISIBLE
        }
    }

    private fun onClicked() {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container, SecondFragment.newInstance())
        fragmentTransaction.commit()
    }

    companion object {
        const val RESULT = "result"

        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}