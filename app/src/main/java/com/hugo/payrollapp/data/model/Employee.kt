package com.hugo.payrollapp.data.model

import com.hugo.payrollapp.util.getCurrentDate


data class Employee(
    val id: Int = 0,
    val name: String = "John Doe",
    val rol: String = "chofer",
    val startDate: String = getCurrentDate(),
    val salary: Salary = Salary()
)

data class Salary(
    val employeeId: Int = 0,
    val baseSalary: Float = 0.0F,
    val hoursWorked: Float = 0.0F,
    val deliveriesCompleted: Int = 0,
    val bonusCargo: Float = 0.0F,
    val taxISR: Float = 0.0F,
    val valesDespensa: Float = 0.0F,
    val paymentDate: String = getCurrentDate()
)