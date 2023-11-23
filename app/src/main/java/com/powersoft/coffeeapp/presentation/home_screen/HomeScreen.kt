package com.powersoft.coffeeapp.presentation.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.powersoft.coffeeapp.R
import com.powersoft.coffeeapp.domain.model.Coffee
import com.powersoft.coffeeapp.presentation.destinations.DetailScreenDestination
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.ExtraLargePadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.LargePadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.MediumPadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.NormalPadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.SemiLargePadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.SmallPadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.TinyPadding
import com.powersoft.coffeeapp.presentation.ui.theme.Black200
import com.powersoft.coffeeapp.presentation.ui.theme.Black600
import com.powersoft.coffeeapp.presentation.ui.theme.Orange800
import com.powersoft.coffeeapp.presentation.ui.theme.Shape
import com.powersoft.coffeeapp.presentation.ui.theme.White500
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Black600
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White500)
            .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(color = Black600)
                .padding(SemiLargePadding)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SemiLargePadding)
                .padding(bottom = ExtraLargePadding)
        ) {
            LocationAndProfile()
            SearchBox()
            Banner()
            CategoryList()
            Spacer(modifier = Modifier.height(LargePadding))
            CoffeeList(navigator)
        }
        BottomNavigation(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun BottomNavigation(modifier: Modifier) {
    val navigationIcons = listOf(
        R.drawable.ic_home,
        R.drawable.ic_heart,
        R.drawable.ic_bag,
        R.drawable.ic_notification
    )
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = modifier
            .shadow(
                7.dp,
                shape = RoundedCornerShape(topStart = NormalPadding, topEnd = NormalPadding)
            )
            .fillMaxWidth()
            .height(60.dp)
            .background(
                Color.White,
                RoundedCornerShape(topStart = NormalPadding, topEnd = NormalPadding)
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
                                .padding(top = TinyPadding)
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

@Composable
fun LocationAndProfile() {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Location", color = Color.White.copy(0.4f), fontSize = 14.sp
            )
            Text(
                text = "Bilzen, Tanjungbalai", color = Color.White, fontSize = 16.sp
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = null,
            modifier = Modifier.size(35.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = LargePadding)
            .background(
                color = Black200, shape = Shape.medium
            )
            .height(50.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(start = SmallPadding)
                    .size(25.dp)
            )
            var searchText by remember {
                mutableStateOf("")
            }
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    textColor = Color.White
                ),
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 14.sp
                ),
                placeholder = {
                    Text(text = "Search", fontSize = 14.sp, color = Color.White)
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            Icon(
                painterResource(id = R.drawable.ic_filter),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = TinyPadding)
                    .clip(Shape.medium)
                    .size(40.dp)
                    .background(color = Orange800)
                    .padding(SmallPadding),
                tint = Color.White
            )
        }
    }
}

@Composable
fun Banner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = SemiLargePadding, bottom = NormalPadding)
            .height(160.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_banner),
            contentDescription = null,
            modifier = Modifier
                .clip(Shape.medium)
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(start = SemiLargePadding, top = LargePadding),
        ) {
            Text(
                text = "Promo",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(bottom = NormalPadding)
                    .background(Color.Red, shape = Shape.small)
                    .padding(horizontal = SmallPadding, vertical = TinyPadding),
                color = Color.White,
            )
            Text(
                text = "Buy one get\none FREE",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    shadow = Shadow(
                        color = Black200,
                        offset = Offset(2.0f, 5.0f),
                        blurRadius = 2f
                    )
                )
            )
        }
    }
}

@Composable
fun CategoryList() {
    val categories = listOf("Cappuccino", "Machiato", "Latta", "Americano")

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(count = categories.size) {
            Text(
                text = categories[it],
                fontSize = 14.sp,
                color = if (selectedIndex == it) Color.White else Color.Black,
                modifier = Modifier
                    .padding(end = TinyPadding)
                    .clip(Shape.medium)
                    .clickable {
                        selectedIndex = it
                    }
                    .background(
                        color = if (selectedIndex == it) Orange800 else Color.White,
                        shape = Shape.medium
                    )
                    .padding(horizontal = MediumPadding, vertical = SmallPadding)
            )
        }
    }
}

@Composable
fun CoffeeList(navigator: DestinationsNavigator) {
    val items = arrayOf(
        Coffee("Cappuccino", "with Chocolate", 4.8f, R.drawable.ic_coffee2, 4.53f),
        Coffee("Cappuccino", "with OatMilk", 4.9f, R.drawable.ic_coffee4, 3.90f),
        Coffee("Cappuccino", "with IceCream", 4.5f, R.drawable.ic_coffee1, 4.66f),
        Coffee("Cappuccino", "with Milk", 4.6f, R.drawable.ic_coffee3, 3.80f),
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Set the number of columns in the grid
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items.size) { index ->
            ItemCoffee(items[index]) {
                navigator.navigate(DetailScreenDestination(items[index]))
            }
        }
    }
}

@Composable
fun ItemCoffee(coffee: Coffee, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = NormalPadding, bottom = NormalPadding)
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
                modifier = Modifier.padding(start = NormalPadding)
            )
            Text(
                text = coffee.extraItem,
                fontSize = 12.sp,
                color = Color.Black.copy(0.5f),
                modifier = Modifier.padding(start = NormalPadding)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(NormalPadding),
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
                        .padding(SmallPadding),
                    tint = Color.White
                )
            }
        }
        Row(
            modifier = Modifier
                .background(
                    color = Black200.copy(0.6f),
                    shape = RoundedCornerShape(topStart = 120.dp, bottomEnd = NormalPadding)
                )
                .padding(horizontal = SmallPadding, vertical = TinyPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = null,
                modifier = Modifier
                    .size(14.dp)
                    .padding(end = TinyPadding),
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
