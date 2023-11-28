package com.powersoft.coffeeapp.presentation.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.powersoft.coffeeapp.R
import com.powersoft.coffeeapp.domain.model.Coffee
import com.powersoft.coffeeapp.presentation.ui.common.Dimens
import com.powersoft.coffeeapp.presentation.ui.theme.Black200
import com.powersoft.coffeeapp.presentation.ui.theme.Orange800
import com.powersoft.coffeeapp.presentation.ui.theme.Shape

@Composable
fun ItemCoffee(coffee: Coffee, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = Dimens.NormalPadding, bottom = Dimens.NormalPadding)
            .clip(Shape.medium)
            .clickable { onClick() }
            .background(color = Color.White)
    ) {
        Column {
            Image(
                painter = painterResource(id = coffee.coffeeImage),
                contentDescription = null,
                modifier = Modifier
                    .clip(Shape.medium)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = coffee.coffeeName,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = Dimens.NormalPadding)
            )
            Text(
                text = coffee.extraItem,
                fontSize = 12.sp,
                color = Color.Black.copy(0.5f),
                modifier = Modifier.padding(start = Dimens.NormalPadding)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.NormalPadding),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$ ${coffee.price}",
                    fontWeight = FontWeight.SemiBold,
                )
                Icon(
                    imageVector = Icons.Default.Add, contentDescription = null,
                    modifier = Modifier
                        .clip(Shape.small)
                        .size(32.dp)
                        .background(color = Orange800)
                        .padding(Dimens.SmallPadding),
                    tint = Color.White
                )
            }
        }
        Row(
            modifier = Modifier
                .background(
                    color = Black200.copy(0.6f),
                    shape = RoundedCornerShape(topStart = 120.dp, bottomEnd = Dimens.NormalPadding)
                )
                .padding(horizontal = Dimens.SmallPadding, vertical = Dimens.TinyPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = null,
                modifier = Modifier
                    .size(14.dp)
                    .padding(end = Dimens.TinyPadding),
                tint = Color.Yellow
            )
            Text(
                text = "${coffee.rating}",
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}