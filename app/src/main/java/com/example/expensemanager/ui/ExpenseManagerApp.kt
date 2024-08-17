package com.example.expensemanager.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.expensemanager.ui.composables.AppBottomBar
import com.example.expensemanager.ui.composables.AppNavigationDrawer
import com.example.expensemanager.ui.composables.AppTopBar
import com.example.expensemanager.ui.navigation.AppBottomBarScreens
import com.example.expensemanager.ui.navigation.ParentNavHost
import com.example.expensemanager.ui.navigation.AppNavHost
import kotlinx.coroutines.CoroutineScope

@Composable
fun ExpenseManagerApp(
    parentNavController: NavHostController,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
) {
    ParentNavHost(
        parentNavController = parentNavController,
        drawerState = drawerState,
        coroutineScope = coroutineScope
    )
}

@Composable
fun AppBase(
    parentNavController: NavHostController,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
) {
    val appNavController = rememberNavController()
    AppNavigationDrawer(
        navController = parentNavController,
        drawerState = drawerState,
        coroutineScope = coroutineScope
    ) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AppTopBar(
                    navController = parentNavController,
                    drawerState = drawerState,
                    coroutineScope = coroutineScope
                )
            },
            bottomBar = {
                AppBottomBar(
                    destinations = AppBottomBarScreens.entries,
                    navController = appNavController,
                    onNavigationSelected = { destination ->
                        val topLevelNavOptions = navOptions {
                            popUpTo(appNavController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        appNavController.navigate(
                            destination.route,
                            topLevelNavOptions
                        )
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(50.dp),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                }
            },
            floatingActionButtonPosition = FabPosition.End
        ) { paddingValues ->

            AppNavHost(
                navController = appNavController,
                modifier = Modifier.padding(paddingValues)
            )

        }
    }
}

@Preview
@Composable
fun PreviewExpenseManagerApp() {
    ExpenseManagerApp(parentNavController = rememberNavController(), rememberDrawerState(initialValue = DrawerValue.Closed), rememberCoroutineScope())
}