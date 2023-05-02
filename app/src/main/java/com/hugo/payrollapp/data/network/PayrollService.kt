package com.hugo.payrollapp.data.network

import com.hugo.payrollapp.data.model.Employee
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
class PayrollService @Inject constructor(private val api: PayrollApiClient) {

    suspend fun getEmployeeById(employeeId: String): Employee{
        return withContext(Dispatchers.IO){
            val response = api.getEmployeeById(employeeId)
            response.body()!!
        }
    }
}