package com.example.expensemanager.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.expensemanager.ui.composables.screens.CalendarScreen
import com.example.expensemanager.ui.composables.screens.HomeScreen
import com.example.expensemanager.ui.composables.screens.SettingsScreen

@Composable
fun ExpenseManagerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = AppBottomBarScreen.HOME.route,
        enterTransition = { fadeIn(animationSpec = tween(200)) },
        exitTransition = { fadeOut(animationSpec = tween(200)) },
    ) {

        composable(AppBottomBarScreen.HOME.route) {
            HomeScreen()
        }

        composable(AppBottomBarScreen.CALENDAR.route) {
            CalendarScreen()
        }

        composable(AppBottomBarScreen.SETTINGS.route) {
            SettingsScreen()
        }

    }
}