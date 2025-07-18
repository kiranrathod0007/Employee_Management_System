package com.example.employee.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.employee.data.Employee
import com.example.employee.data.EmployeeDatabase
import com.example.employee.data.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: EmployeeRepository
    val allEmployees: LiveData<List<Employee>>

    init {
        val dao = EmployeeDatabase.getDatabase(application).employeeDao()
        repository = EmployeeRepository(dao)
        allEmployees = repository.allEmployees
    }

    fun insert(employee: Employee) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(employee)
            Log.d("EmployeeViewModel", "Employee inserted: $employee")
        }
    }
}
