package com.powersoft.coffeeapp.presentation.detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.powersoft.coffeeapp.presentation.ui.theme.Orange800
import com.powersoft.coffeeapp.presentation.ui.theme.Shape

@Composable
fun IngredientIcon(icon: Int) {
    Icon(
        painter = painterResource(id = icon), contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .background(
                color = Color.LightGray.copy(0.2f),
                shape = Shape.medium
            )
            .padding(6.dp),
        tint = Orange800
    )
}