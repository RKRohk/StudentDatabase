package com.example.studentdatabase.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Insert
    fun insertStudent(student:Student)

    @Query("SELECT * from student ORDER BY id DESC")
    fun getAllStudents():List<Student>?

}
