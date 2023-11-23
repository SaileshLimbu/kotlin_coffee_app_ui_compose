package com.powersoft.coffeeapp.presentation.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.NormalPadding
import com.powersoft.coffeeapp.presentation.ui.common.Dimens.SmallPadding

@Composable
fun Toolbar(onBackPressed: () -> Unit, title: String, showIcon: Boolean = false, icon: Int = 0) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    onBackPressed()
                }
                .size(45.dp)
                .padding(SmallPadding)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall
        )
        if (showIcon) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .padding(NormalPadding)
            )
        } else {
            HSpace(width = 45.dp)
        }
    }
}