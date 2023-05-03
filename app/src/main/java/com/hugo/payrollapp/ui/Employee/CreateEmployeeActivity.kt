package com.hugo.payrollapp.ui.Employee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.hugo.payrollapp.R
import com.hugo.payrollapp.data.model.Employee
import com.hugo.payrollapp.data.model.Salary
import com.hugo.payrollapp.data.transformer.Transformer
import com.hugo.payrollapp.databinding.ActivityCreateEmployeeBinding
import com.hugo.payrollapp.util.getCurrentDate
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class CreateEmployeeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateEmployeeBinding

    private val createEmployeeViewModel: CreateEmployeeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateEmployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        createEmployeeViewModel.employeeModel.observe(this, Observer {
            Log.wtf("Employee Created", it.name)
            finishAndRemoveTask()
        })

        binding.saveEmployee.setOnClickListener {
            createEmployee()
        }
    }

    private fun createEmployee() {
        val employee = Employee(
            name = binding.eName.text.toString(),
            rol = getRol(),
            startDate = getCurrentDate()
        )
        createEmployeeViewModel.onCreate(Transformer.emplooyeeToJson(employee))
    }

    private fun getRol(): String {
        if (binding.driver.isChecked) return "chofer"
        if (binding.charger.isChecked) return "cargador"
        if (binding.aux.isChecked) return "auxiliar"
        return ""
    }
}