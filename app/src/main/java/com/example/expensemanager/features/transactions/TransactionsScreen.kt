package com.example.expensemanager.features.transactions

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expensemanager.ui.composables.screens.BaseScreen
import com.example.expensemanager.ui.composables.topbars.TransactionsTopBar
import kotlinx.coroutines.CoroutineScope

@Composable
fun TransactionsScreen(
    viewModel: TransactionsViewModel = hiltViewModel(),
    navController: NavHostController,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
) {
    Scaffold(
        topBar = {
            TransactionsTopBar(
                navController = navController,
                drawerState = drawerState,
                coroutineScope = coroutineScope
            )
        }
    ) { paddingValues ->
        BaseScreen(modifier = Modifier.padding(paddingValues)) {
            CalendarView(viewModel)
        }
    }
}


@Preview
@Composable
private fun PreviewTransactionsScreen() {
    TransactionsScreen(
        hiltViewModel(),
        rememberNavController(),
        rememberDrawerState(initialValue = DrawerValue.Closed),
        rememberCoroutineScope()
    )
}