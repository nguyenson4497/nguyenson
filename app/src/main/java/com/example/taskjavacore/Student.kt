package com.example.taskjavacore

class Student(
    var name: String, var yearOfBirth: String,
    var phoneNumber: String, var field: String,
    var level: String
) {
    fun checkFind(string: String): Boolean {
        if (name.contains(string, true) || yearOfBirth.contains(string, true)
            || phoneNumber.contains(string, true) || field.contains(string, true)
            || level.contains(string, true)
        ) {
            return true
        }
        return false
    }
}