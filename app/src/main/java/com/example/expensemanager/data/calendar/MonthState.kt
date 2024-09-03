package com.example.expensemanager.data.calendar

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

data class MonthState(
    val month: YearMonth,
)

fun YearMonth.toMonthDays(): List<DayState> {
    val daysList = mutableListOf<DayState>()

    val daysLength = lengthOfMonth()
    val firstDayOfMonth = atDay(1).dayOfWeek.value
    val startOffset = firstDayOfMonth - 1
    val endOffset = 42 - (startOffset + daysLength)

    val previousMonthLastDay = this.minusMonths(1).atEndOfMonth()
    val nextMonthFirstDay = this.plusMonths(1).atDay(1)

    // Add days from the previous month
    (0 until startOffset).mapTo(daysList) { day ->
        DayState(
            date = previousMonthLastDay.minusDays((startOffset - day - 1).toLong()),
            dayType = DayType.OTHER_MONTH
        )
    }

    // Add days from the current month
    (1..daysLength).mapTo(daysList) { day ->
        val localDate = LocalDate.of(this.year, this.month, day)
        DayState(
            date = localDate,
            dayType = if (localDate.isEqual(LocalDate.now())) {
                DayType.TODAY
            } else {
                DayType.CURRENT_MONTH
            }
        )
    }

    // Add days from the next month
    (0 until endOffset).mapTo(daysList) { day ->
        DayState(
            date = nextMonthFirstDay.plusDays(day.toLong()),
            dayType = DayType.OTHER_MONTH
        )
    }

    return daysList
}
