package com.pokedeck.core.controllers

import androidx.compose.runtime.mutableStateOf
import com.pokedeck.core.models.User
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.pokedeck.R

class Controller {
    companion object{
        var user by mutableStateOf(
            User(
                "Teste",
                "",
                "",
                "",
                "",
                "",
                R.drawable.charizard,
                10.0
            )
        )
        var token by mutableStateOf("")

        fun login(email: String, password: String) {

        }
    }

}