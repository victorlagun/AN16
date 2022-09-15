package com.techmeskills.an16.homework04.sleepdetail

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.techmeskills.an16.homework04.getAppComponent
import com.techmeskills.an16.lagun_victor.homework04.R
import com.techmeskills.an16.lagun_victor.homework04.databinding.FragmentSleepDetailBinding
import kotlinx.android.synthetic.main.fragment_sleep_detail.*
import javax.inject.Inject

class SleepDetailFragment : Fragment() {

    lateinit var sleepDetailViewModel: SleepDetailViewModel

    @Inject
    lateinit var factory: SleepDetailViewModelFactory.Factory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentSleepDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sleep_detail, container, false
        )

        val arguments = SleepDetailFragmentArgs.fromBundle(requireArguments())


        // Get a reference to the ViewModel associated with this fragment.
         sleepDetailViewModel =
            ViewModelProvider(
                this, factory.create(arguments.sleepNightKey)
            ).get(SleepDetailViewModel::class.java)

//         To use the View Model with data binding, you have to explicitly
//         give the binding object a reference to it.
        binding.sleepDetailViewModel = sleepDetailViewModel

        binding.setLifecycleOwner(this)

        // Add an Observer to the state variable for Navigating when a Quality icon is tapped.
        sleepDetailViewModel.navigateToSleepTracker.observe(viewLifecycleOwner, Observer {
            if (it == true) { // Observed state is true.
                this.findNavController().navigate(
                    SleepDetailFragmentDirections.actionSleepDetailFragmentToSleepTrackerFragment()
                )
                // Reset state to make sure we only navigate once, even if the device
                // has a configuration change.
                sleepDetailViewModel.doneNavigating()
            }
        })

        sleepDetailViewModel.list.observe(viewLifecycleOwner) {
            binding.textView.text = it.toString()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sleepDetailViewModel.list.observe(viewLifecycleOwner){
            Log.e("ERROR", it.toString())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireContext().getAppComponent().inject(this)
    }
}