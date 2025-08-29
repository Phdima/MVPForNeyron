package com.example.testforneyron.presentation.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testforneyron.domain.model.User
import com.example.testforneyron.presentation.uiStates.UserFormState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserFormViewModel(

) : ViewModel() {

    var formState by mutableStateOf(UserFormState())
        private set

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user


    fun updateParticipantNumber(value: String) {
        val regex = Regex("^\\d{16}$")
        val isValid = value.matches(regex)

        formState = formState.copy(
            participantNumber = value,

            participantNumberError = !isValid
        )
    }

    fun updateCode(value: String) {
        formState = formState.copy(
            code = value,
            codeError = value.trim().isEmpty()
        )
    }

    fun updateFirstName(value: String) {
        formState = formState.copy(
            firstName = value,
            firstNameError = value.trim().isEmpty()
        )
    }

    fun updateLastName(value: String) {
        formState = formState.copy(
            lastName = value,
            lastNameError = value.trim().isEmpty()
        )
    }

    fun updateFocusCode(isFocused: Boolean) {
        formState = formState.copy(isFocusedCode = isFocused)
    }

    fun updateFocusFirstName(isFocused: Boolean) {
        formState = formState.copy(isFocusedFirstName = isFocused)
    }

    fun updateFocusLastName(isFocused: Boolean) {
        formState = formState.copy(isFocusedLastName = isFocused)
    }

    fun updateFocusParticipant(isFocused: Boolean) {
        formState = formState.copy(isFocusedParticipant = isFocused)
    }


    val isFormValid: Boolean
        get() = formState.code.trim().isNotEmpty() &&
                formState.firstName.trim().isNotEmpty() &&
                formState.lastName.trim().isNotEmpty() &&
                formState.participantNumber.matches(Regex("^\\d{16}$")) &&
                !formState.codeError &&
                !formState.firstNameError &&
                !formState.lastNameError &&
                !formState.participantNumberError


    fun saveUser() {
        viewModelScope.launch {
            _user.value = User(
                code = formState.code,
                firstName = formState.firstName,
                lastName = formState.lastName,
                participantNumber = formState.participantNumber
            )
        }
    }
}