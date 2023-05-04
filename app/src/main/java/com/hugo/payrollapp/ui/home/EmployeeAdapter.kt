package com.hugo.payrollapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hugo.payrollapp.R
import com.hugo.payrollapp.data.model.Employee

class EmployeeAdapter(
    var employeeList: MutableList<Employee>,
    private val onEmployeeClickListener: OnEmployeeClickListener
) : RecyclerView.Adapter<EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EmployeeViewHolder(layoutInflater.inflate(R.layout.employee_item, parent, false))
    }

    override fun getItemCount(): Int = employeeList.size

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employeeList[position]
        holder.bind(employee)

        holder.itemView.setOnClickListener {
            onEmployeeClickListener.onClick(employee)
        }
    }

    fun setEmployeesList(list: MutableList<Employee>) {
        val diffEmployee = DiffUtil.calculateDiff(EmployeesCallback(employeeList, list))
        employeeList.clear()
        employeeList.addAll(list)
        diffEmployee.dispatchUpdatesTo(this)
    }

    class EmployeesCallback(
        private val employeesOldList: MutableList<Employee>,
        private val employeesNewList: MutableList<Employee>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return employeesOldList.size
        }

        override fun getNewListSize(): Int {
            return employeesNewList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return employeesOldList[oldItemPosition].id == employeesNewList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return when {
                employeesOldList[oldItemPosition].id == employeesNewList[newItemPosition].id -> true
                employeesOldList[oldItemPosition].id == employeesNewList[newItemPosition].id -> true
                else -> false
            }
        }
    }

    class OnEmployeeClickListener(val clickListener: (employee: Employee) -> Unit) {
        fun onClick(employee: Employee) = clickListener(employee)
    }
}

