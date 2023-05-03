package com.hugo.payrollapp.domain

import com.hugo.payrollapp.data.PayrollRepository
import com.hugo.payrollapp.data.model.Employee
import javax.inject.Inject

class GetAllRecentEmployeesUseCase @Inject constructor(
    private val repository: PayrollRepository
){
    suspend operator fun invoke(): ArrayList<Employee> =
        repository.getAllRecentEmployees()
}