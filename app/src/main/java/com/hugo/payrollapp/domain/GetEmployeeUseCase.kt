package com.hugo.payrollapp.domain

import com.hugo.payrollapp.data.PayrollRepository
import com.hugo.payrollapp.data.model.Employee
import javax.inject.Inject

class GetEmployeeUseCase @Inject constructor(
    private val repository: PayrollRepository
) {
    suspend operator fun invoke(employeeId: String): Employee =
        repository.getEmployeeById(employeeId)
}