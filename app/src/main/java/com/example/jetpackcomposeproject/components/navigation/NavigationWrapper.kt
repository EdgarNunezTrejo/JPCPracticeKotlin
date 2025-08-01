package com.example.jetpackcomposeproject.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.jetpackcomposeproject.components.navigation.examples.DetailScreen
import com.example.jetpackcomposeproject.components.navigation.examples.HomeScreen
import com.example.jetpackcomposeproject.components.navigation.examples.LoginScreen
import com.example.jetpackcomposeproject.components.navigation.examples.SettingsScreen
import com.example.jetpackcomposeproject.components.navigation.examples.model.SettingModel
import com.example.jetpackcomposeproject.components.navigation.types.createNavType
import com.example.jetpackcomposeproject.components.navigation.types.settingsModeltype
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(navigateToDetail = { navController.navigate(Home) })
        }

        composable<Home> {
            HomeScreen(
                navigateBack = { navController.popBackStack() },
                navigateToDetail = { id->navController.navigate(Detail(id = id)) })
        }

        composable<Detail> { navBackStackEntry ->
            var detail = navBackStackEntry.toRoute<Detail>()
            DetailScreen(id = detail.id, navigateToSettings = {navController.navigate(Settings(it))})
        }

        composable<Settings> (typeMap = mapOf(typeOf<SettingModel>() to createNavType<SettingModel>())){ navBackStackEntry ->
            val setting = navBackStackEntry.toRoute<Settings>()
            SettingsScreen(setting.settingModel, navigateToLogin = {
                navController.navigate(Login){
                    popUpTo<Login>{inclusive = true}
                }
            })
        }
    }
}