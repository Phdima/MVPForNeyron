package com.example.testforneyron.domain.repository

import com.example.testforneyron.data.dto.PurchaseData

interface PurchaseRepo {
     suspend fun loadPurchases(): List<PurchaseData>
}