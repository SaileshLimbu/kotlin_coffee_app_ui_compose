package com.powersoft.coffeeapp.presentation.order_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.powersoft.coffeeapp.presentation.ui.common.Dimens
import com.powersoft.coffeeapp.presentation.ui.theme.Shape

@Composable
fun CustomButton(onClick: () -> Unit, icon: Int, label: String) {
    Row(
        modifier = Modifier
            .padding(end = Dimens.SmallPadding)
            .clip(Shape.large)
            .clickable { onClick() }
            .background(Color.White)
            .border(width = 1.dp, color = Color.LightGray.copy(0.7f), shape = Shape.large)
            .padding(horizontal = Dimens.NormalPadding, vertical = Dimens.SmallPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier
                .size(18.dp)
                .padding(end = Dimens.SmallPadding),
        )

        Text(
            text = label,
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}