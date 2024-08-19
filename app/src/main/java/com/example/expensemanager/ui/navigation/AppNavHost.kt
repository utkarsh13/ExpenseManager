package com.example.expensemanager.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.expensemanager.ui.composables.screens.AnalysisScreen
import com.example.expensemanager.ui.composables.screens.CalendarScreen
import com.example.expensemanager.ui.composables.screens.HomeScreen
import com.example.expensemanager.ui.composables.screens.SettingsScreen
import com.example.expensemanager.utils.RouteConstants

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = RouteConstants.CALENDAR,
        enterTransition = { fadeIn(animationSpec = tween(200)) },
        exitTransition = { fadeOut(animationSpec = tween(200)) },
    ) {

        composable(RouteConstants.HOME) {
            HomeScreen()
        }

        composable(RouteConstants.CALENDAR) {
            CalendarScreen()
        }

        composable(RouteConstants.ANALYSIS) {
            AnalysisScreen()
        }

        composable(RouteConstants.BUDGETS) {
            SettingsScreen()
        }

    }
}