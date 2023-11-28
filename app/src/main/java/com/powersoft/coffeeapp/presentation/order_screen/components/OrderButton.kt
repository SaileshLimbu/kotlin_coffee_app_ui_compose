package com.powersoft.coffeeapp.presentation.order_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.powersoft.coffeeapp.presentation.ui.common.Dimens
import com.powersoft.coffeeapp.presentation.ui.theme.Orange800
import com.powersoft.coffeeapp.presentation.ui.theme.Shape

@Composable
fun OrderButton(text: String, isSelected: Boolean, onClick: () -> Unit, modifier: Modifier) {
    val backgroundColor = if (isSelected) Orange800 else Color.Transparent

    Text(
        text = text,
        fontSize = 16.sp,
        modifier = modifier
            .fillMaxWidth()
            .background(color = backgroundColor, shape = Shape.medium)
            .clickable(onClick = onClick)
            .padding(Dimens.SmallPadding),
        color = if (isSelected) Color.White else Color.Black,
        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
        textAlign = TextAlign.Center
    )
}