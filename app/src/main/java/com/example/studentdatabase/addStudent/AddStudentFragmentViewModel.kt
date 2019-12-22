package com.example.studentdatabase.addStudent

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentdatabase.db.Student
import com.example.studentdatabase.db.StudentDao
import kotlinx.coroutines.*

class AddStudentFragmentViewModel(private val dataSource: StudentDao) : ViewModel() {

    var name:String? = null
    var rollNo:Int? = null
    var cgpa:Double? = null
    private var _buttonPress = MutableLiveData<Boolean?>()
    val buttonPress:LiveData<Boolean?>
        get() = _buttonPress

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    fun buttonPressed(){
        _buttonPress.value = true
    }
    fun onInsert(){
        _buttonPress.value = false
    }
    init {
        _buttonPress.value = null
    }
    fun insertNewStudent(){
        uiScope.launch { insertStudent() }
        onInsert()
        Log.i("insertNewStudent","Couroutine called")
    }
    private suspend fun insertStudent(){
        withContext(Dispatchers.IO){
            dataSource.insertStudent(Student(0,name,rollNo, cgpa))
            Log.i("insertStudent","Student inserted into database")
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}