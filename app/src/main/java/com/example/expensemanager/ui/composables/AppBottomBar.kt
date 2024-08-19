package com.example.expensemanager.ui.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.expensemanager.ui.navigation.AppBottomBarScreens
import com.example.expensemanager.ui.theme.Blue10
import com.example.expensemanager.ui.theme.primaryLight


@Composable
fun AppBottomBar(
    destinations: List<AppBottomBarScreens>,
    navController: NavHostController,
    onNavigationSelected: (AppBottomBarScreens) -> Unit,
) {
    NavigationBar(
        modifier = Modifier
            .graphicsLayer {
                clip = true
                shadowElevation = 30f
                ambientShadowColor = Color.Black
            },
        containerColor = Color.White
    ) {
        destinations.forEach { destination ->
            val isSelected =
                navController.currentBackStackEntryAsState().value?.destination.isDestinationSelected(destination)
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Blue10
                ),
                selected = isSelected,
                onClick = {
                    onNavigationSelected(destination)
                },
                label = {
                    Text(
                        text = stringResource(id = destination.title),
                        color = if (isSelected) primaryLight else Color.Unspecified,
                    )
                },
                icon = {
                    Icon(
                        imageVector = if (isSelected) destination.selectedIcon else destination.unselectedIcon,
                        contentDescription = "${destination.title} icon",
                        tint = if (isSelected) primaryLight else Color.Unspecified,
                    )
                }
            )
        }

    }
}

private fun NavDestination?.isDestinationSelected(destination: AppBottomBarScreens): Boolean {
    return this?.hierarchy?.any { it.route == destination.route } ?: false

}