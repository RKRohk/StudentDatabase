package com.example.studentdatabase.studentList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentdatabase.db.StudentDao
import java.lang.IllegalArgumentException

class ListStudentViewModelFactory (val database:StudentDao):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListStudentViewModel::class.java))
            return ListStudentViewModel(database) as T
        throw IllegalArgumentException("What the hell")
    }
}