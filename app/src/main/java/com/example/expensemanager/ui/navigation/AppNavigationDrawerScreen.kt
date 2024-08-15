package com.example.expensemanager.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.outlined.Save
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.expensemanager.R
import com.example.expensemanager.utils.RouteConstants

enum class AppNavigationDrawerScreen(
    val title: Int,
    val route: String,
    val icon: ImageVector,
) {
    ACCOUNT(
        title = R.string.account,
        route = RouteConstants.ACCOUNT,
        icon = Icons.Filled.AccountBox,
    ),

    DATA_BACKUP(
        title = R.string.databackup,
        route = RouteConstants.DATA_BACKUP,
        icon = Icons.Outlined.Save
    ),
}


