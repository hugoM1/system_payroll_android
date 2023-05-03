package com.hugo.payrollapp.data.network

import com.hugo.payrollapp.data.model.Employee
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface PayrollApiClient {
    @GET("employees/{id}")
    suspend fun getEmployeeById(@Path("id") employee_id: String): Response<Employee>
    @Headers("Content-Type: application/json")
    @POST("employees/")
    suspend fun addNewEmployee(@Body employee: Employee): Response<Employee>

    @GET("employees/all/recent")
    suspend fun getAllRecentEmployees(): Response<ArrayList<Employee>>
}