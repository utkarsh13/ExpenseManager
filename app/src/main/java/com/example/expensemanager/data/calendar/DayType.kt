package com.example.expensemanager.data.calendar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.expensemanager.ui.theme.BlueAlice
import com.example.expensemanager.ui.theme.BlueNavy
import com.example.expensemanager.ui.theme.WhiteSmoke
import com.example.expensemanager.ui.theme.blackAlpha05

enum class DayType(
    val bgColor: Color,
    val borderColor: Color,
    val shadow: Dp,
) {
    TODAY(
        bgColor = BlueAlice,
        borderColor = BlueNavy.copy(0.2f),
        shadow = 8.dp
    ),
    CURRENT_MONTH(
        bgColor = Color.White,
        borderColor = blackAlpha05,
        shadow = 0.dp
    ),
    OTHER_MONTH(
        bgColor = WhiteSmoke,
        borderColor = blackAlpha05,
        shadow = 0.dp
    ),
}