package com.example.expensemanager.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.RequestPage
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.RequestPage
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.expensemanager.R
import com.example.expensemanager.utils.RouteConstants

enum class AppBottomBarScreens(
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
    ANALYSIS(
        selectedIcon = Icons.Filled.Analytics,
        unselectedIcon = Icons.Outlined.Analytics,
        title = R.string.analysis,
        route = RouteConstants.ANALYSIS,
    ),
    BUDGETS(
        selectedIcon = Icons.Filled.RequestPage,
        unselectedIcon = Icons.Outlined.RequestPage,
        title = R.string.budgets,
        route = RouteConstants.BUDGETS,
    ),
}
