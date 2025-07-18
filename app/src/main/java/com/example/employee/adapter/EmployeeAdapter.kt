package com.example.employee.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employee.databinding.ItemEmployeeBinding
import com.example.employee.data.Employee

class EmployeeAdapter(private val employeeList: List<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    inner class EmployeeViewHolder(val binding: ItemEmployeeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding = ItemEmployeeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val emp = employeeList[position]
        holder.binding.tvName.text = "${emp.firstName} ${emp.middleName} ${emp.lastName}"
        holder.binding.tvPhone.text = emp.phone
        holder.binding.tvEmail.text = emp.email
        holder.binding.tvDept.text = emp.department
        holder.binding.tvDesg.text = emp.designation
    }

    override fun getItemCount(): Int = employeeList.size
}
