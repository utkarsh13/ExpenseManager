package com.example.expensemanager.data.calendar

import java.time.DayOfWeek
import java.time.LocalDate

data class DayState(
    val date: LocalDate,
    val dayType: DayType,
)

fun DayState.isSunday(): Boolean {
    return this.date.dayOfWeek == DayOfWeek.SUNDAY
}