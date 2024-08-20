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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.expensemanager.ui.navigation.AppBottomBarScreens
import com.example.expensemanager.ui.theme.AppTypography
import com.example.expensemanager.ui.theme.BlueAlice
import com.example.expensemanager.ui.theme.BlueNavy
import com.example.expensemanager.ui.theme.black45


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
                    indicatorColor = BlueAlice
                ),
                selected = isSelected,
                onClick = {
                    onNavigationSelected(destination)
                },
                label = {
                    Text(
                        text = stringResource(id = destination.title),
                        color = if (isSelected) BlueNavy else black45,
                        style = AppTypography.labelSmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                icon = {
                    Icon(
                        imageVector = if (isSelected) destination.selectedIcon else destination.selectedIcon,
                        contentDescription = "${destination.title} icon",
                        tint = if (isSelected) BlueNavy else black45,
                    )
                }
            )
        }

    }
}

private fun NavDestination?.isDestinationSelected(destination: AppBottomBarScreens): Boolean {
    return this?.hierarchy?.any { it.route == destination.route } ?: false

}

@Preview
@Composable
fun PreviewAppBottomBar() {
    AppBottomBar(AppBottomBarScreens.entries, rememberNavController()) {

    }
}