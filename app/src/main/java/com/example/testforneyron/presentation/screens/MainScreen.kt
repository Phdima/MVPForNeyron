package com.example.testforneyron.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.testforneyron.presentation.components.BackTrackButton
import com.example.testforneyron.presentation.components.UniversalButtonForMainScreen
import com.example.testforneyron.presentation.viewModels.UserFormViewModel

@Composable
fun MainScreen(viewModel: UserFormViewModel, navHostController: NavHostController) {

    val user by viewModel.user.collectAsState()

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
                Column {

                    Text(text =if (user?.firstName == null){
                        "Имя"
                    }else{
                        user?.firstName.toString()
                    },
                        modifier = Modifier.padding(bottom = 10.dp),
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Row(modifier = Modifier.padding(bottom = 10.dp)) {

                        Text(text =if (user?.lastName == null){
                            "Фамилия"
                        }else{
                            user?.lastName.toString()
                        }, fontWeight = FontWeight.Bold, color = Color.White)

                        Icon(
                            Icons.Default.Create,
                            contentDescription = "редактирование",
                            tint = Color.Gray,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }

                    Text(
                        "+79535668122",
                        modifier = Modifier.padding(bottom = 10.dp),
                        color = Color.Gray
                    )
                }
            }

            item {
                Column(Modifier.padding(bottom = 5.dp)) {

                    Text("Мои покупки", color = Color.Gray)

                    UniversalButtonForMainScreen(
                        isHasImage = true,
                        onClick = {},
                    )
                }
            }

            item {
                Column {
                    Text("Настройки", color = Color.Gray)

                    UniversalButtonForMainScreen(
                        text = "E-mail",
                        additionalText = "kursantik341@gmail.com",
                        actionText = "Необходимо подтвердить",
                        isHasAction = true,
                        onClick = {},
                    )

                    UniversalButtonForMainScreen(
                        text = "Вход по биометрии",
                        isArrow = false,
                        onClick = {},
                    )

                    UniversalButtonForMainScreen(
                        text = "Запрос пермишенов",
                        onClick = {},
                    )

                    UniversalButtonForMainScreen(
                        text = "Регистрация для клиентов банка",
                        onClick = {navHostController.navigate("registration")},
                    )

                    UniversalButtonForMainScreen(
                        text = "Язык",
                        additionalText = "русский",
                        onClick = {},
                    )

                }
            }
        }
    }
}