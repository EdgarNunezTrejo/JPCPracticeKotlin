package com.example.jetpackcomposeproject.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeproject.components.model.DrawerItem
import kotlinx.coroutines.launch

@Composable
fun MyModalDrawer(
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {

    val scope = rememberCoroutineScope()

    val myItems = listOf(
        DrawerItem(title = "Home", icon = Icons.Default.Home, notification = 3),
        DrawerItem(title = "Fav", icon = Icons.Default.Favorite, notification = 0),
        DrawerItem(title = "Build", icon = Icons.Default.Build, notification = 5),
        DrawerItem(title = "Call", icon = Icons.Default.Call, notification = 0),
        DrawerItem(title = "Location", icon = Icons.Default.LocationOn, notification = 4),
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            Spacer(Modifier.height(44.dp))

            myItems.forEachIndexed { index, drawerItem ->
                MyNavigationDrawerItem(drawerItem, selected = selectedIndex == index) {
                    selectedIndex = index
                }
            }


        }
    }, scrimColor = Color.Red.copy(0.7f)) {
        content()
    }
}

@Composable
fun MyNavigationDrawerItem(drawerItem: DrawerItem, selected: Boolean, onClick: () -> Unit) {
    NavigationDrawerItem(
        label = { Text(drawerItem.title) },
        selected = selected,
        onClick = onClick,
        icon = { Icon(imageVector = drawerItem.icon, contentDescription = "") },
        badge = {
            if (drawerItem.notification > 0) {
                Badge(
                    containerColor = if(selected) Color.White else Color.Red,
                    contentColor = if(!selected) Color.White else Color.Red
                ) { Text(drawerItem.notification.toString()) }
            }
        },
        shape = RoundedCornerShape(0),
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = Color.Red,
            selectedIconColor = Color.White,
            selectedTextColor = Color.White,
            selectedBadgeColor = Color.Yellow,
            unselectedContainerColor = Color.White,
            unselectedTextColor = Color.Red,
            unselectedBadgeColor = Color.Green,
            unselectedIconColor = Color.Red
        )
    )
}