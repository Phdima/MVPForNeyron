package com.example.testforneyron.data.repository

import android.content.Context
import com.example.testforneyron.data.dto.PurchaseData
import com.example.testforneyron.data.dto.PurchaseResponse
import com.example.testforneyron.domain.repository.PurchaseRepo
import com.google.gson.Gson

class PurchaseRepoImpl(
    private val context: Context,
) : PurchaseRepo {

     override suspend fun loadPurchases(): List<PurchaseData> {
        return try {

            val jsonString = context.assets.open("Purchases.json")
                .bufferedReader()
                .use { it.readText() }

            val gson = Gson()
            val response = gson.fromJson(jsonString, PurchaseResponse::class.java)
            response.data

        } catch (e: Exception) {
            emptyList()
        }
    }
}