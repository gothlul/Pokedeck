package com.pokedeck.components.modals

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContent
import com.pokedeck.components.buttons.Button

@Composable
fun Modal(
    content: @Composable () -> Unit,
){
    Box(){
        Column() {
            content()
            Button()
        }
    }
}