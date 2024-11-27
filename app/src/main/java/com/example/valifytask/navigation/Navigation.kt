package com.example.valifytask.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.valifytask.ui.presentation.screens.CaptureImageScreen
import com.example.valifytask.ui.presentation.screens.RegistrationScreen

enum class Screen {
    REGISTER,
    CAPTURE_IMAGE,
}
sealed class NavigationItem(val route: String) {
    object Register : NavigationItem(Screen.REGISTER.name)
    object CaptureImage : NavigationItem(Screen.CAPTURE_IMAGE.name)
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Register.route,

    ) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Register.route) {
            RegistrationScreen(navController = navController)
        }
        composable(NavigationItem.CaptureImage.route) {
            CaptureImageScreen(navController)
        }
    }
}

