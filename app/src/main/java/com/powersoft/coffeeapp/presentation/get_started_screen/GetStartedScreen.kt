package com.powersoft.coffeeapp.presentation.get_started_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.powersoft.coffeeapp.R
import com.powersoft.coffeeapp.presentation.destinations.HomeScreenDestination
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.ExtraLargePadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.LargePadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.SmallPadding
import com.powersoft.coffeeapp.presentation.ui.theme.Orange800
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun GetStartedScreen(
    navigator: DestinationsNavigator
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Black
        )
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(ExtraLargePadding),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "Coffee so good,\nyour taste buds\nwill love it.",
                color = Color.White,
                fontSize = 34.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "The best grain, the finest roast, the powerful flavor.",
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Button(
                onClick = {
                    navigator.navigate(HomeScreenDestination())
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = LargePadding),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange800
                )
            ) {
                Text(
                    text = "Get Started",
                    color = Color.White,
                    modifier = Modifier.padding(SmallPadding)
                )
            }
        }
    }
}