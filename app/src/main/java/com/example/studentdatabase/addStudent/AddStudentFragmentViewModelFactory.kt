package com.example.studentdatabase.addStudent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentdatabase.db.StudentDao
import java.lang.IllegalArgumentException

class AddStudentFragmentViewModelFactory(private val dataSource:StudentDao) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddStudentFragmentViewModel::class.java))
            return AddStudentFragmentViewModel(dataSource) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}