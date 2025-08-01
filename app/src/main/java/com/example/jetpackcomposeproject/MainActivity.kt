package com.example.jetpackcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.jetpackcomposeproject.components.MyCustomDialog
import com.example.jetpackcomposeproject.components.animations.FullAnimateAsState
import com.example.jetpackcomposeproject.components.animations.MyAnimateContent
import com.example.jetpackcomposeproject.components.animations.MyAnimatedVisibility
import com.example.jetpackcomposeproject.components.animations.MyContentSize
import com.example.jetpackcomposeproject.components.animations.MyCrossFade
import com.example.jetpackcomposeproject.components.animations.MyInfiniteTransition
import com.example.jetpackcomposeproject.components.navigation.NavigationWrapper
import com.example.jetpackcomposeproject.components.model.PokemonCombat
import com.example.jetpackcomposeproject.ui.theme.JetPackComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeProjectTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                // MyDialog()
                // MyDateDialog()
                // MyTimePicker()
                var showDialog by remember { mutableStateOf(false) }

                val pokemonCombat = PokemonCombat(pokemonA = "Pikachu", pokemonB = "Gengar")

                MyCustomDialog(
                    showDialog = showDialog,
                    pokemonCombat = pokemonCombat,
                    onStartCombat = {
                        showDialog = false
                    },
                    onDismissDialog = {
                        showDialog = false
                    })

                MyInfiniteTransition()

                //NavigationWrapper()

                // Log.i("Show", "is combat shown? $showDialog")
//                MyModalDrawer(drawerState) {
//                    Scaffold(
//                        modifier = Modifier.fillMaxSize(),
//                        topBar = { MyTopAppBar() { scope.launch { drawerState.open() } } },
//                        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
//                        floatingActionButton = { MyFAB() { showDialog = true } },
//                        floatingActionButtonPosition = FabPosition.End,
//                        bottomBar = { MyNavigationBar() }
//                    ) { innerPadding ->
//                        // MyCard(Modifier.padding(innerPadding))
//                        Box(
//                            modifier = Modifier
//                                .padding(innerPadding)
//                                .fillMaxSize(),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            // InteractionSourceExample()
//                            // MyLaunchedEffect(){}
//                            // MyDerivedStateOf()
//                            // MyBasicList(){}
//                            // MyGridList()
//                        }
//
//                    }
//                }
            }
        }
    }
}
