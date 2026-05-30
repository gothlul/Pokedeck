package com.pokedeck.components.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.pokedeck.R
import com.pokedeck.components.contentbar.Topbar
import com.pokedeck.components.contentbar.navbar.NavItem
import com.pokedeck.components.contentbar.navbar.Navbar
import com.pokedeck.core.controllers.Controller
import com.pokedeck.core.controllers.Navigator
import com.pokedeck.core.controllers.Screen

@SuppressLint("ConfigurationScreenWidthHeight")

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    bottomBar: @Composable () -> Unit = {
        Navbar(
            navItems = listOf(
                NavItem(
                    icon = R.drawable.catalog_icon,
                    onTap = {
                        Navigator.setNavState(Screen.CATALOG)
                    }
                ),
                NavItem(
                    icon = R.drawable.inventory_icon,
                    onTap = {
                        Navigator.setNavState(Screen.INVENTORY)
                    }
                ),
                NavItem(
                    icon = R.drawable.profile_icon,
                    onTap = {
                        Navigator.setNavState(Screen.PROFILE)
                    }
                )
            )
        )
    },
    content: @Composable () -> Unit,
) {
    Scaffold (
        modifier = modifier
            .fillMaxSize(),
        containerColor = Color.White,
        bottomBar = bottomBar
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Topbar(user = Controller.user)
            Spacer(modifier = Modifier.height((2.5f).dp))
            Box(
                modifier = Modifier.padding(
                    top = innerPadding.calculateTopPadding(),
                    end = PaddingValues(horizontal = 24.dp).calculateEndPadding(LayoutDirection.Ltr),
                    start = PaddingValues(horizontal = 24.dp).calculateStartPadding(LayoutDirection.Ltr),
                    bottom = innerPadding.calculateBottomPadding()
                )
            ){
                content()
            }
        }
    }
}