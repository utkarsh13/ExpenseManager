package com.example.expensemanager.features.transactions

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.TrendingDown
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.expensemanager.data.calendar.DayState
import com.example.expensemanager.data.calendar.DayType
import com.example.expensemanager.data.calendar.WeekDay
import com.example.expensemanager.data.calendar.isSunday
import com.example.expensemanager.data.calendar.toMonthDays
import com.example.expensemanager.ui.theme.AppTypography
import com.example.expensemanager.ui.theme.BlueNavy
import com.example.expensemanager.ui.theme.GreenMint
import com.example.expensemanager.ui.theme.GreenShamrock
import com.example.expensemanager.ui.theme.RedCoral
import com.example.expensemanager.ui.theme.RedPeep
import com.example.expensemanager.ui.theme.black100
import com.example.expensemanager.ui.theme.black75
import com.example.expensemanager.ui.theme.blackAlpha60
import com.example.expensemanager.ui.theme.blackAlpha75
import com.example.expensemanager.ui.theme.errorRed1
import java.time.format.DateTimeFormatter
import kotlin.coroutines.coroutineContext

@Composable
fun CalendarView(viewModel: TransactionsViewModel) {
    Column(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxSize(),
    ) {
        MonthSelector(viewModel)
        IncomeExpenseSummary()
        WeekDays()
        CalendarUI(viewModel)
    }
}

@Composable
fun MonthSelector(viewModel: TransactionsViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ArrowButton(Icons.Filled.KeyboardArrowLeft) {
            viewModel.clickBackwardMonth()
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            ),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .shadow(
                    elevation = 12.dp,
                    spotColor = BlueNavy,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .background(BlueNavy)
                .height(32.dp)

        ) {
            val monthState = viewModel.monthUiState.collectAsState()
            val localDate = monthState.value.month.atDay(1)
            val formatter = DateTimeFormatter.ofPattern("MMMM yyyy")
            val monthString = localDate.format(formatter).uppercase()
            Text(
                text = monthString,
                style = AppTypography.titleSmall,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.width((LocalConfiguration.current.screenWidthDp / 2).dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
        ArrowButton(Icons.Filled.KeyboardArrowRight) {
            viewModel.clickForwardMonth()
        }
    }
}

@Composable
private fun ArrowButton(imageVector: ImageVector, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
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
fun IncomeExpenseSummary() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 18.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SummaryCard(
            imageVector = Icons.Filled.TrendingUp,
            bgColor = GreenMint,
            iconColor = GreenShamrock,
            amount = "₹0"
        )
        SummaryCard(
            imageVector = Icons.Filled.TrendingDown,
            bgColor = RedPeep,
            iconColor = RedCoral,
            amount = "₹0"
        )
    }
}

@Composable
private fun SummaryCard(
    imageVector: ImageVector,
    bgColor: Color,
    iconColor: Color,
    amount: String
) {
    val width = LocalConfiguration.current.screenWidthDp * 0.36
    Row(
        modifier = Modifier
            .shadow(
                elevation = 8.dp,
                spotColor = iconColor.copy(0.8f),
                shape = RoundedCornerShape(8.dp)
            )
            .height(40.dp)
            .width(width.dp)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(
                    color = bgColor,
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = "Income",
                tint = iconColor,
                modifier = Modifier.padding(3.dp)
            )
        }

        Text(text = amount, color = iconColor, style = AppTypography.labelMedium)
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
fun CalendarUI(viewModel: TransactionsViewModel) {
    val localDensity = LocalDensity.current
    var widthDp by remember { mutableStateOf(0.dp) }
    var heightDp by remember { mutableStateOf(0.dp) }
    var idx = 0
    Column(
        Modifier
            .padding(horizontal = 8.dp)
            .padding(bottom = 10.dp)
            .fillMaxSize()
            .onGloballyPositioned { coordinates ->
                widthDp = with(localDensity) { coordinates.size.width.toDp() }
                heightDp = with(localDensity) { coordinates.size.height.toDp() }
            }
    ) {
        val monthDays = viewModel.monthUiState.collectAsState().value.month.toMonthDays()
        for (colIdx in 1..6) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (rowIdx in 1..7) {
                    val dayState = monthDays[idx]
                    val containerAlpha = getContainerAlpha(monthDays, dayState, idx)
                    val cornerRadius = 10.dp
                    Box(
                        modifier = Modifier
                            .size(widthDp / 7, heightDp / 6)
                            .padding(4.dp)
                            .shadow(
                                elevation = dayState.dayType.shadow,
                                spotColor = dayState.dayType.borderColor,
                                shape = RoundedCornerShape(cornerRadius)
                            )
                            .background(
                                color = dayState.dayType.bgColor,
                                shape = RoundedCornerShape(cornerRadius)
                            )
                            .alpha(containerAlpha)
                            .border(
                                width = 1.dp,
                                color = dayState.dayType.borderColor,
                                shape = RoundedCornerShape(cornerRadius)
                            )
                    ) {
                        Column(
                            modifier = Modifier.padding(3.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            val color = when {
                                dayState.dayType == DayType.TODAY -> BlueNavy
                                dayState.isSunday() -> errorRed1
                                else -> blackAlpha75
                            }
                            Text(
                                text = dayState.date.dayOfMonth.toString(),
                                style = AppTypography.titleSmall,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                color = color
                            )
                        }

                    }
                    idx++
                }
            }
        }
    }
}

private fun getContainerAlpha(monthDays: List<DayState>, dayState: DayState, idx: Int): Float {
    return when (dayState.dayType) {
        DayType.TODAY, DayType.CURRENT_MONTH -> 1f

        DayType.OTHER_MONTH -> {
            val firstDay = monthDays.indexOfFirst { it.dayType == DayType.CURRENT_MONTH }
            val lastDay = monthDays.indexOfLast { it.dayType == DayType.CURRENT_MONTH }
            if (idx < firstDay) {
                return ((idx + 1).toFloat() / (firstDay + 1)) / 2 + 0.2f
            } else {
                return ((42 - idx).toFloat() / (42 - lastDay)) / 2 + 0.2f
            }
        }
    }
}

@Preview
@Composable
private fun PreviewCalendarView() {
    CalendarView(hiltViewModel())
}