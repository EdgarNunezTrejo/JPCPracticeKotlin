package com.example.jetpackcomposeproject.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.jetpackcomposeproject.R

@Composable
fun MyImage(modifier: Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.edd),
            contentDescription = "Avatar image profile",
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(10))
                .border(
                    width = 5.dp,
                    shape = RoundedCornerShape(10),
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Red,
                            Color.Blue,
                            Color.Green
                        )
                    )
                ),
            contentScale = ContentScale.Crop
        )

    }
}

@Composable
fun MyNetworkImage(modifier: Modifier) {
        AsyncImage(
            model = "https://avatars.githubusercontent.com/u/33459415?v=4",
            contentDescription = "Image from network",
            modifier = Modifier.size(200.dp),
            onError = {
                Log.i("Image", "Error: ${it.result.throwable.message}")
            }
        )

}

@Composable
fun MyIcon(modifier: Modifier){
    Icon(painter = painterResource(R.drawable.ic_diaper), contentDescription = "", modifier = modifier.size(300.dp), tint = Color.Blue)
}