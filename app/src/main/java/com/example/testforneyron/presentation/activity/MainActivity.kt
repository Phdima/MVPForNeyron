package com.example.testforneyron.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testforneyron.presentation.screens.MainScreen
import com.example.testforneyron.presentation.screens.PurchasesScreen
import com.example.testforneyron.presentation.screens.RegistrationScreen
import com.example.testforneyron.presentation.theme.TestForNeyronTheme
import com.example.testforneyron.presentation.viewModels.UserFormViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TestForNeyronTheme {
              val navController = rememberNavController()
                val viewModel: UserFormViewModel = viewModel()
                NavHost(
                    navController = navController,
                    startDestination = "main"
                )
                {
                    composable("main")  {
                        MainScreen(navHostController = navController, viewModel = viewModel)
                    }
                    composable("registration"){
                        RegistrationScreen(navHostController = navController, viewModel = viewModel)
                    }
                    composable("purchases"){
                        PurchasesScreen(navHostController = navController)
                    }
                }
            }
        }
    }
}
