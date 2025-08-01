package com.example.jetpackcomposeproject.components.animations

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeproject.components.navigation.examples.DetailScreen
import com.example.jetpackcomposeproject.components.navigation.examples.HomeScreen
import com.example.jetpackcomposeproject.components.navigation.examples.LoginScreen

@Composable
fun MyCrossFade(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("Home") }
    Column (Modifier.padding(top = 32.dp)){
        Row  {
            Text("Home", modifier = Modifier.clickable { currentScreen = "Home" })
            Text("Detail", modifier = Modifier.clickable { currentScreen = "Detail" })
            Text("Login", modifier = Modifier.clickable { currentScreen = "Login" })
        }

        Crossfade(targetState = currentScreen) { screen ->
            when(screen){
                "Home"-> HomeScreen(navigateBack = {}, navigateToDetail = {})
                "Detail"-> DetailScreen(id = "", navigateToSettings = {})
                "Login"-> LoginScreen {  }
            }
        }
    }

}