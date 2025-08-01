package com.example.jetpackcomposeproject.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import com.example.jetpackcomposeproject.R
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeproject.components.state.CheckBoxState

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var switchState by remember { mutableStateOf(true) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it },
            thumbContent = {
                Icon(
                    painter = painterResource(R.drawable.ic_diaper),
                    contentDescription = null,
                )
            },
            enabled = true,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Blue
            )
        )
    }
}

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(true) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { state = !state }) {
            Checkbox(checked = state, onCheckedChange = { state = it })
            Text("Acepto términos y condiciones")
        }
    }
}

@Composable
fun CheckBoxWithText(
    checkBoxState: CheckBoxState,
    onCheckBoxState: (CheckBoxState) -> Unit
) {
    Box(contentAlignment = Alignment.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onCheckBoxState(checkBoxState) }) {
            Checkbox(
                checked = checkBoxState.checked,
                onCheckedChange = { onCheckBoxState(checkBoxState) }
            )
            Text(text = checkBoxState.label)
        }
    }
}

@Composable
fun ParentCheckedBox(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(
            listOf(
                CheckBoxState(
                    "terms",
                    "Aceptar Términos y condiciones",
                    true
                ),
                CheckBoxState(
                    "newsletter",
                    "Recibir Newsletter",
                    true
                ),
                CheckBoxState(
                    "updates",
                    "Recibir Actualizaciones",
                    true
                )
            )
        )
    }

    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            CheckBoxWithText(checkBoxState = myState) {
                state = state.map {
                    if (it.id === myState.id) {
                        myState.copy(checked = !myState.checked)
                    } else {
                        it
                    }
                }
            }
        }
    }
}

@Composable
fun TriStateCheckBox(modifier: Modifier = Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var child2 by remember { mutableStateOf(false) }
    var child3 by remember { mutableStateOf(false) }

    LaunchedEffect(child2, child3) {
        parentState = when {
            child2 && child3 -> ToggleableState.On
            !child2 && !child3 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                child2 = newState
                child3 = newState
            })
            Text("Select all")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child2, onCheckedChange = { child2 = it })
            Text("Ejemplo 2")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child3, onCheckedChange = { child3 = it })
            Text("Ejemplo 3")
        }

    }
}

@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(true) }
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = state,
            onClick = { state = true },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Blue,
                disabledUnselectedColor = Color.Magenta,
                disabledSelectedColor = Color.Green
            )
        )
    }
}

@Composable
fun RadioButtonComponent(name: String, selectedName: String, onItemSelected: (String) -> Unit) {
    Row (verticalAlignment = Alignment.CenterVertically){
        RadioButton(selected = name === selectedName, onClick = { onItemSelected(name) })
        Text(name, modifier = Modifier.clickable { onItemSelected(name) })
    }
}

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    var selectedName: String by remember{ mutableStateOf("") }
    Column (modifier = modifier) {
        RadioButtonComponent("Edgar", selectedName = selectedName){selectedName = it}
        RadioButtonComponent("Joon", selectedName = selectedName){selectedName = it}
        RadioButtonComponent("Ola", selectedName = selectedName){selectedName = it}
        RadioButtonComponent("Pau", selectedName = selectedName){selectedName = it}
        RadioButtonComponent("Karimua", selectedName = selectedName){selectedName = it}
    }
}