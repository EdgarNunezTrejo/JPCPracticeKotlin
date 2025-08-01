package com.example.jetpackcomposeproject.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier = Modifier) {
    var myValue by remember { mutableStateOf(0.2f) }
    Column(modifier = modifier.padding(horizontal = 30.dp)) {
        Slider(
            enabled = true,
            value = myValue,
            onValueChange = { myValue = it },
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                disabledThumbColor = Color.DarkGray,
                activeTrackColor = Color.Red,
                activeTickColor = Color.Blue,
                disabledActiveTrackColor = Color.Gray,
                disabledActiveTickColor = Color.DarkGray,

                inactiveTickColor = Color.Green,
                inactiveTrackColor = Color.Blue,
            ),
        )
        Text(myValue.toString())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySliderAdvance(modifier: Modifier = Modifier) {
    var example by remember { mutableStateOf(":(") }
    val state = remember {
        SliderState(
            5f,
            valueRange = 0f..10f,
            steps = 3,
            onValueChangeFinished = {
                example = ":)"
            }
        )
    }

    Column(modifier = modifier.padding(horizontal = 32.dp)) {
        Slider(state)
        Text(example)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {
    val state = remember {
        RangeSliderState(
            activeRangeStart = 3f,
            activeRangeEnd = 6f,
            valueRange = 0f..10f,
            onValueChangeFinished = {},
            steps = 9
        )

    }
    Column(modifier = modifier.padding(horizontal = 32.dp)) {
        RangeSlider(
            state = state,
            startThumb = {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = CircleShape)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) { Text(state.activeRangeStart.toString()) }
            })
        Text(state.activeRangeStart.toString())
    }

}