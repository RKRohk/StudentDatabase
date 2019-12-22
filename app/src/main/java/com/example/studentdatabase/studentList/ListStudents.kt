package com.example.studentdatabase.studentList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.studentdatabase.R
import com.example.studentdatabase.databinding.FragmentListStudentsBinding
import com.example.studentdatabase.db.Student
import com.example.studentdatabase.db.StudentDatabase
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 */
class ListStudents : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this
        val application = requireNotNull(this.activity).application
        val database = StudentDatabase.getInstance(application).studentDao
        val viewModelFactory = ListStudentViewModelFactory(database)
        val viewModel:ListStudentViewModel = ViewModelProvider(this,viewModelFactory).get()
        val adapter = ListStudentAdapter()
        val binding:FragmentListStudentsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_list_students,container,false)
        viewModel.studentsList.observe(this, Observer {
            it?.let {
                Log.i("Student","Students no more null")
                Log.i("Student","${viewModel.studentsList.value?.get(0)?.name}")
                val list:MutableList<Student> = (viewModel.studentsList.value as MutableList<Student>)
                for (i in 0 until list.size.minus(1)){
                    Log.i("Student","${list[i].name}" )
                }
                adapter.submitList(list)
                binding.executePendingBindings()
            }
        })
        binding.recyclerview.adapter = adapter
        binding.lifecycleOwner = this
        Log.i("Recyclerview","Recyclerview Properties Set")
        return binding.root
    }

}
