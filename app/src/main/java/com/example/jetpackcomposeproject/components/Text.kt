package com.example.jetpackcomposeproject.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun MyTexts(modifier: Modifier) {
    Column (modifier = modifier){
        Text(text = "Edgar")
        Text("Edgar rojo", color = Color.Red)
        Text("Edgar font", fontSize = 25.sp)
        Text("FontStyle", fontStyle = FontStyle.Italic)
        Text("FontWeight", fontWeight = FontWeight.ExtraBold)
        Text("LetterSpacing", letterSpacing = 2.sp)
        Text("TextDecoration", textDecoration = TextDecoration.LineThrough)
        Text("This is a long text because we need this for an excercise jdsjdjsjdsdjsaldjlsajdsla", modifier = Modifier.background(Color.Red).fillMaxWidth(), maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
}