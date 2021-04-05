package com.example.taskjavacore

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val listStudent: MutableList<Student> = mutableListOf()
    var studentAdapter: StudentAdapter = StudentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // List data already
        var student1: Student = Student(
            "Son", "1997",
            "0984988089", "CNTT", "Dai Hoc"
        )
        var student2: Student = Student(
            "Linh", "1996",
            "0123456789", "MARKETING", "Cao Dang"
        )
        var student3: Student = Student(
            "tung", "2000",
            "0987654321", "QTKD", "Cao Dang"
        )
        var student4: Student = Student(
            "huong", "1997",
            "0162601296", "KT", "Dai Hoc"
        )
        listStudent.add(student1)
        listStudent.add(student2)
        listStudent.add(student3)
        listStudent.add(student4)

        //Recycle View Student
        //Layout Manager
        var linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        rv_student.layoutManager = linearLayoutManager
        //Adapter
        rv_student.adapter = studentAdapter
        studentAdapter.setData(listStudent)

        //Button (Manage)
        btn_add.setOnClickListener(View.OnClickListener {
            addStudent()
        })
        btn_edit.setOnClickListener(View.OnClickListener {
            editStudent()
        })
        btn_save.setOnClickListener(View.OnClickListener {
            saveStudent()
        })
        btn_remove.setOnClickListener(View.OnClickListener {
            removeStudent()
        })
        btn_find.setOnClickListener(View.OnClickListener {
            findStudent()
        })

        //Button (Sort)
        btn_sort_name.setOnClickListener(View.OnClickListener {
            sortName()
        })
        btn_sort_phone_number.setOnClickListener(View.OnClickListener {
            sortPhoneNumber()
        })
        btn_sort_year.setOnClickListener(View.OnClickListener {
            sortYear()
        })

        //Button (Filter)
        btn_filter_col.setOnClickListener {
            View.OnClickListener {
                filterByCollege()
            }
        }
        btn_filter_uni.setOnClickListener {
            View.OnClickListener {
                filterByUniversity()
            }
        }

    }

    //Filter Student
    fun filterByUniversity() {

    }

    fun filterByCollege() {

    }

    //Add Student
    fun addStudent() {
        var name: String = edt_name.text.toString().trim()
        var yearOfBirth: String = edt_year_of_birth.text.toString().trim()
        var phoneNumber: String = edt_phone_number.text.toString().trim()
        var field: String = edt_field.text.toString().trim()
        var level: String = edt_level.text.toString().trim()

        if (name.length == 0 || yearOfBirth.length == 0 || phoneNumber.length == 0 ||
            field.length == 0 || level.length == 0
        ) {
            Toast.makeText(this, "Vui long dien day du thong tin", Toast.LENGTH_SHORT).show()
        } else {
            var student: Student = Student(name, yearOfBirth, phoneNumber, field, level)
            listStudent.add(student)
            edt_name.text.clear()
            edt_year_of_birth.text.clear()
            edt_phone_number.text.clear()
            edt_field.text.clear()
            edt_level.text.clear()
            studentAdapter.setData(listStudent)
        }
    }

    //Edit Student
    fun editStudent() {
        var phoneNumber: String = edt_phone_number.text.toString().trim()
        for (i in listStudent) {
            if (i.phoneNumber.equals(phoneNumber)) {
                edt_name.setText(i.name)
                edt_year_of_birth.setText(i.yearOfBirth)
                edt_field.setText(i.field)
                edt_level.setText(i.level)
            }
        }
    }

    //Save Student
    fun saveStudent() {
        var name: String = edt_name.text.toString().trim()
        var yearOfBirth: String = edt_year_of_birth.text.toString().trim()
        var phoneNumber: String = edt_phone_number.text.toString().trim()
        var field: String = edt_field.text.toString().trim()
        var level: String = edt_level.text.toString().trim()

        if (name.length == 0 || yearOfBirth.length == 0 || phoneNumber.length == 0 ||
            field.length == 0 || level.length == 0
        ) {
            Toast.makeText(this, "Vui long dien day du thong tin", Toast.LENGTH_SHORT).show()
        } else {
            for (i in listStudent) {
                if (i.phoneNumber.equals(phoneNumber)) {
                    i.name = name
                    i.yearOfBirth = yearOfBirth
                    i.field = field
                    i.level = level
                    edt_name.text.clear()
                    edt_year_of_birth.text.clear()
                    edt_phone_number.text.clear()
                    edt_field.text.clear()
                    edt_level.text.clear()
                    studentAdapter.setData(listStudent)
                }
            }

        }
    }

    //Remove Student
    fun removeStudent() {

    }

    //Sort Student
    fun sortName() {
        listStudent.sortBy {
            it.name.toLowerCase()
        }
        studentAdapter.setData(listStudent)
    }

    fun sortYear() {
        listStudent.sortedByDescending {
            it.yearOfBirth
        }
        studentAdapter.setData(listStudent)
    }

    fun sortPhoneNumber() {
        listStudent.sortBy {
            it.phoneNumber
        }
        studentAdapter.setData(listStudent)
    }

    //Find Student
    fun findStudent() {
        var findStudent: String = edt_find.text.toString().trim()
        listStudent.any {
            it.checkFind(findStudent) == true
        }
        studentAdapter.setData(listStudent)
    }
}