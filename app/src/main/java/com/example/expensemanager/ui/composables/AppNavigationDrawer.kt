package com.example.expensemanager.ui.composables

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expensemanager.ui.navigation.AppNavigationDrawerScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppNavigationDrawer(
    navController: NavHostController,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerContent = {
            AppDrawerContent(destinations = AppNavigationDrawerScreen.entries) { destination ->
                coroutineScope.launch {
                    drawerState.close()
                }
                navController.navigate(destination.route)
            }
        },
        modifier = Modifier,
        drawerState = drawerState,
    ) {
        content()
    }
}


@Preview
@Composable
fun PreviewAppNavigationDrawer() {
    AppNavigationDrawer(
        rememberNavController(),
        rememberDrawerState(initialValue = DrawerValue.Closed),
        rememberCoroutineScope()
    ) {

    }
}
