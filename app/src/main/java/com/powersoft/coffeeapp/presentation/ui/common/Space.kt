package com.powersoft.coffeeapp.presentation.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.NormalPadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.TinyPadding

@Composable
fun VSpace(height: Dp = NormalPadding) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun HSpace(width: Dp = TinyPadding) {
    Spacer(modifier = Modifier.width(width))
}

@Composable
fun Divider(height: Dp = 1.dp, color: Color = Color.LightGray) {
    androidx.compose.material3.Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        color = color
    )
}