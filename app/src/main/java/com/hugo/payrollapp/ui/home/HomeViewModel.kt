package com.hugo.payrollapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugo.payrollapp.data.model.Employee
import com.hugo.payrollapp.domain.GetEmployeeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getEmployeeUseCase: GetEmployeeUseCase
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val empModel = MutableLiveData<Employee>()

    fun onCreate(employeeId: String) {
        viewModelScope.launch {
            empModel.postValue(getEmployeeUseCase.invoke(employeeId))
        }
    }
}