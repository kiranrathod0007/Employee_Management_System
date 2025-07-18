package com.example.employee.ui.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.findNavController
import com.example.employee.R
import com.example.employee.adapter.EmployeeAdapter
import com.example.employee.databinding.FragmentEmployeeListBinding
import com.example.employee.viewmodel.EmployeeViewModel

class EmployeeListFragment : Fragment() {

    private var _binding: FragmentEmployeeListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: EmployeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[EmployeeViewModel::class.java]

        binding.employeeRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.allEmployees.observe(viewLifecycleOwner) { list ->
            binding.tvTotalEmployees.text = "Total Employees: ${list.size}"
            binding.employeeRecyclerView.adapter = EmployeeAdapter(list)
        }


        // 👉 FAB Navigation to AddEmployeeFragment
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_employeeListFragment_to_addEmployeeFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
