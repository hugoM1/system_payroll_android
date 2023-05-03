package com.hugo.payrollapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugo.payrollapp.data.model.Employee
import com.hugo.payrollapp.domain.GetAllRecentEmployeesUseCase
import com.hugo.payrollapp.domain.GetEmployeeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllRecentEmployeesUseCase: GetAllRecentEmployeesUseCase,
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val empModel = MutableLiveData<ArrayList<Employee>>()

    fun onCreate() {
        viewModelScope.launch {
            empModel.postValue(getAllRecentEmployeesUseCase.invoke())
        }
    }
}