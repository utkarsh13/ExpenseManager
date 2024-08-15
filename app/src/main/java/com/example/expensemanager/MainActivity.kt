package com.example.expensemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.expensemanager.ui.ExpenseManagerApp
import com.example.expensemanager.ui.theme.ExpenseManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            ExpenseManagerTheme(darkTheme = false) {
                ExpenseManagerApp(navController)
            }
        }
    }
}

