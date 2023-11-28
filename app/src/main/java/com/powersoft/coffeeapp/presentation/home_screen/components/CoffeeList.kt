package com.powersoft.coffeeapp.presentation.home_screen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.powersoft.coffeeapp.domain.model.Coffee

@Composable
fun CoffeeList(items: List<Coffee>, onClick: (index: Int) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Set the number of columns in the grid
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items.size) { index ->
            ItemCoffee(items[index], onClick = { onClick(index) })
        }
    }
}