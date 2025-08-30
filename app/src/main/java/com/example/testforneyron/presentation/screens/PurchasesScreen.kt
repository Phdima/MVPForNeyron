package com.example.testforneyron.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.testforneyron.presentation.components.BackTrackButton
import com.example.testforneyron.presentation.viewModels.PurchaseViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PurchasesScreen(
    navHostController: NavHostController,
    viewModel: PurchaseViewModel = koinViewModel(),
) {
    val purchases = viewModel.purchases.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {


        LazyColumn(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(horizontal = 10.dp, vertical = 30.dp)
        ) {
            item { BackTrackButton(modifier = Modifier.padding(bottom = 40.dp), navHostController) }

            items(purchases.value) { groupedPurchase ->
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.secondary,
                            shape = RoundedCornerShape(15.dp)
                        )
                ) {
                    Column {
                        Text(
                            text = groupedPurchase.date,
                            modifier = Modifier
                                .padding(16.dp),
                            color = Color.White
                        )

                        Column {
                            groupedPurchase.names.forEach { name ->
                                Text(
                                    text = name,
                                    modifier = Modifier.padding(
                                        horizontal = 16.dp,
                                        vertical = 8.dp
                                    ),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }

    }
}