package com.example.expensemanager.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.expensemanager.ui.composables.screens.AnalysisScreen
import com.example.expensemanager.ui.composables.screens.HomeScreen
import com.example.expensemanager.ui.composables.screens.SettingsScreen
import com.example.expensemanager.ui.composables.screens.transactions.TransactionsScreen
import com.example.expensemanager.utils.RouteConstants
import kotlinx.coroutines.CoroutineScope

@Composable
fun AppNavHost(
    parentNavController: NavHostController,
    navController: NavHostController,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = RouteConstants.TRANSACTIONS,
        enterTransition = { fadeIn(animationSpec = tween(200)) },
        exitTransition = { fadeOut(animationSpec = tween(200)) },
    ) {

        composable(RouteConstants.HOME) {
            HomeScreen()
        }

        composable(RouteConstants.TRANSACTIONS) {
            TransactionsScreen(
                navController = parentNavController,
                drawerState = drawerState,
                coroutineScope = coroutineScope
            )
        }

        composable(RouteConstants.ANALYSIS) {
            AnalysisScreen()
        }

        composable(RouteConstants.BUDGETS) {
            SettingsScreen()
        }

    }
}