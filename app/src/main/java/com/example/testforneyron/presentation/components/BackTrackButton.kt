package com.example.testforneyron.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BackTrackButton(modifier: Modifier,navHostController: NavHostController) {
    Box(
        modifier = modifier
            .clickable { navHostController.navigateUp()}
            .background(color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(50.dp))
            .border(
                border = BorderStroke(1.dp, color = Color.Black),
                shape = RoundedCornerShape(50.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(Modifier.padding(10.dp)) {
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "кнопка назад",
                tint = Color.White
            )
            Text("Назад", color = Color.White)
        }
    }
}