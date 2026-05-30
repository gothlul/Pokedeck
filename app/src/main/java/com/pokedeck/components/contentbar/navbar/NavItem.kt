package com.pokedeck.components.contentbar.navbar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

class NavItem(
    val icon: Int,
    val iconColor: Color = Color.Black,
    val onTap: () -> Unit = {}
)