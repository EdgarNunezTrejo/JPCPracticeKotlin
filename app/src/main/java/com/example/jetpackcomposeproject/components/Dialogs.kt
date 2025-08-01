package com.example.jetpackcomposeproject.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import java.util.Calendar
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcomposeproject.components.model.PokemonCombat

@Composable
fun MyDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Entendido")
                }
            },
            text = { Text("Esta es una descripcion") },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            },
            title = { Text("Quieres hacer esta acción?") },
            icon = { Icon(imageVector = Icons.Default.Info, contentDescription = "") },
            shape = RoundedCornerShape(12),
            containerColor = Color.White,
            iconContentColor = Color.Red,
            titleContentColor = Color.Red,
            textContentColor = Color.Red,
            tonalElevation = 12.dp,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.Inherit,
                usePlatformDefaultWidth = true,
                decorFitsSystemWindows = true
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDateDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }

    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, +1)
    calendar.set(Calendar.MONDAY, Calendar.JANUARY)
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        initialDisplayedMonthMillis = calendar.timeInMillis,
        yearRange = 2024..2025,
        initialDisplayMode = DisplayMode.Picker,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val filterCalendar = Calendar.getInstance().apply { timeInMillis = utcTimeMillis }
                val day = filterCalendar.get(Calendar.DAY_OF_MONTH)
                return day % 2 == 0
            }
        }
    )


    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = {},
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    val result = datePickerState.selectedDateMillis
                    if (result !== null) {
                        val newCalendar = Calendar.getInstance().apply { timeInMillis = result }
                        val day = newCalendar.get(Calendar.DAY_OF_MONTH)
                        val month = newCalendar.get(Calendar.MONTH) + 1
                        Log.i("Fecha seleccionada", "DIA: $day, MONTH: $month")
                    }
                }) { Text("Confirmar") }
            },
            colors = DatePickerDefaults.colors()
        ) {
            DatePicker(datePickerState)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTimePicker(modifier: Modifier = Modifier) {
    var showTimePicker by remember { mutableStateOf(true) }
    val timerPickerState = rememberTimePickerState(
        initialHour = 19,
        initialMinute = 33,
        is24Hour = false
    )

    if (showTimePicker) {
        Dialog(onDismissRequest = { showTimePicker = false }) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
            ) {
                TimePicker(
                    timerPickerState,
                    layoutType = TimePickerLayoutType.Vertical,
                    colors = TimePickerDefaults.colors(
                        clockDialColor = Color.Red,
                        clockDialSelectedContentColor = Color.Red,
                        selectorColor = Color.White,
                        clockDialUnselectedContentColor = Color.White,
                        containerColor = Color.White,
                        periodSelectorBorderColor = Color.Red,
                        periodSelectorUnselectedContentColor = Color.Red
                    )
                )
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    modifier: Modifier = Modifier,
    showDialog: Boolean,
    pokemonCombat: PokemonCombat,
    onStartCombat: ()->Unit,
    onDismissDialog: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = { onDismissDialog() }) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(24)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(24.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = pokemonCombat.pokemonA,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text("VS")
                    Text(
                        text = pokemonCombat.pokemonB,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Button(onClick = { onStartCombat() }) {
                    Text("A LUCHAR!")
                }

                TextButton(onClick = {onDismissDialog()}) {
                    Text("CANCELAR")
                }
            }
        }
    }
}