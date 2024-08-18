package com.example.expensemanager.ui.composables.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.expensemanager.ui.theme.WhiteSmoke
import java.time.temporal.ChronoUnit

@Composable
fun CalendarScreen() {
    Surface(color = WhiteSmoke) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Calendar Screen",
            )
        }
    }
}

@Preview
@Composable
private fun PreviewCalendarScreen() {
    CalendarScreen()
}