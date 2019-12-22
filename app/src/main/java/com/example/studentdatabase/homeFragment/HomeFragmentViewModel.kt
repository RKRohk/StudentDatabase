package com.example.studentdatabase.homeFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentdatabase.db.Student
import com.example.studentdatabase.db.StudentDao
import kotlinx.coroutines.*

class HomeFragmentViewModel() : ViewModel(){
    private var _navigate = MutableLiveData<Boolean?>()

    val navigate:LiveData<Boolean?>
        get() = _navigate

    fun onAddStudentButtonPressed(){
        _navigate.value = true
    }
    fun doneNavigation(){
        _navigate.value = false
    }
    init {
        _navigate.value = null

    }
}