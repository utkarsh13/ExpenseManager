package com.example.expensemanager.features.transactions

import androidx.lifecycle.ViewModel
import com.example.expensemanager.data.calendar.MonthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.YearMonth
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor() : ViewModel() {

    private val _monthUiState = MutableStateFlow(MonthState(YearMonth.now()))

    val monthUiState: StateFlow<MonthState> = _monthUiState

    fun clickForwardMonth() {
        val currentYearMonth = _monthUiState.value
        _monthUiState.value = MonthState(month = currentYearMonth.month.plusMonths(1))
    }

    fun clickBackwardMonth() {
        val currentYearMonth = _monthUiState.value
        _monthUiState.value = MonthState(month = currentYearMonth.month.minusMonths(1))
    }

}