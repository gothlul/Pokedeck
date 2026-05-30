package com.pokedeck.core.controllers

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

enum class Screen { CATALOG, INVENTORY, PROFILE }

class NavigatorController {
    companion object{
        var currentNavigatorIndex by mutableStateOf(Screen.CATALOG)

        fun setNavState(newState: Screen) {
            currentNavigatorIndex = newState
        }
    }

}