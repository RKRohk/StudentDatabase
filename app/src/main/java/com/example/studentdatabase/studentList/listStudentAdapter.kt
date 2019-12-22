package com.example.studentdatabase.studentList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.studentdatabase.R
import com.example.studentdatabase.db.Student

class ListStudentAdapter():ListAdapter<Student,ViewHolder>(StudentDiffCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_students,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.name?.text = item.name
        holder.cgpa?.text = item.cgpa.toString()
        holder.rollNo?.text = item.rollNo.toString()
    }

}
class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    val name:TextView? = itemView.findViewById(R.id.name_view)
    val cgpa:TextView? = itemView.findViewById(R.id.cgpaView)
    val rollNo:TextView? = itemView.findViewById(R.id.rollNoText)
}

class StudentDiffCallback:DiffUtil.ItemCallback<Student>(){
    override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
        return oldItem == newItem
    }

}