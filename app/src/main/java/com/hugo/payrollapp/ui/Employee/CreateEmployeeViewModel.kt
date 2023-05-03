package com.hugo.payrollapp.ui.Employee

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugo.payrollapp.data.model.Employee
import com.hugo.payrollapp.domain.AddNewEmployeeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateEmployeeViewModel @Inject constructor(
    private val addNewEmployeeUseCase: AddNewEmployeeUseCase
): ViewModel() {
     val employeeModel = MutableLiveData<Employee>()

    fun onCreate(employee: Employee){
        viewModelScope.launch {
            employeeModel.postValue(addNewEmployeeUseCase.invoke(employee))
        }
    }
}