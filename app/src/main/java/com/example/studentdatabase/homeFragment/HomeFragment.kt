package com.example.studentdatabase.homeFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.studentdatabase.R
import com.example.studentdatabase.databinding.HomeLayoutBinding
import com.example.studentdatabase.db.Student
import com.example.studentdatabase.db.StudentDatabase

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val viewModelFactory = HomeFragmentViewModelFactory()
        val viewModel = ViewModelProvider(this,viewModelFactory).get(HomeFragmentViewModel::class.java)
        val binding:HomeLayoutBinding = DataBindingUtil.inflate(inflater,R.layout.home_layout,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.navigate.observe(this, Observer {
            if (viewModel.navigate.value == true){
                Log.i("ButtonPressed","Button Press detected")
                this.findNavController().navigate(HomeFragmentDirections.actionHomeFragment2ToAddStudentFragment())
                viewModel.doneNavigation()
            }
        })
        binding.listButton.setOnClickListener {
            Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragment2ToListStudents())
        }
        return binding.root
    }

}
