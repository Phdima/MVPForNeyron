package com.example.testforneyron.presentation.screens

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.testforneyron.presentation.components.BackTrackButton
import com.example.testforneyron.presentation.components.UniversalButtonForMainScreen
import com.example.testforneyron.presentation.viewModels.UserFormViewModel

@Composable
fun MainScreen(viewModel: UserFormViewModel, navHostController: NavHostController) {

    val context = LocalContext.current

    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            Toast.makeText(context, "Доступ к камере разрешен", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Доступ к камере запрещен \n  перейдите в настройки", Toast.LENGTH_SHORT).show()
        }
    }

    val user by viewModel.user.collectAsState()

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

            item {
                Column {

                    Text(
                        text = if (user?.firstName == null) {
                            "Имя"
                        } else {
                            user?.firstName.toString()
                        },
                        modifier = Modifier.padding(bottom = 10.dp),
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Row(modifier = Modifier.padding(bottom = 10.dp)) {

                        Text(
                            text = if (user?.lastName == null) {
                                "Фамилия"
                            } else {
                                user?.lastName.toString()
                            }, fontWeight = FontWeight.Bold, color = Color.White
                        )

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
                        onClick = { navHostController.navigate("purchases") },
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
                        onClick = {
                            when (PackageManager.PERMISSION_GRANTED) {
                                ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.CAMERA
                                ) -> {
                                    Toast.makeText(
                                        context,
                                        "Камера уже доступна",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                else -> {
                                    cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
                                }
                            }
                        },
                    )

                    UniversalButtonForMainScreen(
                        text = "Регистрация для клиентов банка",
                        onClick = { navHostController.navigate("registration") },
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