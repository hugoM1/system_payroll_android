package com.hugo.payrollapp.data

import com.hugo.payrollapp.data.model.Employee
import com.hugo.payrollapp.data.network.PayrollService
import javax.inject.Inject

class PayrollRepository @Inject constructor(
    private val api:PayrollService
) {
    suspend fun getEmployeeById(employeeId: String): Employee{
        return api.getEmployeeById(employeeId)
    }

    suspend fun addNewEmployee(employee: Employee): Employee{
        return api.addNewEmployee(employee)
    }

    suspend fun getAllRecentEmployees(): ArrayList<Employee>{
        return api.getAllRecentEmployees()
    }
}