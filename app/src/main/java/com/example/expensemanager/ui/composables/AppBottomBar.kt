package com.example.expensemanager.ui.composables

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.expensemanager.ui.navigation.AppBottomBarScreen


@Composable
fun AppBottomBar(
    destinations: List<AppBottomBarScreen>,
    navController: NavHostController,
    onNavigationSelected: (AppBottomBarScreen) -> Unit,
) {
    NavigationBar {
        destinations.forEach { destination ->
            val isSelected = navController.currentBackStackEntryAsState().value?.destination.isDestinationSelected(destination)
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    onNavigationSelected(destination)
                },
                label = {
                    Text(text = stringResource(id = destination.title))
                },
                icon = {
                    Icon(
                        imageVector = if (isSelected) destination.selectedIcon else destination.unselectedIcon,
                        contentDescription = "${destination.title} icon",
                    )
                }
            )
        }

    }
}

private fun NavDestination?.isDestinationSelected(destination: AppBottomBarScreen): Boolean {
    return this?.hierarchy?.any { it.route == destination.route } ?: false

}