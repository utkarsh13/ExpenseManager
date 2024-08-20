package com.example.expensemanager.data.calendar

import androidx.compose.ui.graphics.Color

enum class WeekDay(
    val title: String,
    val color: Color = Color.Unspecified
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
        color = Color.Red
    )
}
