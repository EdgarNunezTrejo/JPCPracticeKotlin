package com.example.jetpackcomposeproject.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyComplexLayout(modifier: Modifier){
    Column (modifier = modifier) {
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Red)){}
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Blue)){
            Row {
                Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Gray)){}
                Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Green)){}
            }
        }
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Yellow)){}
    }
}