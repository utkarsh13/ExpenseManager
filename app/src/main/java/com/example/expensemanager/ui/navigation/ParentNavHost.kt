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
import com.example.expensemanager.ui.AppBase
import com.example.expensemanager.ui.composables.screens.AccountScreen
import com.example.expensemanager.ui.composables.screens.BackupScreen
import com.example.expensemanager.ui.composables.screens.SearchScreen
import com.example.expensemanager.ui.composables.screens.SettingsScreen
import com.example.expensemanager.utils.RouteConstants
import kotlinx.coroutines.CoroutineScope

@Composable
fun ParentNavHost(
    parentNavController: NavHostController,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = parentNavController,
        modifier = modifier,
        startDestination = RouteConstants.BASE,
        enterTransition = { fadeIn(animationSpec = tween(200)) },
        exitTransition = { fadeOut(animationSpec = tween(200)) },
    ) {

        composable(RouteConstants.BASE) {
            AppBase(parentNavController, drawerState, coroutineScope)
        }

        composable(RouteConstants.ACCOUNT) {
            AccountScreen()
        }

        composable(RouteConstants.DATA_BACKUP) {
            BackupScreen()
        }

        composable(RouteConstants.SETTINGS) {
            SettingsScreen()
        }

        composable(RouteConstants.SEARCH) {
            SearchScreen()
        }

    }
}