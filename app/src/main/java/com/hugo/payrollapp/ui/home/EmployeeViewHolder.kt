package com.hugo.payrollapp.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hugo.payrollapp.data.model.Employee
import com.hugo.payrollapp.databinding.EmployeeItemBinding

class EmployeeViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    private val bindind = EmployeeItemBinding.bind(view)

    fun bind(employee: Employee){
        bindind.eid.text = employee.id.toString()
        bindind.eName.text = employee.name
        bindind.eSalary.text = String.format("$%s",employee.salary.totalSalary.toString())
        bindind.eBaseSalary.text = String.format("$%s",employee.salary.baseSalary.toString())
        bindind.eTax.text = String.format("$%s", employee.salary.taxISR.toString())
        bindind.eValesx.text = String.format("$%s", employee.salary.valesDespensa.toString())
        bindind.ePaymentDate.text = employee.salary.paymentDate
    }
}