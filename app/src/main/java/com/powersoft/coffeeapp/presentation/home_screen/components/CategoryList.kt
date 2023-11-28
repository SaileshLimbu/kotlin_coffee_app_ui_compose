package com.powersoft.coffeeapp.presentation.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.powersoft.coffeeapp.presentation.ui.common.Dimens
import com.powersoft.coffeeapp.presentation.ui.theme.Orange800
import com.powersoft.coffeeapp.presentation.ui.theme.Shape

@Composable
fun CategoryList(categories: List<String>, selectedIndex: Int, onClick: (pos: Int) -> Unit) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(count = categories.size) {
            Text(
                text = categories[it],
                fontSize = 14.sp,
                color = if (selectedIndex == it) Color.White else Color.Black,
                modifier = Modifier
                    .padding(end = Dimens.TinyPadding)
                    .clip(Shape.medium)
                    .clickable { onClick(it) }
                    .background(
                        color = if (selectedIndex == it) Orange800 else Color.White,
                        shape = Shape.medium
                    )
                    .padding(horizontal = Dimens.MediumPadding, vertical = Dimens.SmallPadding)
            )
        }
    }
}