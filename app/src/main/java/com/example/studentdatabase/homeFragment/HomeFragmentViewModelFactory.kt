package com.example.studentdatabase.homeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentdatabase.db.StudentDao
import java.lang.IllegalArgumentException

public class HomeFragmentViewModelFactory():ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)) {
            return HomeFragmentViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}