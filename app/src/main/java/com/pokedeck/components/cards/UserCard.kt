package com.pokedeck.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun UserCard(
    imageRes: Int,
    size: Dp,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .height(size)
            .width(size)
            .clip(RoundedCornerShape(size))
            .border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(size))
    ){
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.matchParentSize()
        )
    }
}