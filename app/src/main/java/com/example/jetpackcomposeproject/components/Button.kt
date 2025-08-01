package com.example.jetpackcomposeproject.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeproject.R

@Composable
fun MyButtons(modifier: Modifier) {
    Column(modifier = modifier) {
        Button(onClick = { Log.i("Edgar", "Botón pulsado") }) {
            Text("Púlsame")
        }

        OutlinedButton(onClick = { Log.i("Edgar", "Botón pulsado") }) {
            Text("Outlined")
        }

        TextButton(onClick = {}) {
            Text("TextButton")
        }
        ElevatedButton(onClick = {}) {
            Text("Elevated Button")
        }
    }
}

@Composable
fun MyFAB(modifier: Modifier = Modifier, showCombat: ()->Unit = {}) {

    FloatingActionButton(
        onClick = {showCombat()},
        shape = RoundedCornerShape(15.dp),
        containerColor = Color.Red,
        contentColor = Color.White,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 12.dp)
    ) { Icon(painter = painterResource(R.drawable.ic_add), contentDescription = "") }
}