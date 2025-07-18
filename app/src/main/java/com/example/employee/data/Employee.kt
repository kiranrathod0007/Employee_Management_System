package com.example.employee.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val firstName: String,
    val middleName: String,
    val lastName: String,
    val phone: String,
    val email: String,
    val department: String,
    val designation: String
)
