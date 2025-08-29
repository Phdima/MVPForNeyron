package com.example.testforneyron.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testforneyron.presentation.components.BackTrackButton
import com.example.testforneyron.presentation.components.InputField
import com.example.testforneyron.presentation.viewModels.UserFormViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun RegistrationScreen(viewModel: UserFormViewModel, navHostController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        LazyColumn(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            item { BackTrackButton(modifier = Modifier.padding(bottom = 40.dp), navHostController) }

            item {

                Column(Modifier.padding(bottom = 10.dp)) {
                    Text(
                        "Регистрация для ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.White,
                    )
                    Text(
                        "клиентов банка",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.White,
                    )
                }
            }

            item {

                InputField(viewModel)

            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .align(Alignment.BottomCenter)
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Нажимая кнопку продолжить,", color = Color.White, fontSize = 12.sp)
            Row() {
                Text("Вы соглашаетесь ", color = Color.White, fontSize = 12.sp)
                Text(
                    "с условиями участия",
                    color = Color.White,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 12.sp,
                    modifier = Modifier.clickable {  }
                )
            }
            Spacer(Modifier.height(5.dp))
            Button(
                onClick = { viewModel.saveUser() },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    containerColor = Color.Red,
                    disabledContainerColor = Color.Red.copy(alpha = 0.5f)
                ),
                enabled = viewModel.isFormValid,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Продолжить")
            }
        }
    }
}