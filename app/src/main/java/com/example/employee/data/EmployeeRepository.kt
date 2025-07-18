package com.example.employee.data

import androidx.lifecycle.LiveData

class EmployeeRepository(private val dao: EmployeeDao) {

    val allEmployees: LiveData<List<Employee>> = dao.getAllEmployees()

    suspend fun insert(employee: Employee) {
        dao.insert(employee)
    }
}
