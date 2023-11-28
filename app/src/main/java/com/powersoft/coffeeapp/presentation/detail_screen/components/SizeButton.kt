package com.powersoft.coffeeapp.presentation.detail_screen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun SizeButton(modifier: Modifier, text: String, textColor: Color) {
    Text(
        text,
        fontSize = 16.sp,
        modifier = modifier,
        color = textColor,
        textAlign = TextAlign.Center
    )
}