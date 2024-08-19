package com.example.expensemanager.ui.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensemanager.data.calendar.WeekDay
import com.example.expensemanager.ui.theme.AppTypography
import com.example.expensemanager.ui.theme.Blue10

@Composable
fun CalendarScreen() {
    BaseScreen {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            MonthSelector()
            WeekDays()
        }
    }
}

@Composable
fun MonthSelector() {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 16.dp
            ),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ArrowButton(Icons.Filled.KeyboardArrowLeft)
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            ),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Blue10)
                .height(32.dp)
        ) {
            Text(
                text = "AUGUST",
                style = AppTypography.titleSmall,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.width((LocalConfiguration.current.screenWidthDp/2).dp),
                textAlign = TextAlign.Center
            )
        }
        ArrowButton(Icons.Filled.KeyboardArrowRight)
    }
}

@Composable
private fun ArrowButton(imageVector: ImageVector) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        modifier = Modifier.height(32.dp),
        contentPadding = PaddingValues(0.dp),
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = "Back Arrow",
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
private fun WeekDays() {
    val localDensity = LocalDensity.current
    var widthDp by remember {
        mutableStateOf(0.dp)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .onGloballyPositioned { coordinates ->
                widthDp = with(localDensity) { coordinates.size.width.toDp() }
            },
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val weekDayList = WeekDay.entries
        val itemWidth = (widthDp / 7)
        for (day in weekDayList) {
            Text(
                text = day.title,
                color = day.color,
                style = AppTypography.bodySmall,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(itemWidth)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewCalendarScreen() {
    CalendarScreen()
}