package com.example.jetpackcomposeproject.components.navigation.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeproject.components.navigation.examples.model.SettingModel

@Composable
fun DetailScreen(id: String, navigateToSettings: (SettingModel)->Unit) {
    val settingModel = SettingModel(id=id, darkMode = true)
    Column (Modifier.fillMaxSize().background(Color.Blue), horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(Modifier.weight(1f))
        Text("Detail", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(onClick = {navigateToSettings(settingModel)}) {
            Text("Ajustes")
        }
        Spacer(Modifier.weight(1f))
    }
}