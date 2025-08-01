package com.example.jetpackcomposeproject.components

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.jetpackcomposeproject.R

@Composable
fun MyBadge(modifier: Modifier = Modifier) {
    Badge( containerColor = Color.Blue, contentColor = Color.Green){
        Text("3")
    }
}

@Composable
fun MyBadgeBox(modifier: Modifier = Modifier) {
    BadgedBox(modifier = modifier, badge = { MyBadge() }) {
        Icon(painter = painterResource(R.drawable.ic_info), contentDescription = "")
    }
}