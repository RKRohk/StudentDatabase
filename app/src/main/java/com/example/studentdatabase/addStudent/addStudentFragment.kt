package com.example.studentdatabase.addStudent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

import com.example.studentdatabase.R
import com.example.studentdatabase.databinding.FragmentAddStudentBinding
import com.example.studentdatabase.db.StudentDatabase

/**
 * A simple [Fragment] subclass.
 */
class addStudentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentAddStudentBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_student,container,false)
        val application = requireNotNull(this.activity).application
        val dataSource = StudentDatabase.getInstance(application).studentDao
        val viewModelFactory = AddStudentFragmentViewModelFactory(dataSource)
        val viewModel:AddStudentFragmentViewModel = ViewModelProvider(this,viewModelFactory).get()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.buttonPress.observe(this, Observer {
            if (it == true) {
                Log.i("ButtonPress", "Button Press Detected")
                viewModel.name = binding.nameView.text.toString()
                viewModel.rollNo = binding.rollNoEditText.text.toString().toInt()
                viewModel.cgpa = binding.cgpaEditText.text.toString().toDouble()
                viewModel.insertNewStudent()
            }
        })

        return binding.root
    }

}
