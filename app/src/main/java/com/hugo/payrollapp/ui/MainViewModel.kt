package com.hugo.payrollapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugo.payrollapp.data.model.Employee
import com.hugo.payrollapp.domain.GetEmployeeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getEmployeeUseCase: GetEmployeeUseCase
) : ViewModel() {

    val employeeModel = MutableLiveData<Employee>()

    fun onOncreate(employeeId: String){
        viewModelScope.launch {
            employeeModel.postValue(getEmployeeUseCase.invoke(employeeId))
        }
    }
}