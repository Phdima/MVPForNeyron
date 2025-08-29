package com.example.testforneyron.domain.model


data class User(
    val code: String,
    val firstName: String? = "Фамилия",
    val lastName: String? = "Имя",
    val participantNumber: String
)
