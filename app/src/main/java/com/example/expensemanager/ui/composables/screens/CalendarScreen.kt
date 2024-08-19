package com.example.expensemanager.ui.composables.screens

import android.text.format.DateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.draw.shadow
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
import com.example.expensemanager.ui.theme.Blue
import com.example.expensemanager.ui.theme.Blue10
import com.example.expensemanager.ui.theme.LightGrey
import com.example.expensemanager.ui.theme.LightGrey35
import com.example.expensemanager.ui.theme.WhiteSmoke
import java.util.Date
import kotlin.random.Random

@Composable
fun CalendarScreen() {
    BaseScreen {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            MonthSelector()
            WeekDays()
            CalendarUI()
        }
    }
}

@Composable
fun MonthSelector() {
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
            val monthString = DateFormat.format("MMMM yyyy", Date()).toString().uppercase()
            Text(
                text = monthString,
                style = AppTypography.titleSmall,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.width((LocalConfiguration.current.screenWidthDp / 2).dp),
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
            .height(28.dp)
            .padding(horizontal = 8.dp)
            .padding(bottom = 12.dp)
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

@Composable
fun CalendarUI() {
    val localDensity = LocalDensity.current
    var widthDp by remember { mutableStateOf(0.dp) }
    var heightDp by remember { mutableStateOf(0.dp) }
    val random = Random.nextInt(30)
    var idx = 0
    Column(
        Modifier
            .padding(horizontal = 8.dp)
            .padding(bottom = 16.dp)
            .fillMaxSize()
            .onGloballyPositioned { coordinates ->
                widthDp = with(localDensity) { coordinates.size.width.toDp() }
                heightDp = with(localDensity) { coordinates.size.height.toDp() }
            }
    ) {
        for (colIdx in 1..6) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (rowIdx in 1..7) {
                    val color = if (random == idx) Blue10 else Color.White
                    val borderColor = if (random == idx) Blue.copy(0.15f) else LightGrey35
                    Box(
                        modifier = Modifier
                            .size(widthDp / 7, heightDp/6)
                            .padding(4.dp)
                            .background(color = color, shape = RoundedCornerShape(8.dp))
                            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(8.dp))
                    ) {

                    }
                    idx++
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