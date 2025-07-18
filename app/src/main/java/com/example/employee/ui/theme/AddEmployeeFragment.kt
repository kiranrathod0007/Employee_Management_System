package com.example.employee.ui.theme


import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.employee.data.Employee
import com.example.employee.databinding.FragmentAddEmployeeBinding
import com.example.employee.viewmodel.EmployeeViewModel

class AddEmployeeFragment : Fragment() {


    private lateinit var viewModel: EmployeeViewModel

    private var _binding: FragmentAddEmployeeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddEmployeeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity())[EmployeeViewModel::class.java]


        super.onViewCreated(view, savedInstanceState) // It's good practice to call super
        binding.btnSave.setOnClickListener { // Error occurs here
            validateAndSave()
        }
    }

    private fun validateAndSave() {
        val first = binding.etFirstName.text.toString().trim()
        val middle = binding.etMiddleName.text.toString().trim()
        val last = binding.etLastName.text.toString().trim()
        val phone = binding.etPhone.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val department = binding.etDepartment.text.toString().trim()
        val designation = binding.etDesignation.text.toString().trim()

        var isValid = true

        // Reset errors
        binding.firstNameLayout.error = null
        binding.middleNameLayout.error = null
        binding.lastNameLayout.error = null
        binding.phoneLayout.error = null
        binding.emailLayout.error = null
        binding.departmentLayout.error = null
        binding.designationLayout.error = null

        if (TextUtils.isEmpty(first)) {
            binding.firstNameLayout.error = "Required"
            isValid = false
        }
        if (TextUtils.isEmpty(middle)) {
            binding.middleNameLayout.error = "Required"
            isValid = false
        }
        if (TextUtils.isEmpty(last)) {
            binding.lastNameLayout.error = "Required"
            isValid = false
        }
        if (TextUtils.isEmpty(department)) {
            binding.departmentLayout.error = "Required"
            isValid = false
        }
        if (TextUtils.isEmpty(designation)) {
            binding.designationLayout.error = "Required"
            isValid = false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailLayout.error = "Invalid email"
            isValid = false
        }
        if (phone.length != 10 || phone.startsWith("0") || phone.startsWith("1")
            || phone.startsWith("2") || phone.startsWith("3") || phone.startsWith("4")
        ) {
            binding.phoneLayout.error = "Invalid phone"
            isValid = false
        }

        if (isValid) {
            Toast.makeText(requireContext(), "Valid input. Saving...", Toast.LENGTH_SHORT).show()
            val employee = Employee(
                firstName = first,
                middleName = middle,
                lastName = last,
                phone = phone,
                email = email,
                department = department,
                designation = designation
            )

            viewModel.insert(employee)
            Toast.makeText(requireContext(), "Employee added!", Toast.LENGTH_SHORT).show()


            // TODO: Insert into Room DB here
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}