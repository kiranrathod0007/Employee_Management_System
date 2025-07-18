package com.example.employee.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmployeeDao {

    @Insert
    suspend fun insert(employee: Employee)

    @Query("SELECT * FROM employees ORDER BY id DESC")
    fun getAllEmployees(): LiveData<List<Employee>>
}
