package com.example.studentdatabase.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    var name:String?,
    var rollNo:Int?,
    var cgpa:Double?
)
