package com.pokedeck.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pokedeck.ui.theme.Magenta

@Composable
fun Button(
    modifier: Modifier = Modifier,
    label: String,
    color: Color = Magenta,
    onClick: () -> Unit,
    offSet: Boolean = false
){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(if (offSet) Color.White else color)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center,

    ){
        Text(
            label.uppercase(),
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 20.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (!offSet) Color.White else color
        )
    }
}