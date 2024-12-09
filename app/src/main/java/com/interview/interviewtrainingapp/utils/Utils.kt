package com.interview.interviewtrainingapp.utils

import android.app.Activity
import android.widget.Toast
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun getColors() = MaterialTheme.colorScheme

fun String?.value() = this ?: ""

fun Boolean?.value() = this ?: false



fun Activity.showToastMessage(message: String){
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()
}