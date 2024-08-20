package com.example.expensemanager.ui.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expensemanager.ui.theme.WhiteSmoke

@Composable
fun BaseScreen(modifier: Modifier, content: @Composable () -> Unit) {
    Surface(
        color = WhiteSmoke,
        modifier = modifier
            .background(WhiteSmoke)
            .fillMaxSize(),
    ) {
        content()
    }
}