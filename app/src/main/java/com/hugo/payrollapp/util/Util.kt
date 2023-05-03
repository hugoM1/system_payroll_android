package com.hugo.payrollapp.util

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar

@SuppressLint("SimpleDateFormat")
fun getCurrentDate(): String{
    val time = Calendar.getInstance().time
    val formatter = SimpleDateFormat("yyyy-MM-dd")
    val current = formatter.format(time)
    return current.toString()
}