package com.pokedeck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pokedeck.components.buttons.Button
import com.pokedeck.components.pages.MainPage
import com.pokedeck.ui.theme.PokedeckTheme

class LoginPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedeckTheme {
                MainPage() {

                }
            }
        }
    }
}