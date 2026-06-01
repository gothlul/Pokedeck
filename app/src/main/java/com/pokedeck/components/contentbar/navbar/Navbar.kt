package com.pokedeck.components.contentbar.navbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pokedeck.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.pokedeck.ui.theme.Blue

@Composable
fun Navbar(
    navItems: List<NavItem>
){
    var selectedIndex by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ){
        Image(
            painter = painterResource(id = R.drawable.navbar_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 60.dp),

            horizontalArrangement = Arrangement.spacedBy(25.dp, Alignment.CenterHorizontally)
        ) {
            navItems.forEachIndexed { index, item ->
                val isSelected = selectedIndex == index

                val bgColor: Color by animateColorAsState(if (isSelected) Color.White else Color.Transparent)

                Surface(
                    modifier = Modifier
                        .size(72.dp)
                        .clickable {
                            selectedIndex = index
                            item.onTap()
                        },
                    color = bgColor,
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(20.dp),
                        colorFilter = ColorFilter.tint(if(isSelected) Blue else Color.White.copy(alpha = 0.5f))
                    )
                }
            }
        }
    }
}
