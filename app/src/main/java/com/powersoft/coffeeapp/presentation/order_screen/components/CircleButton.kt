package com.powersoft.coffeeapp.presentation.order_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.powersoft.coffeeapp.presentation.ui.common.Dimens
import com.powersoft.coffeeapp.presentation.ui.theme.Shape

@Composable
fun CircleButton(onClick: () -> Unit, icon: Int, isEnabled: Boolean) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = Modifier
            .clip(Shape.large)
            .clickable { onClick() }
            .size(30.dp)
            .border(1.dp, color = Color.LightGray, shape = Shape.large)
            .padding(Dimens.SmallPadding),
        tint = if (isEnabled) Color.Black else Color.LightGray
    )
}