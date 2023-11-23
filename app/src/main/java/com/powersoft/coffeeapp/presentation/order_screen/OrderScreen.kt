package com.powersoft.coffeeapp.presentation.order_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.powersoft.coffeeapp.R
import com.powersoft.coffeeapp.domain.model.Coffee
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.MediumPadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.NormalPadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.SemiLargePadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.SmallPadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.TinyPadding
import com.powersoft.coffeeapp.presentation.ui.common.Divider
import com.powersoft.coffeeapp.presentation.ui.common.HSpace
import com.powersoft.coffeeapp.presentation.ui.common.Toolbar
import com.powersoft.coffeeapp.presentation.ui.common.VSpace
import com.powersoft.coffeeapp.presentation.ui.theme.Orange800
import com.powersoft.coffeeapp.presentation.ui.theme.Shape
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun OrderScreen(coffee: Coffee, navigator: DestinationsNavigator) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.White
        )
    }

    Column {
        Toolbar(onBackPressed = { navigator.popBackStack() }, title = "Order")
        Column(Modifier.padding(horizontal = SemiLargePadding)) {
            ContentOrder(coffee)
        }
    }
}

@Composable
fun ContentOrder(coffee: Coffee) {
    OrderTabs()
    VSpace()
    Text(
        text = "Delivery Address",
        fontWeight = FontWeight.SemiBold,
        color = Color.Black,
        fontSize = 16.sp
    )
    VSpace()
    Text(
        text = "Jl. Kpg Sutoyo",
        fontWeight = FontWeight.SemiBold,
        color = Color.Black,
        fontSize = 14.sp
    )
    VSpace(TinyPadding)
    Text(
        text = "Kpg. Sutoyo No. 620, Bilzen, Tanjungbalai.", color = Color.Gray,
        fontSize = 14.sp
    )
    VSpace()
    Row {
        CustomButton(onClick = { }, icon = R.drawable.ic_edit, label = "Edit Address")
        CustomButton(onClick = { }, icon = R.drawable.ic_document, label = "Add Note")
    }
    VSpace(SemiLargePadding)
    Divider()
    VSpace(SemiLargePadding)
    OrderCountLayout(coffee)
    VSpace(SemiLargePadding)
    Divider()
    VSpace(SemiLargePadding)
    CouponLayout()
    VSpace()
    Text(text = "Payment Summary", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
    VSpace(height = 8.dp)
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Price")
        Text(text = "$ ${coffee.price}", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
    }
    VSpace(SmallPadding)
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Delivery Fee", fontSize = 16.sp)
        Row {
            Text(text = "$ 2.0", textDecoration = TextDecoration.LineThrough, fontSize = 16.sp)
            HSpace(SmallPadding)
            Text(text = "$ 1.0", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
        }
    }
    VSpace()
    Divider()
    VSpace()
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Total Payment", fontSize = 16.sp)
        Text(text = "$ ${coffee.price + 1}", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
    }
    VSpace()
    Row {
        Icon(
            painter = painterResource(id = R.drawable.ic_money), contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Orange800
        )
        HSpace(width = NormalPadding)
        Row(
            modifier = Modifier.background(
                color = Color.LightGray,
                shape = Shape.large
            )
        ) {
            Text(
                text = "Cash", fontSize = 12.sp, color = Color.White,
                modifier = Modifier
                    .background(
                        color = Orange800,
                        shape = Shape.large
                    )
                    .padding(horizontal = NormalPadding, vertical = TinyPadding)
            )
            Text(
                text = "$ ${coffee.price + 1}", fontSize = 12.sp,
                modifier = Modifier
                    .padding(
                        start = TinyPadding,
                        end = NormalPadding,
                        top = TinyPadding,
                        bottom = TinyPadding
                    )
            )
        }
    }
    VSpace(SemiLargePadding)
    Button(
        onClick = { /*TODO*/ },
        shape = Shape.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = Orange800
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Order",
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            modifier = Modifier.padding(TinyPadding)
        )
    }
}

@Composable
fun CouponLayout() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(Shape.medium)
            .border(
                width = 1.dp,
                color = Color.LightGray.copy(0.6f),
                shape = Shape.medium
            )
            .padding(MediumPadding),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_discount),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Orange800
            )
            HSpace(width = NormalPadding)
            Text(
                text = "1 Discount is applied",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
    }
}

@Composable
fun OrderCountLayout(coffee: Coffee) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = coffee.coffeeImage),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(Shape.medium),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = coffee.coffeeName,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = NormalPadding)
                )
                Text(
                    text = coffee.extraItem,
                    fontSize = 12.sp,
                    color = Color.Black.copy(0.5f),
                    modifier = Modifier.padding(start = NormalPadding)
                )
            }
        }

        OrderCounter()
    }
}

@Composable
fun OrderCounter() {
    var count by rememberSaveable {
        mutableIntStateOf(1)
    }
    Row {
        CircleButton(
            onClick = { if (count > 0) count-- },
            icon = R.drawable.ic_minus,
            isEnabled = count > 0
        )
        Text(
            text = "$count",
            modifier = Modifier.padding(horizontal = NormalPadding),
            fontWeight = FontWeight.SemiBold
        )
        CircleButton(onClick = { count++ }, icon = R.drawable.ic_add, isEnabled = true)
    }
}

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
            .padding(SmallPadding),
        tint = if (isEnabled) Color.Black else Color.LightGray
    )
}

@Composable
fun CustomButton(onClick: () -> Unit, icon: Int, label: String) {
    Row(
        modifier = Modifier
            .padding(end = SmallPadding)
            .clip(Shape.large)
            .clickable { onClick() }
            .background(Color.White)
            .border(width = 1.dp, color = Color.LightGray.copy(0.7f), shape = Shape.large)
            .padding(horizontal = NormalPadding, vertical = SmallPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier
                .size(18.dp)
                .padding(end = SmallPadding),
        )

        Text(
            text = label,
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun OrderTabs() {
    var orderType by remember { mutableIntStateOf(0) }

    Row(
        modifier = Modifier
            .background(color = Color.Gray.copy(0.1f), shape = Shape.medium)
            .padding(TinyPadding)
    ) {
        OrderButton(
            text = "Deliver",
            isSelected = orderType == 0,
            onClick = { orderType = 0 },
            modifier = Modifier.weight(1f)
        )

        OrderButton(
            text = "Pick Up",
            isSelected = orderType == 1,
            onClick = { orderType = 1 },
            modifier = Modifier.weight(1f)
        )
    }
}

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
            .padding(SmallPadding),
        color = if (isSelected) Color.White else Color.Black,
        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
        textAlign = TextAlign.Center
    )
}