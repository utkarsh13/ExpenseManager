package com.example.expensemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.expensemanager.ui.ExpenseManagerApp
import com.example.expensemanager.ui.theme.ExpenseManagerTheme
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val coroutineScope: CoroutineScope = rememberCoroutineScope()

            ExpenseManagerTheme(darkTheme = false) {
                ExpenseManagerApp(
                    navController = navController,
                    drawerState = drawerState,
                    coroutineScope = coroutineScope
                )
            }
        }
    }
}

