package com.example.expensemanager.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.expensemanager.ui.composables.screens.AccountScreen
import com.example.expensemanager.ui.composables.screens.AnalysisScreen
import com.example.expensemanager.ui.composables.screens.BackupScreen
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
        startDestination = AppBottomBarScreens.HOME.route,
        enterTransition = { fadeIn(animationSpec = tween(200)) },
        exitTransition = { fadeOut(animationSpec = tween(200)) },
    ) {

        composable(AppBottomBarScreens.HOME.route) {
            HomeScreen()
        }

        composable(AppBottomBarScreens.CALENDAR.route) {
            CalendarScreen()
        }

        composable(AppBottomBarScreens.ANALYSIS.route) {
            AnalysisScreen()
        }

        composable(AppBottomBarScreens.BUDGETS.route) {
            SettingsScreen()
        }

        composable(AppNavigationDrawerScreen.ACCOUNT.route) {
            AccountScreen()
        }

        composable(AppNavigationDrawerScreen.DATA_BACKUP.route) {
            BackupScreen()
        }

        composable(AppNavigationDrawerScreen.SETTINGS.route) {
            SettingsScreen()
        }


    }
}