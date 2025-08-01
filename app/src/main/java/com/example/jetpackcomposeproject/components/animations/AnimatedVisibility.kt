package com.example.jetpackcomposeproject.components.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimatedVisibility(modifier: Modifier = Modifier) {
    var showView by remember { mutableStateOf(false) }
    Column (modifier
        .fillMaxSize()
        .background(Color.White)){
        Button(onClick = {showView = !showView}) {
            Text("Mostrar/Ocultar")
        }
        Spacer(Modifier.height(50.dp))
        AnimatedVisibility(showView, enter = scaleIn(), exit = scaleOut()) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color.Red)
            )
        }
    }
}