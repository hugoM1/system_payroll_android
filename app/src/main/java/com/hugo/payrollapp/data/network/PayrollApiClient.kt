package com.hugo.payrollapp.data.network

import com.hugo.payrollapp.data.model.Employee
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PayrollApiClient {
    @GET("employees/{id}")
    suspend fun getEmployeeById(@Path("id") employee_id: String):
            Response<Employee>
}