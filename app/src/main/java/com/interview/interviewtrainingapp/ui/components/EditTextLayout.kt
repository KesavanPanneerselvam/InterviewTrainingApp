package com.interview.interviewtrainingapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun EdittextLayout(title: String, text: MutableState<String>, keyboardType: KeyboardType = KeyboardType.Text, maxLength: Int = 100) {
    OutlinedTextField(
        value = text.value,
        onValueChange = { if(it.length <= maxLength) text.value = it },
        label = { LabelContent(title) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),

        modifier = Modifier.fillMaxWidth().padding(0.dp)
    )
}