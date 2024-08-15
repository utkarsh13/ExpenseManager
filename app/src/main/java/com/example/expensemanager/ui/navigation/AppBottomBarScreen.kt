package com.example.expensemanager.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.expensemanager.R
import com.example.expensemanager.utils.RouteConstants

enum class AppBottomBarScreen(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val title: Int,
    val route: String,
) {
    HOME(
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        title = R.string.home,
        route = RouteConstants.HOME,
    ),
    CALENDAR(
        selectedIcon = Icons.Filled.DateRange,
        unselectedIcon = Icons.Outlined.DateRange,
        title = R.string.calendar,
        route = RouteConstants.CALENDAR,
    ),
    SETTINGS(
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        title = R.string.settings,
        route = RouteConstants.SETTINGS,
    ),
}
