package com.example.testforneyron.data.dto

data class PurchaseData(
    val date: String,
    val name: List<String>
)

data class PurchaseResponse(
    val data: List<PurchaseData>
)