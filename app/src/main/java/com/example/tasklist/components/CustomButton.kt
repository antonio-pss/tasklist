package com.example.tasklist.components

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier,
    label: String,
    buttonColor: Color,
) {
    Button(
        onClick = onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = Color.White
        )
    ) {
        Text(text = label, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}