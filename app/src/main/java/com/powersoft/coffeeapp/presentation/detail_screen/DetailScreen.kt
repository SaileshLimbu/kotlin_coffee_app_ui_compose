package com.powersoft.coffeeapp.presentation.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.powersoft.coffeeapp.R
import com.powersoft.coffeeapp.domain.model.Coffee
import com.powersoft.coffeeapp.presentation.destinations.OrderScreenDestination
import com.powersoft.coffeeapp.presentation.ui.common.Toolbar
import com.powersoft.coffeeapp.presentation.ui.theme.Orange500
import com.powersoft.coffeeapp.presentation.ui.theme.Orange800
import com.powersoft.coffeeapp.presentation.ui.theme.Shape
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DetailScreen(coffee: Coffee, navigator: DestinationsNavigator) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.White
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Toolbar(
                onBackPressed = { navigator.popBackStack() },
                title = "Detail", true, R.drawable.ic_outline_heart
            )
            ContentDetail(coffee)
        }
        BottomBuyNowBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            price = coffee.price,
            onClick = { navigator.navigate(OrderScreenDestination(coffee)) }
        )
    }
}

@Composable
fun BottomBuyNowBar(modifier: Modifier = Modifier, price: Float, onClick: () -> Unit) {
    Row(
        modifier = modifier
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
            )
            .background(color = Color.White)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "Price", color = Color.Gray, fontSize = 14.sp)
            Text(
                text = "$ $price",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Orange800
            )
        }
        Button(
            onClick = onClick, colors = ButtonDefaults.buttonColors(
                containerColor = Orange800,
            ),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(50.dp),
            shape = Shape.medium
        ) {
            Text(text = "Buy Now", color = Color.White)
        }
    }
}

@Composable
fun ContentDetail(coffee: Coffee) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, top = 12.dp)
    ) {
        Image(
            painter = painterResource(id = coffee.coffeeImage), contentDescription = null,
            modifier = Modifier
                .clip(Shape.medium)
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = coffee.coffeeName,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Text(
            text = coffee.extraItem,
            fontSize = 12.sp,
            color = Color.Black.copy(0.5f)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_star),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 4.dp),
                    tint = Orange500
                )
                Text(
                    text = "${coffee.rating}",
                    color = Color.Black
                )
                Text(
                    text = " (230)",
                    fontSize = 12.sp,
                    color = Color.Black.copy(0.5f)
                )
            }

            Row {
                IngredientIcon(icon = R.drawable.ic_bean)
                Spacer(modifier = Modifier.width(6.dp))
                IngredientIcon(icon = R.drawable.ic_milk)
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(1.dp)
                .background(Color.Gray.copy(0.2f))
        )

        Description()
        SizeSelector()
    }
}

@Composable
fun Description() {
    Text(
        text = "Description",
        fontWeight = FontWeight.SemiBold,
        color = Color.Black
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "A cappuccino is an approximately 150 ml (5 oz) beverage, with 25 ml of espresso coffee and 85ml of fresh milk the fo..",
        maxLines = 3,
        color = Color.Gray,
        fontSize = 14.sp
    )
}

@Composable
fun SizeSelector() {
    Spacer(modifier = Modifier.height(12.dp))
    Text(
        "Size",
        fontWeight = FontWeight.SemiBold
    )

    Spacer(modifier = Modifier.height(8.dp))
    val sizeList = arrayOf("S", "M", "L")
    var selectedSize by remember {
        mutableIntStateOf(0)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        sizeList.forEachIndexed { index, size ->
            val isSelected = (selectedSize == index)
            val modifier = Modifier
                .clip(Shape.medium)
                .fillMaxWidth()
                .weight(1f)
                .padding(end = 4.dp)
                .border(
                    width = 1.dp,
                    color = if (isSelected) Orange800 else Color.Gray,
                    shape = Shape.medium
                )
                .background(
                    color = if (isSelected) Orange500.copy(0.2f) else Color.White,
                    shape = Shape.medium
                )
                .clickable { selectedSize = index }
                .padding(6.dp)
            SizeButton(
                modifier,
                text = size,
                textColor = if (isSelected) Orange800 else Color.Black
            )
        }
    }
}

@Composable
fun SizeButton(modifier: Modifier, text: String, textColor: Color) {
    Text(
        text,
        modifier = modifier,
        color = textColor,
        textAlign = TextAlign.Center
    )
}

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