package com.powersoft.coffeeapp.presentation.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.powersoft.coffeeapp.R
import com.powersoft.coffeeapp.presentation.ui.common.Dimens
import com.powersoft.coffeeapp.presentation.ui.theme.Orange800
import com.powersoft.coffeeapp.presentation.ui.theme.Shape

@Composable
fun BottomNavigation(modifier: Modifier) {
    val navigationIcons = listOf(
        R.drawable.ic_home,
        R.drawable.ic_heart,
        R.drawable.ic_bag,
        R.drawable.ic_notification
    )
    var selectedIndex by remember { mutableIntStateOf(0) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = modifier
            .shadow(
                7.dp,
                shape = RoundedCornerShape(
                    topStart = Dimens.NormalPadding,
                    topEnd = Dimens.NormalPadding
                )
            )
            .fillMaxWidth()
            .height(60.dp)
            .background(
                Color.White,
                RoundedCornerShape(topStart = Dimens.NormalPadding, topEnd = Dimens.NormalPadding)
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(count = 4) {
            Box(
                modifier = Modifier
                    .clickable { selectedIndex = it }
                    .height(60.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(navigationIcons[it]), contentDescription = null,
                        tint = if (selectedIndex == it) Orange800 else Color.Gray,
                        modifier = Modifier
                            .size(25.dp)
                    )
                    if (selectedIndex == it) {
                        Box(
                            modifier = Modifier
                                .width(12.dp)
                                .padding(top = Dimens.TinyPadding)
                                .clip(Shape.large)
                                .height(4.dp)
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            Orange800.copy(0.5f),
                                            Orange800
                                        )
                                    )
                                )
                        )
                    }
                }
            }
        }
    }
}