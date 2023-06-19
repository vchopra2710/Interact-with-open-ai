package com.app.open.ai.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.open.ai.domain.model.NavigationItem
import com.app.open.ai.ui.compose.IconRes
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

private val navigationItem: List<NavigationItem> = NavigationItem.values().toList()

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController = rememberAnimatedNavController(),
) = Scaffold(
    bottomBar = { NavigationBar(navController = navController) },
    modifier = Modifier.navigationBarsPadding(),
    backgroundColor = Color.Black,
) { paddingValues ->
    Box(modifier = Modifier.padding(paddingValues)) {
        HomeNavigation(navController = navController)
    }
}

@Composable
private fun NavigationBar(navController: NavHostController) = BottomNavigation(
    backgroundColor = Color.Black,
    contentColor = Color.White
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    navigationItem.forEach { item ->
        BottomNavigationItem(
            icon = { IconRes(icon = item.icon) },
            label = { Text(text = stringResource(id = item.title)) },
            selected = currentRoute == item.route,
            selectedContentColor = Color.White,
            unselectedContentColor = Color.White.copy(alpha = 0.4f),
            alwaysShowLabel = true,
            onClick = {
                navController.navigate(item.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}