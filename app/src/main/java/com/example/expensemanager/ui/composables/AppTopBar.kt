package com.example.expensemanager.ui.composables

import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expensemanager.utils.RouteConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    navController: NavHostController,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
) {
    TopAppBar(
        title = {
            Text(
                text = "Expense Manager",
                fontSize = 19.sp
            )
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
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search",
                )
            }
        }
    )

}


@Preview
@Composable
fun PreviewAppTopBar() {
    AppTopBar(rememberNavController(), rememberDrawerState(initialValue = DrawerValue.Closed), rememberCoroutineScope())
}