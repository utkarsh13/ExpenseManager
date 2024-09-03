package com.example.expensemanager.data.calendar

import androidx.compose.ui.graphics.Color
import com.example.expensemanager.ui.theme.black100
import com.example.expensemanager.ui.theme.errorRed1

enum class WeekDay(
    val title: String,
    val color: Color = black100
) {
    MONDAY(
        title = "Mon",
    ),
    TUESDAY(
        title = "Tue",
    ),
    WEDNESDAY(
        title = "Wed",
    ),
    THURSDAY(
        title = "Thu",
    ),
    FRIDAY(
        title = "Fri",
    ),
    SATURDAY(
        title = "Sat",
    ),
    SUNDAY(
        title = "Sun",
        color = errorRed1
    )
}
