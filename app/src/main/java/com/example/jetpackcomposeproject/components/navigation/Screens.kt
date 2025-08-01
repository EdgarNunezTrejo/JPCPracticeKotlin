package com.example.jetpackcomposeproject.components.navigation

import com.example.jetpackcomposeproject.components.navigation.examples.model.SettingModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id:String)

@Serializable
data class Settings(val settingModel: SettingModel)