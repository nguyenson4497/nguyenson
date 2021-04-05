package com.example.taskjavacore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    var listData: MutableList<Student> = mutableListOf()

    fun setData(listData: MutableList<Student>) {
        this.listData = listData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_customview, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listData.size;
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        var student: Student = listData[position]
        holder.nameStudent.text = student.name
        holder.phoneStudent.text = student.phoneNumber
        holder.levelStudent.text = student.level
    }

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nameStudent: TextView = itemView.findViewById(R.id.tv_show_name)
        var phoneStudent: TextView = itemView.findViewById(R.id.tv_show_phone_number)
        var levelStudent: TextView = itemView.findViewById(R.id.tv_show_level)

    }
}