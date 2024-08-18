package com.example.expensemanager.ui.composables.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.expensemanager.ui.theme.Black
import com.example.expensemanager.ui.theme.ExpenseManagerTheme
import com.example.expensemanager.ui.theme.WhiteSmoke

@Composable
fun HomeScreen() {
    Surface(color = WhiteSmoke) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .shadow(
                        elevation = 2.dp,
                        spotColor = WhiteSmoke,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                    .height(80.dp)
                    .width(200.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Home Screen",
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    ExpenseManagerTheme(darkTheme = false) {
        HomeScreen()
    }
}