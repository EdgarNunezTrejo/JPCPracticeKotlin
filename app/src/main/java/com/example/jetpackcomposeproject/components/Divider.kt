package com.example.jetpackcomposeproject.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column (modifier){
        Text("Parte de arriba")
        HorizontalDivider()
        Text("Parte de abajo")

        Row(modifier = Modifier.height(150.dp)) {
            Text("Izquierda")
            VerticalDivider(thickness = 6.dp)
            Text("Derecha")
        }
    }
}