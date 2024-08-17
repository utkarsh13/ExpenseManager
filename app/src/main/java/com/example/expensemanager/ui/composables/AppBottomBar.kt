package com.example.expensemanager.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.expensemanager.ui.navigation.AppBottomBarScreens


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
                shape = RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp)
                shadowElevation = 30f
                ambientShadowColor = Color.Black
            }
    ) {
        destinations.forEach { destination ->
            val isSelected =
                navController.currentBackStackEntryAsState().value?.destination.isDestinationSelected(destination)
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

private fun NavDestination?.isDestinationSelected(destination: AppBottomBarScreens): Boolean {
    return this?.hierarchy?.any { it.route == destination.route } ?: false

}