package com.pokedeck.components.contentbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pokedeck.R
import com.pokedeck.components.cards.UserCard

@Composable
fun Progressbar(
    progress: Double,
    modifier: Modifier = Modifier
){
    val progressIndicator = (if (progress > 1) progress / 100 else progress).toFloat()

    Box(
        modifier = modifier
            .height(14.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(Color.White)
    ){
        Image(
            painter = painterResource(id = R.drawable.progress_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .drawWithContent() {
                    clipRect(right = size.width * progressIndicator) {
                        this@drawWithContent.drawContent()
                    }
                }
        )
    }
}
