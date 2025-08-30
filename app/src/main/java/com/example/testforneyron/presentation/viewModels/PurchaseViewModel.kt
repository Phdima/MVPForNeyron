package com.example.testforneyron.presentation.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testforneyron.domain.useCases.GroupedPurchase
import com.example.testforneyron.domain.useCases.PurchaseUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PurchaseViewModel(
    private val purchaseUseCase: PurchaseUseCase,
) : ViewModel() {
    private val _purchases = MutableStateFlow<List<GroupedPurchase>>(emptyList())
    val purchases: StateFlow<List<GroupedPurchase>> = _purchases

    init {
        loadPurchases()
    }

   private fun loadPurchases() {
        viewModelScope.launch {
            try {
                _purchases.value = purchaseUseCase()
            } catch (e: Exception) {
            }
        }
    }
}