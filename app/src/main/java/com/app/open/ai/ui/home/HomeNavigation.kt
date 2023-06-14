package com.app.open.ai.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.app.open.ai.domain.model.NavigationItem.CHAT
import com.app.open.ai.domain.model.NavigationItem.Image
import com.app.open.ai.ui.chat.ChatScreen
import com.app.open.ai.ui.image.ImageScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeNavigation(navController: NavHostController) = AnimatedNavHost(
    navController = navController,
    startDestination = CHAT.route
) {
    chatScreen()
    imageScreen()
}

@OptIn(ExperimentalAnimationApi::class)
private fun NavGraphBuilder.chatScreen() = composable(
    route = CHAT.route,
    content = { ChatScreen() }
)

@OptIn(ExperimentalAnimationApi::class)
private fun NavGraphBuilder.imageScreen() = composable(
    route = Image.route,
    content = { ImageScreen() })