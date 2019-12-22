package com.example.studentdatabase.studentList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentdatabase.db.Student
import com.example.studentdatabase.db.StudentDao
import kotlinx.coroutines.*

class ListStudentViewModel (val database:StudentDao):ViewModel(){
    var _studentsList = MutableLiveData<List<Student>?>()
    val studentsList:LiveData<List<Student>?>
    get() = _studentsList
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getStudents(){
        uiScope.launch {
            _studentsList.value = getAllStudents()
            Log.i("Students","Received Students")
        }
    }
    private suspend fun getAllStudents(): List<Student>? {
        return withContext(Dispatchers.IO){
            val students = database.getAllStudents()
            /*for (i in 0..(students?.size?.minus(1) ?: 0))
                Log.i("Student", students?.get(i)?.name)*/
            Log.i("Recyclerview","Return Student")
            students
        }
    }
    init {
        getStudents()
    }
}