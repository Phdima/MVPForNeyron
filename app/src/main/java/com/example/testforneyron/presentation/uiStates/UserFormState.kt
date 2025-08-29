package com.example.testforneyron.presentation.uiStates


data class UserFormState(
    val code: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val participantNumber: String = "",
    val isFocusedParticipant: Boolean = false,
    val isFocusedCode: Boolean = false,
    val isFocusedFirstName: Boolean = false,
    val isFocusedLastName: Boolean = false,
    val codeError: Boolean = false,
    val firstNameError: Boolean = false,
    val lastNameError: Boolean = false,
    val participantNumberError: Boolean = false
)