package com.example.expensemanager.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.expensemanager.ui.composables.AppBottomBar
import com.example.expensemanager.ui.composables.AppTopBar
import com.example.expensemanager.ui.navigation.AppBottomBarScreen
import com.example.expensemanager.ui.navigation.ExpenseManagerNavHost

@Composable
fun ExpenseManagerApp(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { AppTopBar() },
        bottomBar = {
            AppBottomBar(
                destinations = AppBottomBarScreen.entries,
                navController = navController,
                onNavigationSelected = { destination ->
                    val topLevelNavOptions = navOptions {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                    when (destination) {
                        AppBottomBarScreen.HOME -> navController.navigate(
                            AppBottomBarScreen.HOME.route,
                            topLevelNavOptions
                        )

                        AppBottomBarScreen.CALENDAR -> navController.navigate(
                            AppBottomBarScreen.CALENDAR.route,
                            topLevelNavOptions
                        )

                        AppBottomBarScreen.SETTINGS -> navController.navigate(
                            AppBottomBarScreen.SETTINGS.route,
                            topLevelNavOptions
                        )
                    }
                }
            )
        },
        floatingActionButton = {},
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        ExpenseManagerNavHost(
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}



@Preview
@Composable
fun PreviewExpenseManagerApp() {
    ExpenseManagerApp(navController = rememberNavController())
}