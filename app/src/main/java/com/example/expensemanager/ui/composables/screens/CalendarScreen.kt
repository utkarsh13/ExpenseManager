package com.example.expensemanager.ui.composables.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensemanager.data.calendar.WeekDay
import com.example.expensemanager.ui.theme.AppTypography

@Composable
fun CalendarScreen() {
    BaseScreen {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            val localDensity = LocalDensity.current
            var widthDp by remember {
                mutableStateOf(0.dp)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .padding(horizontal = 8.dp)
                    .onGloballyPositioned { coordinates ->
                        widthDp = with(localDensity) { coordinates.size.width.toDp() }
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val weekDayList = WeekDay.entries
                val itemWidth = (widthDp/7)
                for (day in weekDayList) {
                    Text(
                        text = day.title,
                        color = day.color,
                        style = AppTypography.bodySmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(itemWidth)
                    )
                }
            }

        }
    }
}

@Preview
@Composable
private fun PreviewCalendarScreen() {
    CalendarScreen()
}