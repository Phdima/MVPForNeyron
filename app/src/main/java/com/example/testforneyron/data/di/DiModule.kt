package com.example.testforneyron.data.di

import com.example.testforneyron.data.repository.PurchaseRepoImpl
import com.example.testforneyron.domain.repository.PurchaseRepo
import com.example.testforneyron.domain.useCases.PurchaseUseCase
import com.example.testforneyron.presentation.viewModels.PurchaseViewModel
import org.koin.core.module.dsl.viewModel


import org.koin.dsl.module

val appModule = module {
    single<PurchaseRepo> { PurchaseRepoImpl(get()) }

    single { PurchaseUseCase(get()) }

    viewModel { PurchaseViewModel(get()) }
}