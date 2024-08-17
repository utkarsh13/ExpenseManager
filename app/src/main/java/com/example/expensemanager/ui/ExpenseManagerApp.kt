package com.example.expensemanager.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.expensemanager.ui.composables.AppBottomBar
import com.example.expensemanager.ui.composables.AppNavigationDrawer
import com.example.expensemanager.ui.composables.AppTopBar
import com.example.expensemanager.ui.navigation.AppBottomBarScreens
import com.example.expensemanager.ui.navigation.ExpenseManagerNavHost
import kotlinx.coroutines.CoroutineScope

@Composable
fun ExpenseManagerApp(
    navController: NavHostController,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
) {

    AppNavigationDrawer(
        navController = navController,
        drawerState = drawerState,
        coroutineScope = coroutineScope
    ) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AppTopBar(
                    drawerState = drawerState,
                    coroutineScope = coroutineScope
                )
            },
            bottomBar = {
                AppBottomBar(
                    destinations = AppBottomBarScreens.entries,
                    navController = navController,
                    onNavigationSelected = { destination ->
                        val topLevelNavOptions = navOptions {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        navController.navigate(
                            destination.route,
                            topLevelNavOptions
                        )
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
}

@Preview
@Composable
fun PreviewExpenseManagerApp() {
    ExpenseManagerApp(navController = rememberNavController(), rememberDrawerState(initialValue = DrawerValue.Closed), rememberCoroutineScope())
}