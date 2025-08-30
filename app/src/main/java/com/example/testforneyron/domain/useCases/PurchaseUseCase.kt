package com.example.testforneyron.domain.useCases

import com.example.testforneyron.domain.repository.PurchaseRepo
import java.text.SimpleDateFormat
import java.util.Locale

class PurchaseUseCase(
    private val purchaseRepo: PurchaseRepo,
) {



    suspend operator fun invoke(): List<GroupedPurchase> {

        val rawPurchases = purchaseRepo.loadPurchases()

        val groupedByDate = rawPurchases.groupBy { purchase ->
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            val date = inputFormat.parse(purchase.date)
            val outputFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            outputFormat.format(date)
        }

        return groupedByDate.map { (date, purchases) ->
            GroupedPurchase(
                date = date,
                names = purchases.flatMap { it.name }
            )
        }.sortedByDescending { it.date }
    }
}

data class GroupedPurchase(
    val date: String,
    val names: List<String>,
)