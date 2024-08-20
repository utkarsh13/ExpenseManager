package com.example.expensemanager.ui.composables.topbars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expensemanager.ui.theme.AppTypography
import com.example.expensemanager.ui.theme.WhiteSmoke
import com.example.expensemanager.ui.theme.blackAlpha05
import com.example.expensemanager.ui.theme.blackAlpha92
import com.example.expensemanager.utils.RouteConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsTopBar(
    navController: NavHostController,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = WhiteSmoke
        ),
        title = {
            Row(
                modifier = Modifier
                    .background(blackAlpha05, shape = RoundedCornerShape(8.dp))
                    .padding(vertical = 4.dp)
                    .padding(start = 12.dp, end = 8.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Calendar",
                    style = AppTypography.titleMedium,
                )
                Icon(
                    imageVector = Icons.Rounded.ArrowDropDown,
                    contentDescription = "Drop Down",
                    tint = blackAlpha92,
                )
            }
        },
        modifier = Modifier,
        navigationIcon = {
            IconButton(onClick = {
                coroutineScope.launch {
                    drawerState.open()
                }
            }) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = "Drawer Menu",
                )
            }
        },
        actions = {
            IconButton(onClick = {
                navController.navigate(RouteConstants.SEARCH)
            }) {
                Icon(
                    imageVector = Icons.Outlined.FilterAlt,
                    contentDescription = "Filter",
                    tint = blackAlpha92,
                )
            }
            IconButton(onClick = {
                navController.navigate(RouteConstants.SEARCH)
            }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search",
                    tint = blackAlpha92,
                )
            }
        }
    )

}


@Preview
@Composable
fun PreviewAppTopBar() {
    TransactionsTopBar(
        rememberNavController(),
        rememberDrawerState(initialValue = DrawerValue.Closed),
        rememberCoroutineScope()
    )
}