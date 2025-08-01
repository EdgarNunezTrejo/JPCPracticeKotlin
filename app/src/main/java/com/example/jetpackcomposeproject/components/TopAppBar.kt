package com.example.jetpackcomposeproject.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.jetpackcomposeproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier, onNavSelected: ()-> Unit) {
    TopAppBar(
        title = { Text("My App") },
        navigationIcon = { Icon(painter = painterResource(R.drawable.ic_diaper), contentDescription = "", modifier = Modifier.clickable { onNavSelected() }) },
        actions = {
            Icon(painter = painterResource(R.drawable.ic_diaper), contentDescription = "")
            Icon(painter = painterResource(R.drawable.ic_diaper), contentDescription = "")
            Icon(painter = painterResource(R.drawable.ic_diaper), contentDescription = "")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.Magenta,
            actionIconContentColor = Color.Red,
            scrolledContainerColor = Color.Black
        ),
    )
}
