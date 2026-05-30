package com.pokedeck.components.contentbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pokedeck.R
import com.pokedeck.components.cards.UserCard
import com.pokedeck.core.models.User

@Composable
fun Topbar(
    user: User
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Column() {
            Box(
                modifier = Modifier.height(IntrinsicSize.Min)
            ){
                Image(
                    painter = painterResource(id = R.drawable.topbar_background),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                )
                Box(
                    modifier = Modifier
                        .padding(
                            top = 18.dp,
                            bottom = 20.dp,
                            start = 30.dp,
                            end = 30.dp
                        )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        UserCard(
                            imageRes = user.profileImage,
                            size = 80.dp,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            Text(
                                user.nickname,
                                color = Color.Black,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Column(
                                verticalArrangement = Arrangement.spacedBy(15.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Progressbar(
                                        modifier = Modifier.weight(1f),
                                        progress = user.conclusionPercentage
                                    )
                                    Text(
                                        user.conclusionPercentage.toInt().toString().uppercase()+"%",
                                        color = Color.White,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                                Text(
                                    "repetidas: ".uppercase(),
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth()
                    .drawBehind() {
                        val strokeWidth = 4.dp.toPx()
                        val color = Color.Black

                        drawLine(
                            color = color,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = strokeWidth
                        )

                        drawLine(
                            color = color,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = strokeWidth
                        )
                    },
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    modifier = Modifier
                        .padding(all = 5.dp)
                        .height(25.dp),
                    painter = painterResource(id = R.drawable.simple_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}
