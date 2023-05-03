package com.hugo.payrollapp.data.transformer

import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.hugo.payrollapp.data.model.Employee
import com.hugo.payrollapp.util.getCurrentDate
import java.io.StringReader

class Transformer {
    companion object {
        fun emplooyeeToJson(employee: Employee): Employee {
            val gson = Gson()
            val reader = JsonReader(
                StringReader(
                    "{\"id\":1," +
                            "\"name\":" + employee.name + "," +
                            "\"rol\":" + employee.rol + "," +
                            "\"startDate\":"+ getCurrentDate() +"," +
                            "\"salary\":{\"employeeId\":1," +
                            "\"baseSalary\":200.0," +
                            "\"hoursWorked\":80.0," +
                            "\"deliveriesCompleted\":56," +
                            "\"bonusCargo\":36.0," +
                            "\"taxISR\":34.0," +
                            "\"valesDespensa\":45.0," +
                            "\"paymentDate\":\"1923-02-02\"}}"
                )
            )
            reader.isLenient = true
            return gson.fromJson(reader, Employee::class.java)
        }
    }
}